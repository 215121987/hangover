package com.hangover.java.notification;

import com.hangover.java.model.type.MessageType;
import com.hangover.java.util.ApplicationContextUtil;
import com.hangover.java.util.ValidatorUtil;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ashqures
 * Date: 9/2/16
 * Time: 1:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class NotificationTask implements Runnable {

    private MessageType messageType = null;
    private Message message;
    private Map<String,String> map;

    private MessageSender smsSender;

    private MessageSender emailSender;

    private EmailFactory emailFactory;

    private SMSFactory smsFactory;

    public NotificationTask(String username, MessageType messageType) {
        this.message = new Message();
        this.message.setTo(username);
        this.messageType = messageType;
    }

    public NotificationTask(String[] usernames, MessageType messageType) {
        this.message = new Message();
        this.message.setTo(usernames);
        this.messageType = messageType;
    }

    public NotificationTask(Map<String,String> map, MessageType messageType) {
        this.message = new Message();
        this.message.setTo(map.get("username"));
        this.messageType = messageType;
        this.map = map;
    }

    public NotificationTask(Message mai1, MessageType messageType) {
        this.message = mai1;
        this.messageType = messageType;
    }

    public NotificationTask(Message mai1) {
        this.message = mai1;
    }

    private void prepareTask() {
        this.smsSender = (SMSSender) ApplicationContextUtil.getApplicationContext().getBean("smsSender");
        this.emailSender = (EmailSender) ApplicationContextUtil.getApplicationContext().getBean("emailSender");
        this.emailFactory = (EmailFactory) ApplicationContextUtil.getApplicationContext().getBean("emailFactory");
        this.smsFactory = (SMSFactory) ApplicationContextUtil.getApplicationContext().getBean("smsFactory");
    }

    @Override
    public void run() {
        prepareTask();
        this.execute();
    }

    private void execute() {
        if (isEmail())
            this.emailSender.send(prepareMail());
        else if (isMobile())
            this.smsSender.send(prepareSMS());
    }

    private Message prepareSMS() {
        Message resultMessage = null;
        switch (messageType) {
            case REGISTRATION_NOTIFICATION:  resultMessage = this.smsFactory.getRegistrationMessage(this.map);
                break;
            case RESET_PASSWORD: resultMessage = this.smsFactory.getResetPasswordMessage(this.message.getTo()[0]);
                break;
            case OTP:resultMessage = this.smsFactory.getOTPMessage(this.map);
                break;
            default:
                resultMessage = this.message;
        }
        return resultMessage;
    }

    private Message prepareMail() {
        Message resultMessage = null;
        switch (messageType) {
            case REGISTRATION_NOTIFICATION: resultMessage = this.emailFactory.getRegistrationMessage(this.map);
                break;
            case RESET_PASSWORD:
                resultMessage = this.emailFactory.getResetPasswordMessage(this.message.getTo()[0]);
                break;
            case OTP:
                resultMessage = this.emailFactory.getOTPMessage(this.map);
                break;
            default:
                resultMessage = this.message;
        }
        return resultMessage;
    }

    public boolean isEmail() {
        return ValidatorUtil.isValidEmail(this.message.getTo()[0]);
    }

    public boolean isMobile() {
        return ValidatorUtil.isValidMobile(this.message.getTo()[0]);
    }

}
