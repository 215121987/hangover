package com.hangover.java.dao.impl;

import com.hangover.java.dao.CommonDao;
import com.hangover.java.model.BaseEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashifqureshi
 * Date: 13/07/15
 * Time: 2:58 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository("commonDao")
public class CommonDaoImpl extends BaseDaoImpl implements CommonDao {

    public void deleteFloorDetails(Long floorId, int version) {
        String hql = "delete from FloorDesignDetailsEntity fdd where fdd.floor.id in (from FloorEntity f where f.id=:floorId and f.designStatus=:designStatus)";
        Query query = getCurrentSession().createQuery(hql);
        query.setLong("floorId", floorId);
        //query.setParameter("designStatus", DesignStatus.Space_Design_Uploaded);
        query.executeUpdate();
    }



}
