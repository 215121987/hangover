package com.hangover.java.model;

import com.hangover.java.model.type.OrderFrom;
import com.hangover.java.model.type.OrderState;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: ashqures
 * Date: 2/10/16
 * Time: 4:55 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@javax.persistence.Table(name = "order_entity")
@XmlRootElement(name = "order")
public class OrderEntity extends BaseEntity{

    private String orderNumber;
    private UserEntity customer;
    private Double totalAmount;
    private OrderFrom orderFrom;
    private AddressEntity address;
    Set<OrderItemEntity> orderItem;
    private OrderState state = OrderState.ORDER_CREATED;

    @Column(name = "order_number", nullable = false, unique = true, updatable = false)
    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    public UserEntity getCustomer() {
        return customer;
    }

    public void setCustomer(UserEntity customer) {
        this.customer = customer;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Enumerated
    @Column(name = "order_from")
    public OrderFrom getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(OrderFrom orderFrom) {
        this.orderFrom = orderFrom;
    }

    @ManyToOne
    @JoinColumn(name = "shipping_address_id")
    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    public Set<OrderItemEntity> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(Set<OrderItemEntity> orderItem) {
        this.orderItem = orderItem;
    }

    public void addOrderItem(OrderItemEntity orderItem){
        if(null == getOrderItem())
            setOrderItem(new HashSet<OrderItemEntity>());
        getOrderItem().add(orderItem);
    }

    @Enumerated
    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }
}
