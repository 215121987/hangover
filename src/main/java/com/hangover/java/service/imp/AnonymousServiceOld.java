package com.hangover.java.service.imp;


import com.hangover.java.bl.CommonBL;
import com.hangover.java.bl.UserBL;
import com.hangover.java.dto.LoginStatusDTO;
import com.hangover.java.dto.StatusDTO;
import com.hangover.java.model.UserEntity;
import com.hangover.java.service.BaseService;
import com.hangover.java.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by IntelliJ IDEA.
 * User: ashif
 * Date: 10/6/14
 * Time: 10:42 PM
 * To change this template use File | Settings | File Templates.
 */
@Path("/ann-1")
@Component
@Transactional
@Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
public class AnonymousServiceOld extends BaseService  {

    @Autowired
    private UserBL userBL;

    @POST
    @Path("/login")
    public Response login(@FormParam(PARAM_USERNAME) String username,
                          @FormParam(PARAM_USER_PASSWORD) String password,
                          @FormParam(PARAM_DEVICE_ID) String deviceId) {
        LoginStatusDTO loginStatusDTO = userBL.login(username, password, deviceId);
        return Response.ok().entity(loginStatusDTO).build();
    }

    @GET
    @Path("/logout")
    public Response logout(@QueryParam("device_id") String deviceId) {
        userBL.logout(deviceId);
        return Response.ok().build();
    }


    @POST
    @Path("/register")
    public Response saveUser(@FormParam(PARAM_USERNAME) String username,
                             @FormParam(PARAM_USER_PASSWORD) String password,
                             @FormParam(PARAM_USER_CONFIRM_PASSWORD) String confirmPassword,
                             @FormParam(PARAM_NAME) String name,
                             @FormParam(PARAM_MOBILE) String mobile,
                             @FormParam(PARAM_DEVICE_ID) String deviceId) {
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setName(name);
        user.setPassword(password);
        user.setConfirmPassword(confirmPassword);
        user.setMobile(mobile);
        StatusDTO status = new StatusDTO();
        userBL.save(user, status);
        if(status.getCode() == HttpStatus.OK.value()){
            LoginStatusDTO loginStatusDTO = userBL.login(username, password, deviceId);
            return Response.ok().entity(loginStatusDTO).build();
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
}
