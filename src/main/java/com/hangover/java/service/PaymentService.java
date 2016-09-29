package com.hangover.java.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.Path;

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


}
