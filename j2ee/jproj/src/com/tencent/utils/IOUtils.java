package com.tencent.utils;

import java.io.File;
import java.io.IOException;

/**
 * Author : samlv .
 * Date   : 2016/1/6 .
 */
public class IOUtils {
    public static final String FILE_SP = System.getProperty("file.separator");
    public static String getBasePath(){
        File directory = new File("");// 参数为空
        String courseFile = null;
        try {
            courseFile = directory.getCanonicalPath();
            return courseFile;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
