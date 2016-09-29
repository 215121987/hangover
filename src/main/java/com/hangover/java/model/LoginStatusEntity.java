package com.hangover.java.model;

import com.hangover.java.model.type.LoginStatus;
import com.hangover.java.model.type.Status;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ashif
 * Date: 10/7/14
 * Time: 10:10 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "login_status")
/*@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)*/
public class LoginStatusEntity extends BaseEntity{

    private String deviceId;
    private String token;
    private UserEntity user;
    private SupplierStoreEntity supplierStore;
    private LoginStatus loginStatus = LoginStatus.LOGIN;


    @Column(name = "device_id", nullable = false, updatable = false)
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Column(name = "token", nullable = false, updatable = false)
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false, updatable = false, referencedColumnName = "id")
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "supplier_store_id",nullable = true, updatable = false)
    public SupplierStoreEntity getSupplierStore() {
        return supplierStore;
    }

    public void setSupplierStore(SupplierStoreEntity supplierStore) {
        this.supplierStore = supplierStore;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "login_status", nullable = false)
    public LoginStatus getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(LoginStatus loginStatus) {
        this.loginStatus = loginStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginStatusEntity that = (LoginStatusEntity) o;

        if (deviceId != null ? !deviceId.equals(that.deviceId) : that.deviceId != null) return false;
        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (loginStatus != that.loginStatus) return false;
        if (token != null ? !token.equals(that.token) : that.token != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (deviceId != null ? deviceId.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (loginStatus != null ? loginStatus.hashCode() : 0);
        return result;
    }

}
