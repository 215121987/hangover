package com.hangover.java.service;

import com.hangover.java.bl.CommonBL;
import com.hangover.java.bl.UserBL;
import com.hangover.java.dto.StatusDTO;
import com.hangover.java.exception.HangoverException;
import com.hangover.java.model.AddressEntity;
import com.hangover.java.model.UserEntity;
import com.hangover.java.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * UserEntity: Ashif.Qureshi
 * Date: 20/8/14
 * Time: 12:25 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
@Path("/user")
@Transactional
public class UserService extends BaseService{

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    private CommonBL commonBL;

    @Autowired(required = true)
    public void setCommonBL(CommonBL commonBL) {
        this.commonBL = commonBL;
    }

    private UserBL userBL;

    @Autowired(required = true)
    public void setUserBL(UserBL userBL) {
        this.userBL = userBL;
    }


    @GET
    public Response users(@Context UriInfo uriInfo) {
        List<Object> objects = null;//getActivityBL().getActivity(startDate);
        GenericEntity entity = new GenericEntity<List<Object>>(objects) {
        };
        return Response.ok(entity).build();
    }

    @GET
    @Path("profile")
    public Response getProfile(@Context UriInfo uriInfo) {
        Long userId = 1L;
        return Response.ok(getUserBL().getUser(userId)).build();
    }


    @PUT
    @Path("profile")
    public Response updateProfile(@Context UriInfo uriInfo) {
        MultivaluedMap<String, String> requestData = uriInfo.getQueryParameters();
        if (null != requestData && requestData.containsKey(PARAM_NAME)) {
            StatusDTO status = new StatusDTO();
            getUserBL().updateProfile(requestData.getFirst(PARAM_NAME),
                    requestData.getFirst(PARAM_VALUE), getUser().getId(), status);
            return status.getCode()==HttpStatus.OK.value()?Response.ok().build()
                    :Response.status(status.getCode()).entity(status).build();
        }
        throw new HangoverException(HttpStatus.BAD_REQUEST.value());
    }

    @POST
    @Path("/change/password")
    public Response identify(@FormParam(PARAM_USER_OLD_PASSWORD) String oldPassword,
                             @FormParam(PARAM_USER_PASSWORD) String password,
                             @FormParam(PARAM_USER_CONFIRM_PASSWORD) String confirmPassword) {
        StatusDTO statusDTO = new StatusDTO();
        getUserBL().changePassword(oldPassword, password, confirmPassword,getUser().getId(), statusDTO);
        return sendResponse(statusDTO);
    }



    @GET
    @Path("/address")
    public Response getAddress(@Context UriInfo uriInfo) {
        Map<String,Object> paramMap = getQueryParam(uriInfo);
        List<AddressEntity> addresses = userBL.getUserAddress(1l, paramMap);
        return sendResponse(addresses);
    }

    @POST
    @Path("/address")
    public Response saveAddress(@FormParam(PARAM_ADDRESS)String address, @FormParam(PARAM_STREET)String street, @FormParam(PARAM_CITY)String city,
                                @FormParam(PARAM_STATE)String state, @FormParam(PARAM_COUNTRY)String country, @FormParam(PARAM_ZIPCODE)String zipCode,
                                @FormParam(PARAM_LATITUDE)String latitude, @FormParam(PARAM_LONGITUDE)String longitude,
                                @Context UriInfo uriInfo) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddress(address);
        addressEntity.setStreet(street);
        addressEntity.setCity(city);
        addressEntity.setState(state);
        addressEntity.setCountry(country);
        addressEntity.setZipCode(zipCode);
        addressEntity.setLatitude(latitude);
        addressEntity.setLongitude(longitude);
        addressEntity.setUser(UserEntity.getUser(1L));
        StatusDTO statusDTO = new StatusDTO();
        userBL.save(addressEntity, statusDTO);
        if(HttpStatus.OK.value() == statusDTO.getCode())
            return sendResponse(addressEntity);
        else
            return sendResponse(statusDTO);
    }

}
