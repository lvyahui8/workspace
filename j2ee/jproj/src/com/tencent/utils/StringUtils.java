package com.tencent.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * Author : samlv .
 * Date   : 2016/1/5 .
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils{
    public static String ucfirst(String str){
        return str;
    }

    public static String lcfirst(String str){
        char [] chars = str.toCharArray();
        chars[0] = chars[0] >= 'A' && chars[0] <= 'Z' ? (char) (chars[0] + 32) : chars[0];
        return String.copyValueOf(chars);
    }

    /**
     * 生成字符串的32位md5加密值
     * @param str 要加密的字符串
     * @return
     */
    public static String md5(String str){
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(str.getBytes());
            for (byte b : bytes){
                String toHexChar = Integer.toHexString(b & 0xff);
                sb.append(toHexChar.length() == 1 ? '0'+toHexChar : toHexChar );
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * 生成32位随机UUID
     * @return 32个字节的字符串
     */
    public static String uuid(){
        return UUID.randomUUID().toString().replace("-", "");
    }


    public static boolean encodeType(String str,String encode){
        boolean success = false;
        try {
            success = str != null && str.equals(new String(str.getBytes(encode),encode));
        } catch (UnsupportedEncodingException e) {
            //
        }
        return success;
    }
}
