package com.hangover.java.dao.impl;

import com.hangover.java.dao.StoreDao;
import com.hangover.java.model.LoginStatusEntity;
import com.hangover.java.model.OrderEntity;
import com.hangover.java.model.SupplierStaffEntity;
import com.hangover.java.model.SupplierStoreEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashqures
 * Date: 10/5/16
 * Time: 10:21 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository("storeDao")
public class StoreDaoImpl extends BaseDaoImpl implements StoreDao {


    @Override
    public SupplierStoreEntity getStaffStore(Long staffId) {
        Criteria criteria = getCurrentSession().createCriteria(SupplierStaffEntity.class)
                .createAlias("user", "user")
                .add(Restrictions.eq("user.id", staffId))
                .setProjection(Projections.projectionList().add(Projections.property("store")));
        return (SupplierStoreEntity)criteria.uniqueResult();
    }

    @Override
    public List<OrderEntity> getStoreOrder(Long storeId) {
        Criteria criteria = getCurrentSession().createCriteria(OrderEntity.class)
                .createAlias("store", "store")
                .add(Restrictions.eq("store.id", storeId));
        return criteria.list();
    }

    @Override
    public List<SupplierStoreEntity> getStoreByLocation(String zipCode) {
        Criteria criteria = getCurrentSession().createCriteria(SupplierStoreEntity.class)
                .add(Restrictions.eq("zipCode", zipCode));
        return criteria.list();
    }

    @Override
    public List<LoginStatusEntity> getAvailableStoreStaff(Long storeId) {
        Criteria criteria  = getCurrentSession().createCriteria(LoginStatusEntity.class)
                .createAlias("store","store")
                .add(Restrictions.eq("store.id", storeId));
        return criteria.list();
    }
}
