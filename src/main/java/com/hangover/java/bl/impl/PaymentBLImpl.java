package com.hangover.java.bl.impl;

import com.hangover.java.bl.PaymentBL;
import com.hangover.java.dao.CommonDao;
import com.hangover.java.dao.ShoppingDao;
import com.hangover.java.dao.StoreDao;
import com.hangover.java.model.*;
import com.hangover.java.model.type.OrderState;
import com.hangover.java.model.type.PaymentStatus;
import com.hangover.java.notification.Message;
import com.hangover.java.notification.PostPaymentSuccessTask;
import com.hangover.java.notification.PushNotificationService;
import com.hangover.java.task.AsyncTask;
import com.hangover.java.task.HangoverBeans;
import com.hangover.java.util.CommonUtil;
import com.hangover.java.util.Constants;
import com.hangover.java.util.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ashqures
 * Date: 10/4/16
 * Time: 7:37 AM
 * To change this template use File | Settings | File Templates.
 */
@Repository("paymentBL")
@Transactional
public class PaymentBLImpl extends BaseBL implements PaymentBL, Constants {


    private Logger logger = LoggerFactory.getLogger(PaymentBLImpl.class);

    @Autowired
    private ValidatorUtil validatorUtil;

    @Autowired
    private CommonDao commonDao;

    @Autowired
    private ShoppingDao shoppingDao;

    @Autowired
    private CommonUtil commonUtil;

    @Autowired
    private StoreDao storeDao;

    @Autowired
    private HangoverBeans hangoverBeans;

    @Autowired
    private PushNotificationService pushNotificationService;

    @Autowired
    private AsyncTask asyncTask;

    @Autowired
    private TaskExecutor taskExecutor;
    
    
    public void payment(String orderId, String transactionId, Double amount, String paymentThough, String status){
        OrderEntity order  = shoppingDao.getOrder(orderId);
        PaymentEntity payment = new PaymentEntity();
        payment.setOrder(order);
        payment.setAmount(amount);
        logger.info("Payment:- transaction id:-"+ transactionId+" , order id:-"+orderId+", status:-"+ status);
        if("SUCCESS".equals(status)){
            order.setState(OrderState.PAYMENT_SUCCESS);
            payment.setStatus(PaymentStatus.SUCCESS);
        }else if("FAILED".equals(status)){
            order.setState(OrderState.PAYMENT_FAILED);
            payment.setStatus(PaymentStatus.FAILED);
        }
        payment.setTransactionId(transactionId);
        payment.setPaymentThrough(paymentThough);
        shoppingDao.save(order);
        shoppingDao.save(payment);
        Map<String,String> map = new HashMap<String, String>();
        map.put("email", order.getCustomer().getEmail());
        map.put("mobile", order.getCustomer().getMobile());
        map.put("orderNumber", orderId);
        map.put("transactionId", transactionId);
        map.put("amount", amount+"");
        map.put("status", status);
        this.taskExecutor.execute(this.asyncTask.getOrderPaymentNotificationTask(map));
        this.taskExecutor.execute(new PostPaymentSuccessTask(orderId));
    }
    
    public void postPaymentSuccess(String orderNumber){
        OrderEntity order = commonDao.getOrder(orderNumber);
        AddressEntity address = order.getAddress();
        List<SupplierStoreEntity> stores = storeDao.getStoreByLocation(address.getZipCode());
        SupplierStoreEntity store  = stores.get(0);
        order.setStore(store);
        storeDao.save(order);
        notifyOrderToStore(order);
    }
    
    public void notifyOrderToStore(OrderEntity order){
        logger.info("Notifying order to store...");
        List<LoginStatusEntity> loggedInStaffs = storeDao.getAvailableStoreStaff(order.getStore().getId());
        if(null!= loggedInStaffs && loggedInStaffs.size()>0){
            Message message = new Message();
            String []to = new String[loggedInStaffs.size()];
            for(int i=0;i<loggedInStaffs.size();i++){
                to[i] = loggedInStaffs.get(i).getDeviceId();
            }
            message.setTo(to);
            message.putContext("name", order.getCustomer().getName());
            message.putContext("mobile", order.getCustomer().getMobile());
            message.putContext("orderNumber", order.getOrderNumber());
            logger.info("Sending push to store devices...");
            pushNotificationService.transactional(message);
        }
    }
    
    
}
