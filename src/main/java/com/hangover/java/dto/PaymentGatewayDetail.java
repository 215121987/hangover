package com.hangover.java.dto;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: ashqures
 * Date: 10/9/16
 * Time: 9:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class PaymentGatewayDetail {
    
    
    private String actionURL;
    private List<NameValuePair> param;

    public String getActionURL() {
        return actionURL;
    }

    public void setActionURL(String actionURL) {
        this.actionURL = actionURL;
    }

    public List<NameValuePair> getParam() {
        return param;
    }

    public void setParam(List<NameValuePair> param) {
        this.param = param;
    }

    public void addParam(String name, String value){
        if(null == getParam())
            setParam(new ArrayList<NameValuePair>());
        getParam().add(new NameValuePair(name, value));
    }
    
    public TreeMap<String,String> gerParamAsTreeMap(){
        TreeMap<String,String> treeMap = new TreeMap<String, String>();
        if(null!= this.param){
            for(NameValuePair nameValuePair : getParam()){
                treeMap.put(nameValuePair.getName(),nameValuePair.getValue());
            }
        }
        return treeMap;
    }
}
