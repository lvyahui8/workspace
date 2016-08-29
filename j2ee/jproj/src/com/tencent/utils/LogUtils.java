package com.tencent.utils;

/**
 * Author : samlv .
 * Date   : 2016/1/6 .
 */
public class LogUtils {
    public static boolean debug = true;
    public static void outLine(Object obj){
        if(debug){
            System.out.println(obj);
        }
    }
}
