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
    private List<NameValuePair> params;

    public String getActionURL() {
        return actionURL;
    }

    public void setActionURL(String actionURL) {
        this.actionURL = actionURL;
    }

    public List<NameValuePair> getParams() {
        return params;
    }

    public void setParams(List<NameValuePair> params) {
        this.params = params;
    }

    public void addParam(String name, String value){
        if(null == getParams())
            setParams(new ArrayList<NameValuePair>());
        getParams().add(new NameValuePair(name, value));
    }
    
    public TreeMap<String,String> gerParamAsTreeMap(){
        TreeMap<String,String> treeMap = new TreeMap<String, String>();
        if(null!= this.params){
            for(NameValuePair nameValuePair : getParams()){
                treeMap.put(nameValuePair.getName(),nameValuePair.getValue());
            }
        }
        return treeMap;
    }
}
