package com.hangover.java;


import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ashqures
 * Date: 2/2/16
 * Time: 2:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class Temp {

    public static String input = ""; 
    
    public static void update(String oldHopId, String newHopId){
        List<String> hopList = new ArrayList<String>();
        System.out.println("Tets  "+StringUtils.join(hopList, ","));
        if(StringUtils.isNotEmpty(input)){
            hopList = new ArrayList<String>(Arrays.asList(input.split(",")));
            if(StringUtils.isNotEmpty(oldHopId) && hopList.contains(oldHopId)){
                hopList.remove(oldHopId);
            }
        }
        if(StringUtils.isNotEmpty(newHopId) && !hopList.contains(newHopId)){
            hopList.add(newHopId);
        }
        if(hopList.size()>0){
            input = StringUtils.join(hopList, ",");
            System.out.println(input);
        }else{
            System.out.println(hopList);
        }
    }


    
    public static void main(String args[]){
        ////update("123456","123456");
       // update(null,"342567");
       // update(null,"342267");
       // update(null,"342564");
        //System.out.println("Restore".substring(0, 1));
        String [] abc ={"123"};
        System.out.print(StringUtils.join(abc,","));
    }



   
}
