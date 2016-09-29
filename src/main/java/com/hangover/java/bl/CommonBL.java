package com.hangover.java.bl;

import com.hangover.java.dto.StatusDTO;
import com.hangover.java.model.BaseEntity;
import com.hangover.java.model.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ashifqureshi
 * Date: 13/07/15
 * Time: 2:53 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CommonBL {

    void executeSQLQueryUpdate(String sqlQuery);
    
    void saveEntity(Object entity, StatusDTO statusDTO);

    <T extends BaseEntity> T getEntity(Class<T> clazz, Long id);

    <T extends BaseEntity> List<T> getEntities(Class<T> clazz, String associatedProp, Long id);

    <T extends BaseEntity> List<T> getEntities(Class<T> clazz, Map<String, Object> paramMap);

    <T extends BaseEntity> T updateEntity(Class<T> entity, Long id, Map<String,Object> paramMap);

    void deleteEntity(Object object);

    void delete(String className, Long id, StatusDTO statusDTO);

    void softDelete(Class clazz, Long id);

    void initializeAssociatedEntity(UserEntity baseEntity);
}
