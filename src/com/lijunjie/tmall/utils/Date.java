package com.lijunjie.tmall.utils;



import java.text.SimpleDateFormat;

/**
 * @author lijunjie
 * @version 1.0
 * @date 2019/1/16 16:45
 */
public class Date {
    public static String date(){
        return new  SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());
    }
}
