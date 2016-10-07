package com.hangover.java.dao;

import com.hangover.java.model.OrderEntity;

/**
 * Created by IntelliJ IDEA.
 * User: ashifqureshi
 * Date: 13/07/15
 * Time: 2:57 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CommonDao extends BaseDao{



    OrderEntity getOrder(String orderNumber);

    OrderEntity getOrder(Long orderId);

}
