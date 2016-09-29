package com.hangover.java.notification;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ashqures
 * Date: 9/2/16
 * Time: 3:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class Message {

    private String from;

    private String[] to;

    private String[] cc;

    private String[] bcc;

    private String subject;

    private String content;

    private String templateName;

    private String contentType;
    
    private Map<String,Object> context;

    private boolean promotional = false;

    public Message() {
        this.contentType = "text/html";
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
    }

    public void setTo(String to) {
        this.to = new String[]{to};
    }

    public String[] getCc() {
        return cc;
    }

    public void setCc(String[] cc) {
        this.cc = cc;
    }

    public void setCc(String cc) {
        this.cc = new String[]{cc};
    }

    public String[] getBcc() {
        return bcc;
    }

    public void setBcc(String[] bcc) {
        this.bcc = bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = new String[]{bcc};
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Map<String, Object> getContext() {
        return context;
    }

    public void setContext(Map<String, Object> context) {
        this.context = context;
    }
    
    public void putContext(String key, Object value){
        if(null==getContext())
            setContext(new HashMap<String, Object>());
        getContext().put(key,value);
    }

    public boolean isPromotional() {
        return promotional;
    }

    public void setPromotional(boolean promotional) {
        this.promotional = promotional;
    }

    @Override
    public String toString() {
        StringBuilder lBuilder = new StringBuilder();
        lBuilder.append("Message From:- ").append(getFrom());
        lBuilder.append("Message To:- ").append(getTo());
        lBuilder.append("Message Cc:- ").append(getCc());
        lBuilder.append("Message Bcc:- ").append(getBcc());
        lBuilder.append("Message Subject:- ").append(getSubject());
        lBuilder.append("Message Send Date:- ").append(new Date());
        lBuilder.append("Message Content:- ").append(getContent());
        return lBuilder.toString();
    }
}
