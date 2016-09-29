package com.hangover.java.dto;

import com.hangover.java.model.type.OrderFrom;

/**
 * Created by IntelliJ IDEA.
 * User: ashqures
 * Date: 9/2/16
 * Time: 12:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class PlaceOrderDTO {
    
    private Long userId;
    private String cartHash;
    private Long addressId;
    private OrderFrom orderFrom;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCartHash() {
        return cartHash;
    }

    public void setCartHash(String cartHash) {
        this.cartHash = cartHash;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public OrderFrom getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(OrderFrom orderFrom) {
        this.orderFrom = orderFrom;
    }
}
