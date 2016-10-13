package com.hangover.java.service.imp;

import com.hangover.java.dto.StatusDTO;
import com.hangover.java.exception.HangoverException;
import com.hangover.java.service.BaseService;
import com.hangover.java.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * UserEntity: Ashif.Qureshi
 * Date: 20/8/14
 * Time: 12:26 PM
 * To change this template use File | Settings | File Templates.
 */
@Path("/user-1")
@Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
public class UserServiceOld extends BaseService {

    private Logger logger = LoggerFactory.getLogger(UserServiceOld.class);

    /*public UserServiceOld(@Context SecurityContext security) {
        super(security);
    }*/

    @GET
    public Response dashBoard(@QueryParam(PARAM_START_DATE) Date startDate) {
        List<Object> objects = null;//getActivityBL().getActivity(startDate);
        GenericEntity entity = new GenericEntity<List<Object>>(objects) {
        };
        return Response.ok(entity).build();
    }

    @GET
    @Path("profile")
    public Response getProfile(@QueryParam("id") Long id) {
        //if (null == id)
            /*id = getUser().getId();*/
        return null;//Response.ok(getUserBL().getUser(id)).build();
    }


    @PUT
    @Path("profile")
    public Response updateProfile(@Context UriInfo uriInfo) {
        MultivaluedMap<String, String> requestData = uriInfo.getQueryParameters();
        if (null != requestData && requestData.containsKey(PARAM_NAME)) {
            StatusDTO status = new StatusDTO();
            /*getUserBL().updateProfile(requestData.getFirst(PARAM_NAME),
                    requestData.getFirst(PARAM_VALUE), getUser().getId(), status);*/
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
        /*getUserBL().changePassword(oldPassword, password, confirmPassword,getUser().getId(), statusDTO);*/
        return sendResponse(statusDTO);//Response.status(status.getCode()).entity(status).build();
    }

}
