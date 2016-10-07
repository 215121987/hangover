package com.hangover.java.bl.impl;

import com.hangover.java.bl.StoreBL;
import com.hangover.java.dao.CommonDao;
import com.hangover.java.dao.StoreDao;
import com.hangover.java.model.OrderEntity;
import com.hangover.java.model.SupplierStaffEntity;
import com.hangover.java.model.SupplierStoreEntity;
import org.springframework.beans.factory.annotation.Autowired;
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
public class StoreBLImpl extends BaseBL implements StoreBL {


    @Autowired
    private CommonDao commonDao;

    @Autowired
    private StoreDao storeDao;

    @Override
    public List<OrderEntity> getStoreOrder(Long staffId) {
        SupplierStoreEntity store = storeDao.getStaffStore(staffId);
        return storeDao.getStoreOrder(store.getId());
    }
}
