package com.hangover.java.bl;

import com.hangover.java.model.OrderEntity;

/**
 * Created by IntelliJ IDEA.
 * User: ashqures
 * Date: 10/4/16
 * Time: 7:37 AM
 * To change this template use File | Settings | File Templates.
 */
public interface PaymentBL {


    void payment(String orderId, String transactionId, Double amount, String paymentThough, String status);

    void postPaymentSuccess(String orderNumber);

    void notifyOrderToStore(OrderEntity order);
}
