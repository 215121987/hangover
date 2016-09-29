package com.hangover.java.bl;

import com.hangover.java.dto.LoginStatusDTO;
import com.hangover.java.dto.StatusDTO;
import com.hangover.java.model.AddressEntity;
import com.hangover.java.model.UserEntity;
import com.hangover.java.model.type.LoginStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * UserEntity: Ashif.Qureshi
 * Date: 20/8/14
 * Time: 12:24 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserBL {

    UserEntity loadUserByUsername(String username) throws UsernameNotFoundException;
    
    boolean isEmailExist(String email, StatusDTO status);
    
    UserEntity authentication(String username, String password)throws UsernameNotFoundException, AuthenticationException;

    List<UserEntity> getUser();

    UserEntity getUser(Long id);

    UserEntity save(UserEntity userEntity, StatusDTO status);
    
    void delete(Long id);

    void updateProfile(String name, String value, Long id, StatusDTO status);

    LoginStatusDTO login(String username, String password, String deviceId);

    LoginStatusDTO createSession(String deviceId, UserEntity user);

    void logout(String deviceId);

    /*void forgotPassword(String username, StatusDTO status);*/

    void changePassword(String oldPassword, String password, String confirmPassword,Long id, StatusDTO status);

    void identify(String username, StatusDTO status);

    void sendOTP(String username, String requestFrom, StatusDTO status);

    void verifyUserName(String username,  String requestFrom, String otp, StatusDTO status);

    UserEntity validateAuthentication(String token);

    void save(AddressEntity address, StatusDTO statusDTO);
    
    List<AddressEntity> getUserAddress(Long userId, Map<String, Object> filterParam);

}
