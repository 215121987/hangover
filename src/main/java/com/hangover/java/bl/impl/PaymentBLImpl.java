package com.hangover.java.bl.impl;

import com.hangover.java.bl.PaymentBL;
import com.hangover.java.dao.CommonDao;
import com.hangover.java.dao.ShoppingDao;
import com.hangover.java.model.OrderEntity;
import com.hangover.java.model.PaymentEntity;
import com.hangover.java.model.type.OrderState;
import com.hangover.java.model.type.PaymentStatus;
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
    private HangoverBeans hangoverBeans;

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
    }
    
    
    
    
}
