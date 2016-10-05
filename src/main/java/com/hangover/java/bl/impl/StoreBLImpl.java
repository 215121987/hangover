package com.hangover.java.bl.impl;

import com.hangover.java.bl.StoreBL;
import com.hangover.java.model.OrderEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashqures
 * Date: 10/5/16
 * Time: 9:00 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository("storeBL")
@Transactional
public class StoreBLImpl implements StoreBL {


    @Override
    public List<OrderEntity> getOrder(Long storeId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
