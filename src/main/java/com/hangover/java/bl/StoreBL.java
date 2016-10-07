package com.hangover.java.bl;

import com.hangover.java.model.OrderEntity;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashqures
 * Date: 10/5/16
 * Time: 8:59 PM
 * To change this template use File | Settings | File Templates.
 */
public interface StoreBL {


    List<OrderEntity> getStoreOrder(Long staffId);



}
