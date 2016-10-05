package com.hangover.java.notification;

import com.hangover.java.dao.ShoppingDao;
import com.hangover.java.dao.UserDao;
import com.hangover.java.model.OTPEntity;
import com.hangover.java.model.OrderEntity;
import com.hangover.java.model.UserEntity;
import com.hangover.java.model.master.SMSTemplateEntity;
import com.hangover.java.model.type.MessageType;
import com.hangover.java.model.type.PasswordType;
import com.hangover.java.security.PasswordEncoder;
import com.hangover.java.util.CommonUtil;
import com.hangover.java.util.HangoverUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ashqures
 * Date: 9/2/16
 * Time: 4:21 PM
 * To change this template use File | Settings | File Templates.
 */
@Component("smsFactory")
@Transactional
public class SMSFactory {

    private static final String SMS_DYNAMIC_TEXT = "PLACEHOLDER";

    @Autowired
    private UserDao userDao;

    @Autowired
    private ShoppingDao shoppingDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CommonUtil commonUtil;

    public Message getResetPasswordMessage(String username){
        Message message = new Message();
        UserEntity user = userDao.getUserByUsername(username);
        message.setTo(user.getMobile());
        String temPassword ="Welcome123";
        user.setPassword(passwordEncoder.encode(temPassword));
        user.setPasswordType(PasswordType.TEMPORARY);
        userDao.save(user);
        SMSTemplateEntity smsTemplate = userDao.getMasterData(SMSTemplateEntity.class, "type", MessageType.RESET_PASSWORD);
        String sms = smsTemplate.getMessage();
        sms = sms.replace(SMS_DYNAMIC_TEXT, temPassword);
        message.setContent(sms);
        return message;
    }

    public Message getRegistrationMessage(Map<String,String> map){
        Message message = new Message();
        UserEntity user = userDao.getUserByUsername(map.get("username"));
        message.setTo(user.getMobile());
        SMSTemplateEntity smsTemplate = userDao.getMasterData(SMSTemplateEntity.class, "type", MessageType.REGISTRATION_NOTIFICATION);
        String sms = smsTemplate.getMessage();
        sms = sms.replaceFirst(SMS_DYNAMIC_TEXT, user.getName());
        sms = sms.replaceFirst(SMS_DYNAMIC_TEXT, map.get("username"));
        sms = sms.replaceFirst(SMS_DYNAMIC_TEXT, map.get("password"));
        message.setContent(sms);
        return message;
    }

    public Message getOTPMessage(Map<String,String> map){
        Message message = new Message();
        UserEntity user = userDao.getUserByUsername(map.get("username"));
        message.setTo(user.getMobile());
        String otp = HangoverUtil.getAlphaNumeric(4);
        OTPEntity otpEntity = new OTPEntity();
        otpEntity.setUser(user);
        otpEntity.setOtp(otp);
        otpEntity.setSendTo(map.get("username"));
        otpEntity.setRequestedFrom(map.get("requestedFrom"));
        userDao.save(otpEntity);
        SMSTemplateEntity smsTemplate = userDao.getMasterData(SMSTemplateEntity.class, "type", MessageType.OTP);
        String sms = smsTemplate.getMessage();
        sms = sms.replace(SMS_DYNAMIC_TEXT, otp);
        message.setContent(sms);
        return message;
    }
    
    public Message getOrderCompleteMessage(Map<String,String> map){
        Message message = new Message();
        UserEntity user = userDao.getUserByUsername(map.get("username"));
        message.setTo(user.getMobile());
        OrderEntity order = shoppingDao.getOrder(map.get("orderNumber"));
        MessageType type;
        switch (order.getState()){
            case PAYMENT_SUCCESS: type = MessageType.ORDER_PAYMENT_SUCCESS;
                break;
            default: type = MessageType.ORDER_PAYMENT_FAILED;
                break;
        }
        SMSTemplateEntity smsTemplate = userDao.getMasterData(SMSTemplateEntity.class, "type", type);
        String sms = smsTemplate.getMessage();
        sms = sms.replaceFirst(SMS_DYNAMIC_TEXT, user.getName());
        sms = sms.replaceFirst(SMS_DYNAMIC_TEXT, map.get("orderNumber"));
        message.setContent(sms);
        return message;
    }

}
