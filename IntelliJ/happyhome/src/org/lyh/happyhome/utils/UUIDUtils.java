package org.lyh.happyhome.utils;

import java.util.UUID;

/**
 * Created by admin on 2015/4/7.
 */
public class UUIDUtils {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
