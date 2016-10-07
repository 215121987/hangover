package com.hangover.java.bl.impl;

import com.hangover.java.bl.UserBL;
import com.hangover.java.dao.CommonDao;
import com.hangover.java.dao.UserDao;
import com.hangover.java.dto.LoginStatusDTO;
import com.hangover.java.dto.StatusDTO;
import com.hangover.java.exception.*;
import com.hangover.java.exception.AuthenticationException;
import com.hangover.java.model.*;
import com.hangover.java.model.type.LoginStatus;
import com.hangover.java.model.type.PasswordType;
import com.hangover.java.task.AsyncTask;
import com.hangover.java.security.PasswordEncoder;
import com.hangover.java.task.HangoverBeans;
import com.hangover.java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * UserEntity: Ashif.Qureshi
 * Date: 20/8/14
 * Time: 12:25 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository("userBL")
@Transactional
public class UserBLImpl extends BaseBL implements UserBL, UserDetailsService, Constants {

    private Logger logger = LoggerFactory.getLogger(UserBLImpl.class);

    @Autowired
    private UserDao userDao;
    
    
    @Autowired
    private CommonDao commonDao;

    @Autowired
    private ValidatorUtil validatorUtil;

    @Autowired
    private CommonUtil commonUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private HangoverBeans hangoverBeans;


    @Autowired
    private AsyncTask asyncTask;

    @Autowired
    private TaskExecutor taskExecutor;

    public UserEntity loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity users = userDao.getUserByUsername(username);
        if (null == users)
            throw new UsernameNotFoundException(commonUtil.getText("404.username.no.record.found", username));
        /*TODO need to handle lazy things*/
        HangoverUtil.initializeAssociatedEntity(users, "roles");
        return users;
    }

    @Override
    public boolean isEmailExist(String email, StatusDTO status) {
        UserEntity user = userDao.getUserByUsername(email);
        if(null!= user){
            status.setMessage(commonUtil.getText("error.email.already.exist",email, status.getLocale()));
            saveErrorMessage(status, HttpStatus.CONFLICT.value());
            return false;
        }
        return true;
    }

    @Override
    public UserEntity authentication(String username, String password) throws UsernameNotFoundException, AuthenticationException {
        UserEntity user = loadUserByUsername(username);
        if(!passwordEncoder.isPasswordValid(password, user.getPassword(), null)){
            throw new BadCredentialsException(commonUtil.getText("error.credential.invalid"));
        }
        return user;
    }

    public List<UserEntity> getUser() {
        return userDao.getUser();
    }

    public UserEntity getUser(Long id) {
        UserEntity userEntity = userDao.getUser(id);
        if (null == userEntity)
            throw new NoRecordFoundException(commonUtil.getText("404.user.no.record.found", id + ""));
        return userEntity;
    }

    public UserEntity save(UserEntity user, StatusDTO status) {
        validatorUtil.validate(user, status);
        if (status.hasError()) {
            saveErrorMessage(status, HttpStatus.BAD_REQUEST.value());
            return user;
        }
        HangoverUtil.processRole(user);
        user.setUsername(user.getEmail());
        user.setPassword(passwordEncoder.encodePassword(user.getPassword(), null));
        try {
            boolean isRegister = null == user.getId();
            userDao.saveUser(user);
            if(isRegister){
                Map<String,String> map = new HashMap<String, String>();
                map.put("username", user.getUsername());
                map.put("password", user.getConfirmPassword());
                this.taskExecutor.execute(this.asyncTask.getRegisterNotificationTask(map));
            }
            saveSuccessMessage(status, commonUtil.getText("success.save", status.getLocale()));
        } catch (DuplicateObjectException e) {
            user.setPassword(user.getConfirmPassword());
            status.setCode(HttpStatus.CONFLICT.value());
            status.setMessage(commonUtil.getText("error.email.or.mobile.already.exist",
                    new Object[]{user.getEmail(),user.getMobile()}, status.getLocale()));
        }
        return user;
    }

    @Override
    public void delete(Long id) {
        UserEntity userEntity = userDao.getUser(id);
        userEntity.setEnabled(false);
        userDao.save(userEntity);
    }

    public void updateProfile(String name, String value, Long id, StatusDTO status) {
        validatorUtil.validateUserUpdateAbleFiled(name, value, status);
        if (status.hasError()) {
            saveErrorMessage(status, HttpStatus.BAD_REQUEST.value());
            return;
        }
        try {
            userDao.updateProfile(name, value, id);
        } catch (SQLException e) {
            throw new HangoverException(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }



    public LoginStatusDTO login(String username, String password, String deviceId) {
        if (ValidatorUtil.isNullOrEmpty(username) || ValidatorUtil.isNullOrEmpty(password)
                || ValidatorUtil.isNullOrEmpty(deviceId))
            throw new HangoverException(HttpStatus.NON_AUTHORITATIVE_INFORMATION.value(),
                    commonUtil.getText("error.email.password.deviceId.must.be.provide"));
        UserEntity user = loadUserByUsername(username);
        if (!passwordEncoder.isPasswordValid(password,user.getPassword(), null))
            throw new AuthenticationException("Invalid credential");
        Map<String,Object> criteriaMap = new HashMap<String, Object>();
        criteriaMap.put("deviceId", deviceId);
        Map<String,Object> valueMap = new HashMap<String, Object>();
        valueMap.put("loginStatus",LoginStatus.TERMINATED.ordinal());
        commonDao.update(LoginStatusEntity.class, valueMap, criteriaMap);
        /*LoginStatusEntity loginStatus = new LoginStatusEntity();
        loginStatus.setDeviceId(deviceId);
        loginStatus.setToken(generateToken(deviceId));
        loginStatus.setUser(user);
        List<SupplierStaffEntity> supplierStaff = commonDao.gets(SupplierStaffEntity.class,"user", user.getId());
        if(null!=supplierStaff && supplierStaff.size()>0){
            loginStatus.setSupplierStore(supplierStaff.get(0).getStore());
        }
        userDao.save(loginStatus);*/
        return createSession(deviceId, user);//new LoginStatusDTO(loginStatus);
    }
    
    public LoginStatusDTO createSession(String deviceId, UserEntity user){
        LoginStatusEntity loginStatus = new LoginStatusEntity();
        loginStatus.setDeviceId(deviceId);
        loginStatus.setToken(generateToken(deviceId));
        loginStatus.setUser(user);
        List<SupplierStaffEntity> supplierStaff = commonDao.gets(SupplierStaffEntity.class,"user", user.getId());
        if(null!=supplierStaff && supplierStaff.size()>0){
            loginStatus.setStore(supplierStaff.get(0).getStore());
        }
        userDao.save(loginStatus);
        return new LoginStatusDTO(loginStatus);
    }

    public void logout(String deviceId) {
        Map<String,Object> criteriaMap = new HashMap<String, Object>();
        criteriaMap.put("deviceId", deviceId);
        Map<String,Object> valueMap = new HashMap<String, Object>();
        valueMap.put("loginStatus",LoginStatus.LOGOUT);
        commonDao.update(LoginStatusEntity.class, valueMap, criteriaMap);
    }
    
    /*public void forgotPassword(String username, StatusDTO status){
        UserEntity user = userDao.getUserByUsername(username);
        if (null == user) {
            status.setError(commonUtil.getText("404.username.no.record.found", username));
            saveErrorMessage(status, HttpStatus.NOT_FOUND.value());
            return;
        }
        String password = HangoverUtil.getTempPassword();
        user.setPassword(passwordEncoder.encodePassword(password, null));
        user.setUpdatedAt(new Date());
        user.setPasswordType(PasswordType.TEMPORARY);
        userDao.save(user);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("name", user.getName());
        map.put("password", password);
        //taskExecutor = (TaskExecutor)ApplicationContextUtil.getApplicationContext().getBean("taskExecutor");
        //new NotifyUserTask(hangoverBeans).notifyUserPassword(map, user.getUsername());
        taskExecutor.execute(new NotificationTask(username, MessageType.RESET_PASSWORD));
        saveSuccessMessage(status, commonUtil.getText("success.send.new.password", status.getLocale()));
    }*/

    public void changePassword(String oldPassword, String password, String confirmPassword, Long userId, StatusDTO status) {
        validatorUtil.validatePassword(password, confirmPassword, status);
        if (status.hasError()) {
            saveErrorMessage(status, HttpStatus.BAD_REQUEST.value());
            return;
        }
        UserEntity userEntity = userDao.getUser(userId);
        if (userEntity.getPasswordType().equals(PasswordType.PERMANENT)) {
            if (ValidatorUtil.isNullOrEmpty(oldPassword)) {
                status.addError(commonUtil.getText("error.old.password.required", status.getLocale()));
                saveErrorMessage(status, HttpStatus.BAD_REQUEST.value());
                return;
            }
            if (!passwordEncoder.isPasswordValid(userEntity.getPassword(), oldPassword, null))
                throw new HangoverException(HttpStatus.PRECONDITION_FAILED.value(), commonUtil.getText("error.existing.password.wrong"));
        }
        userEntity.setPassword(passwordEncoder.encodePassword(password, null));
        userEntity.setUpdatedAt(new Date());
        userEntity.setPasswordType(PasswordType.PERMANENT);
        userDao.save(userEntity);
        saveSuccessMessage(status, commonUtil.getText("success.update", status.getLocale()));
    }


    public void identify(String username, StatusDTO status)throws UsernameNotFoundException{
        UserEntity user = userDao.getUserByUsername(username);
        if(null == user){
            throw new UsernameNotFoundException(commonUtil.getText("404.username.no.record.found", username));
        }
        this.taskExecutor.execute(this.asyncTask.getPasswordNotificationTask(username));
        saveSuccessMessage(status, commonUtil.getText("password.reset.successfully.check.amil"));
    }

    @Override
    public void sendOTP(String username, String requestFrom, StatusDTO status) {
        Map<String,String> map = new HashMap<String, String>();
        map.put("username", username);
        map.put("requestedFrom", requestFrom);
        this.taskExecutor.execute(this.asyncTask.getOTPNotificationTask(map));
        saveSuccessMessage(status, commonUtil.getText("password.reset.successfully.check.amil"));
    }

    @Override
    public void verifyUserName(String username, String requestFrom,  String otp, StatusDTO status) {
        OTPEntity otpEntity = userDao.getOTP(username, otp);
        if(null== otpEntity){
            status.setCode(HttpStatus.FORBIDDEN.value());
            status.setMessage(commonUtil.getText("error.invalid.otp"));
        }else{
            otpEntity.setInValidate(true);
            otpEntity.setVerifiedFrom(requestFrom);
            UserEntity user = otpEntity.getUser();
            user.setUsernameVerified(true);
            userDao.save(user);
            userDao.save(otpEntity);
            status.setCode(HttpStatus.OK.value());
            saveSuccessMessage(status, commonUtil.getText("success.otp.verified"));
        }
    }

    private String generateToken(String deviceId) {
        String raw = deviceId + new Date().toString();
        return passwordEncoder.encodePassword(raw, null);
    }

    public UserEntity validateAuthentication(String token) {
        LoginStatusEntity loginStatus = userDao.getLoginStatus(token);
        if (null == loginStatus)
            throw new AuthenticationException("Invalid credential");
        if (loginStatus.getLoginStatus().equals(LoginStatus.LOGIN)) {
            loginStatus.setUpdatedAt(new Date());
            userDao.save(loginStatus);
        } else {
            throw new HangoverException(HttpStatus.MOVED_TEMPORARILY.value(), commonUtil.getText("302.session.message"));
        }

        return loginStatus.getUser();
    }

    @Override
    public void save(AddressEntity address, StatusDTO statusDTO) {
        userDao.save(address);
        saveSuccessMessage(statusDTO, "");
    }

    @Override
    public List<AddressEntity> getUserAddress(Long userId, Map<String, Object> filterParam) {
        filterParam.put("user.id", userId);
        return userDao.gets(AddressEntity.class, filterParam);
    }
}
