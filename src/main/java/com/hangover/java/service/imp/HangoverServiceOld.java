package com.hangover.java.service.imp;

import com.hangover.java.bl.CommonBL;
import com.hangover.java.bl.ShoppingBL;
import com.hangover.java.dto.ShoppingDTO;
import com.hangover.java.dto.StatusDTO;
import com.hangover.java.model.BaseEntity;
import com.hangover.java.model.ShoppingCartItemEntity;
import com.hangover.java.model.master.ServiceChargeEntity;
import com.hangover.java.model.type.Status;
import com.hangover.java.service.BaseService;
import com.hangover.java.service.wso.CartWSO;
import com.hangover.java.util.Constants;
import com.hangover.java.util.CustomClassMapperUtil;
import com.hangover.java.util.HangoverUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ashifqureshi
 * Date: 23/06/15
 * Time: 5:57 PM
 * To change this template use File | Settings | File Templates.
 */

@Component
@Path("/hangover")
@Transactional
public class HangoverServiceOld extends BaseService implements Constants {

    private Logger logger = LoggerFactory.getLogger(HangoverServiceOld.class);

    private CommonBL commonBL;

    @Autowired(required = true)
    public void setCommonBL(CommonBL commonBL) {
        this.commonBL = commonBL;
    }


    private ShoppingBL shoppingBL;

    @Autowired(required = true)
    public void setShoppingBL(ShoppingBL shoppingBL) {
        this.shoppingBL = shoppingBL;
    }

    @GET
    @Path("/shop")
    public Response getShop(UriInfo uriInfo) {
        Map<String, String> queryParam = getQueryParamAsStringMap(uriInfo);
        List entities  = shoppingBL.getItem(queryParam);
        return sendResponse(entities);
    }

    @GET
    @Path("/cart")
    public Response cart(@Context UriInfo uriInfo){
        Long userId= 1L;
        List<ShoppingCartItemEntity> shoppingCartItems = shoppingBL.getCartItem(userId);
        List<ServiceChargeEntity> serviceCharges = commonBL.getEntities(ServiceChargeEntity.class, null);
        CartWSO cartWSO = new CartWSO();
        cartWSO.setCartItems(shoppingCartItems);
        cartWSO.setServiceCharges(serviceCharges);
        return sendResponse(cartWSO);
    }

    @POST
    @Path("/cart")
    public Response addToCart(@FormParam("itemId")Long itemId, @FormParam("itemDetailId")Long itemDetailId, Integer quantity) {
        Long userId= 1L;
        StatusDTO statusDTO = new StatusDTO();
        ShoppingDTO shoppingDTO = new ShoppingDTO();
        shoppingDTO.setItemId(itemId);
        shoppingDTO.setItemDetailId(itemDetailId);
        shoppingDTO.setUserId(userId);
        shoppingDTO.setQuantity(quantity);
        List<ShoppingCartItemEntity> shoppingCartItems = shoppingBL.addItemToCart(shoppingDTO, statusDTO);
        CartWSO cartWSO = new CartWSO();
        cartWSO.setCount(shoppingCartItems.size());
        return sendResponse(cartWSO);
    }




    public Response getEntities(String className,  UriInfo uriInfo) throws IOException, ClassNotFoundException {
        Class clazz = CustomClassMapperUtil.getMappedClass(className);
        Map<String,Object> paramMap = getQueryParam(uriInfo);
        if(CustomClassMapperUtil.classHasField(clazz, "status")){
            paramMap.put("status", Status.ACTIVE);
        }
        List entities= commonBL.getEntities(clazz, paramMap);
        return sendResponse(entities);
    }

    public Response getEntity(String className,Long id, UriInfo uriInfo) throws IOException, ClassNotFoundException {
        Class clazz = CustomClassMapperUtil.getMappedClass(className);
        BaseEntity entity = commonBL.getEntity(clazz,id);
        return sendResponse(entity);
    }

    public Response getEntityByAssociatedEntity(String className,   String associatedProp, Long id, UriInfo uriInfo) throws IOException, ClassNotFoundException {
        Class clazz = CustomClassMapperUtil.getMappedClass(className);
        List entities = commonBL.getEntities(clazz, associatedProp, id);
        if(null!= entities && entities.size()>0){
            HangoverUtil.initializeAssociatedEntity(entities, associatedProp);
        }
        return sendResponse(entities);
    }

    public Response deleteEntity(String className,  Long id,  UriInfo uriInfo) throws IOException, ClassNotFoundException {
        StatusDTO statusDTO = new StatusDTO();
        commonBL.delete(className, id, statusDTO);
        return sendResponse(statusDTO);
    }





    /*public Response postEntity(String className,  UriInfo uriInfo) {
        return null;
    }*/

    /*public Response postEntityAsObject(BaseEntity baseEntity, @Context UriInfo uriInfo){
        logger.info(baseEntity.toString());
        return null;
    }*/

    public Response updateEntity(String className,  Long id,  UriInfo uriInfo) throws IOException, ClassNotFoundException {
        Class clazz = CustomClassMapperUtil.getMappedClass(className);
        return null;
    }


}
