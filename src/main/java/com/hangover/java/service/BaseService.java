package com.hangover.java.service;

import com.hangover.java.bl.CommonBL;
import com.hangover.java.bl.ShoppingBL;
import com.hangover.java.bl.UserBL;
import com.hangover.java.service.wso.ContainerWSO;
import com.hangover.java.dto.StatusDTO;
import com.hangover.java.model.BaseEntity;
import com.hangover.java.model.UserEntity;
import com.hangover.java.util.ApplicationContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

import javax.ws.rs.Produces;
import javax.ws.rs.core.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * UserEntity: Ashif.Qureshi
 * Date: 25/8/14
 * Time: 12:31 PM
 * To change this template use File | Settings | File Templates.
 */
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class BaseService implements ServiceConstants{

    private UserEntity user;

    private UserBL userBL;

    /*private CommonBL commonBL;*/

    @Autowired(required = true)
    public void setUserBL(UserBL userBL) {
        this.userBL = userBL;
    }

    /*@Autowired(required = true)
    public void setCommonBL(CommonBL commonBL) {
        this.commonBL = commonBL;
    }*/

    /*public BaseService(@Context SecurityContext security) {
        this.user = (UserEntity)security.getUserPrincipal();
        //this.user=new UserEntity();
        //getUser().setId(1l);
    }*/

    protected UserEntity getUser() {
        return user;
    }

    protected boolean isUserInRole(String roleName){
        return getUser().isUserInRole(roleName);
    }



    protected UserBL getUserBL() {
        //return (UserBL)ApplicationContextUtil.getApplicationContext().getBean("userBL");
        return userBL;
    }


    protected CommonBL getCommonBL() {
       return (CommonBL)ApplicationContextUtil.getApplicationContext().getBean("commonBL");
        //return null;
    }

    protected ShoppingBL getShoppingBL() {
        return (ShoppingBL)ApplicationContextUtil.getApplicationContext().getBean("shoppingBL");
        //return null;
    }
    
    
    protected Map<String,Object> getQueryParam(UriInfo uriInfo){
        MultivaluedMap<String, String> requestData = uriInfo.getQueryParameters();
        Map<String,Object> queryParamMap = new HashMap<String, Object>();
        for(String key :  requestData.keySet()){
            queryParamMap.put(key,requestData.getFirst(key));
        }
        return queryParamMap;
    }


    protected Map<String,String> getQueryParamAsStringMap(UriInfo uriInfo){
        MultivaluedMap<String, String> requestData =  uriInfo.getQueryParameters();
        Map<String,String> queryParamMap = new HashMap<String, String>();
        for(String key :  requestData.keySet()){
            queryParamMap.put(key,requestData.getFirst(key));
        }
        return queryParamMap;
    }


    protected  Response sendResponse(BaseEntity item) {
        ContainerWSO containerWSO = new ContainerWSO();
        containerWSO.addItems(item);
        return Response.ok(containerWSO).build();
    }

    protected Response sendResponse(List items) {
        ContainerWSO containerWSO = new ContainerWSO();
        containerWSO.setItems(items);
        return sendResponse(containerWSO);
    }

    protected Response sendResponse(Object object) {
        return Response.ok(object).build();
    }


    protected  Response sendResponse(StatusDTO statusDTO) {
        return Response.status(statusDTO.getCode()).entity(statusDTO).build();
    }

}
