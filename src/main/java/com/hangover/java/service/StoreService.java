package com.hangover.java.service;

import com.hangover.java.bl.CommonBL;
import com.hangover.java.bl.ShoppingBL;
import com.hangover.java.bl.StoreBL;
import com.hangover.java.dto.PlaceOrderDTO;
import com.hangover.java.dto.ShoppingDTO;
import com.hangover.java.dto.StatusDTO;
import com.hangover.java.model.OrderEntity;
import com.hangover.java.model.ShoppingCartItemEntity;
import com.hangover.java.model.SupplierStoreEntity;
import com.hangover.java.model.master.ServiceChargeEntity;
import com.hangover.java.model.type.OrderFrom;
import com.hangover.java.service.wso.CartWSO;
import com.hangover.java.service.wso.OrderWSO;
import com.hangover.java.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ashqures
 * Date: 8/26/16
 * Time: 12:53 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
@Path("/store")
@Transactional
public class StoreService extends BaseService {

    private Logger logger = LoggerFactory.getLogger(StoreService.class);

    private CommonBL commonBL;

    @Autowired(required = true)
    public void setCommonBL(CommonBL commonBL) {
        this.commonBL = commonBL;
    }

    private CommonUtil commonUtil;

    private ShoppingBL shoppingBL;

    @Autowired(required = true)
    public void setShoppingBL(ShoppingBL shoppingBL) {
        this.shoppingBL = shoppingBL;
    }

    @Autowired
    private StoreBL storeBL;

    @GET
    @Path("/item")
    public Response getShop(@Context UriInfo uriInfo) {
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
        if(null != shoppingCartItems)
            cartWSO.setCount(shoppingCartItems.size());
        return sendResponse(cartWSO);
    }

    @POST
    @Path("/cart")
    public Response addToCart(@FormParam("itemId")Long itemId, @FormParam("itemDetailId")Long itemDetailId, @FormParam("quantity")Integer quantity) {
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

    @GET
    @Path("/service/{zipCode}")
    public Response checkService(@PathParam("zipCode")String zipCode){
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("zipCode", zipCode);
        List<SupplierStoreEntity> stores  = commonBL.getEntities(SupplierStoreEntity.class, param);
        StatusDTO statusDTO = new StatusDTO();
        if(null== stores || stores.size()<=0){
            statusDTO.setCode(405);
            statusDTO.setMessage(commonUtil.getText("error.dont.have.service"));
        }
        return sendResponse(statusDTO);
    }

    @POST
    @Path("/order/place")
    public Response placeOrder(@FormParam("cartHash")String cartHas, @FormParam("amount")Double amount,
                               @FormParam("addressId")Long addressId) {
        Long userId= 1L;
        StatusDTO statusDTO = new StatusDTO();
        PlaceOrderDTO placeOrderDTO = new PlaceOrderDTO();
        placeOrderDTO.setUserId(userId);
        placeOrderDTO.setCartHash(cartHas);
        placeOrderDTO.setAddressId(addressId);
        placeOrderDTO.setOrderFrom(OrderFrom.APP);
        PlaceOrderDTO order = shoppingBL.placeOrder(placeOrderDTO, statusDTO);
        /*OrderWSO orderWSO = new OrderWSO();
        orderWSO.setOrderNumber(order.getOrderNumber());*/
        return sendResponse(order);
    }


    @GET
    @Path("/order")
    public Response getStoreOrder(){
        Long userId= 1L;
        List<OrderEntity> orders = storeBL.getStoreOrder(userId);
        return sendResponse(orders);
    }

    @GET
    @Path("/order/{id}")
    public Response getOrder(@PathParam("id") Long id){
        OrderEntity order = commonBL.getOrder(id);
        return sendResponse(order);
    }
    
}
