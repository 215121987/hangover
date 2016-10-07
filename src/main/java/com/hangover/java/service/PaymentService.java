package com.hangover.java.service;

import com.hangover.java.bl.PaymentBL;
import com.hangover.java.model.OrderEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by IntelliJ IDEA.
 * User: ashqures
 * Date: 8/23/16
 * Time: 9:02 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
@Path("/payment")
@Transactional
public class PaymentService extends BaseService{

    private Logger logger = LoggerFactory.getLogger(PaymentService.class);

    @Autowired
    private PaymentBL paymentBL;


    @POST
    public Response payment(@FormParam("orderNumber")String orderNumber,
                            @FormParam("transactionId")String transactionId,
                            @FormParam("amount")Double amount,
                            @FormParam("status")String status){
        paymentBL.payment(orderNumber,transactionId,amount,"APP", status);
        return Response.ok().build();
    }





}
