package com.hangover.java.dao;

import com.hangover.java.model.LoginStatusEntity;
import com.hangover.java.model.OrderEntity;
import com.hangover.java.model.SupplierStaffEntity;
import com.hangover.java.model.SupplierStoreEntity;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashqures
 * Date: 10/5/16
 * Time: 10:21 PM
 * To change this template use File | Settings | File Templates.
 */
public interface StoreDao extends BaseDao{
    
    
    SupplierStoreEntity getStaffStore(Long staffId);
    
    List<OrderEntity> getStoreOrder(Long storeId);

    List<SupplierStoreEntity> getStoreByLocation(String zipCode);
    
    List<LoginStatusEntity> getAvailableStoreStaff(Long storeId);
}
