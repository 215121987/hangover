package com.hangover.java.service;

import com.hangover.java.bl.UserBL;
import com.hangover.java.dto.LoginStatusDTO;
import com.hangover.java.dto.StatusDTO;
import com.hangover.java.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: ashif
 * Date: 10/6/14
 * Time: 10:41 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
@Path("/ann")
@Transactional
public class AnonymousService extends BaseService{


    @Autowired
    private UserBL userBL;

    @POST
    @Path("/login")
    public Response login(@FormParam(PARAM_USERNAME) String username,
                          @FormParam(PARAM_USER_PASSWORD) String password,
                          @FormParam(PARAM_DEVICE_ID) String deviceId) {
        LoginStatusDTO loginStatusDTO = userBL.login(username, password, deviceId);
        return sendResponse(loginStatusDTO);
    }

    @GET
    @Path("/logout")
    public Response logout(@QueryParam("device_id") String deviceId) {
        userBL.logout(deviceId);
        return Response.ok().build();
    }


    @POST
    @Path("/register")
    public Response saveUser(@FormParam(PARAM_USER_EMAIL) String email,
                             @FormParam(PARAM_USER_PASSWORD) String password,
                             @FormParam(PARAM_USER_CONFIRM_PASSWORD) String confirmPassword,
                             @FormParam(PARAM_NAME) String name,
                             @FormParam(PARAM_DOB) String dob,
                             @FormParam(PARAM_MOBILE) String mobile,
                             @FormParam(PARAM_DEVICE_ID) String deviceId) {
        UserEntity user = new UserEntity();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        user.setConfirmPassword(confirmPassword);
        user.setDob(dob);
        user.setMobile(mobile);
        StatusDTO status = new StatusDTO();
        userBL.save(user, status);
        if(status.getCode() == HttpStatus.OK.value()){
            LoginStatusDTO loginStatusDTO = userBL.createSession( deviceId, user);
            return sendResponse(loginStatusDTO);
        }else
            return sendResponse(status);
    }

    @POST
    @Path("/help/identify")
    public Response identify(@FormParam(PARAM_USERNAME) String username) {
        StatusDTO status = new StatusDTO();
        userBL.identify(username, status);
        return sendResponse(status);
    }

    @GET
    @Path("/otp/send")
    public Response sendOTP(@QueryParam(PARAM_USERNAME) String username, @QueryParam(PARAM_DEVICE_ID) String deviceId) {
        StatusDTO status = new StatusDTO();
        userBL.sendOTP(username,deviceId, status);
        return sendResponse(status);
    }

    @POST
    @Path("/verify/email")
    public Response verifyUsername(@FormParam(PARAM_USERNAME) String username, @FormParam(PARAM_OTP) String otp,
                              @FormParam(PARAM_DEVICE_ID) String deviceId) {
        StatusDTO status = new StatusDTO();
        userBL.verifyEmail(username, deviceId, otp, status);
        return sendResponse(status);
    }

    @POST
    @Path("/verify/mobile")
    public Response verifyMobile(@FormParam(PARAM_USERNAME) String username, @FormParam(PARAM_OTP) String otp,
                                   @FormParam(PARAM_DEVICE_ID) String deviceId) {
        StatusDTO status = new StatusDTO();
        userBL.verifyMobile(username, deviceId, otp, status);
        return sendResponse(status);
    }
}
