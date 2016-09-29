package com.hangover.java.notification;

import com.hangover.java.dao.UserDao;
import com.hangover.java.model.OTPEntity;
import com.hangover.java.model.UserEntity;
import com.hangover.java.model.type.PasswordType;
import com.hangover.java.security.PasswordEncoder;
import com.hangover.java.util.CommonUtil;
import com.hangover.java.util.Constants;
import com.hangover.java.util.HangoverUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ashqures
 * Date: 9/2/16
 * Time: 4:21 PM
 * To change this template use File | Settings | File Templates.
 */
@Component("emailFactory")
@Transactional
public class EmailFactory {
    
    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private CommonUtil commonUtil;

    public Message getResetPasswordMessage(String username){
        Message message = new Message();
        message.setTo(username);
        message.setTemplateName(Constants.FORGOT_PASSWORD_TEMPLATE);
        message.setSubject(commonUtil.getText("email.notification.subject.forgot.password"));
        UserEntity user = userDao.getUserByUsername(username);
        message.putContext("name", user.getName());
        String temPassword ="Welcome123";// HangoverUtil.getAlphaNumeric(6);
        user.setPassword(passwordEncoder.encode(temPassword));
        user.setPasswordType(PasswordType.TEMPORARY);
        message.putContext("password", temPassword);
        userDao.save(user);
        return message;
    }

    public Message getRegistrationMessage(Map<String,String> map){
        Message message = new Message();
        message.setTo(map.get("username"));
        message.setTemplateName(Constants.NOTIFICATION_MAIL_TEMPLATE);
        message.setSubject(commonUtil.getText("email.notification.subject.register.user"));
        UserEntity user = userDao.getUserByUsername(map.get("username"));
        message.putContext("name", user.getName());
        message.putContext("username", map.get("username"));
        message.putContext("password", map.get("password"));
        message.putContext("login_url", commonUtil.getText("application.login.url"));
        return message;
    }

    public Message getOTPMessage(Map<String,String> map){
        Message message = new Message();
        message.setTo(map.get("username"));
        message.setTemplateName(Constants.OTP_TEMPLATE);
        message.setSubject(commonUtil.getText("email.notification.subject.otp"));
        UserEntity user = userDao.getUserByUsername(map.get("username"));
        message.putContext("name", user.getName());
        String otp =HangoverUtil.getAlphaNumeric(4);
        message.putContext("otp", otp);
        OTPEntity otpEntity = new OTPEntity();
        otpEntity.setUser(user);
        otpEntity.setOtp(otp);
        otpEntity.setSendTo(map.get("username"));
        otpEntity.setRequestedFrom(map.get("requestedFrom"));
        userDao.save(otpEntity);
        return message;
    }
    
}
