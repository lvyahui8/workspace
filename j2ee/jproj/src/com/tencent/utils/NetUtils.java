package com.tencent.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import sun.net.www.http.HttpClient;

import java.io.*;

/**
 * Author : samlv .
 * Date   : 2016/1/5 .
 */
public class NetUtils {
    public static boolean download(String url,String saveFile){
        if(!isHttpUrl(url)){
            url = buildHttpUrl(url);
        }
        boolean result = false;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if(entity != null){
                /*
                InputStream inputStream = entity.getContent();
                try{
                    BufferedInputStream bis = new BufferedInputStream(inputStream);
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(saveFile)));
                    int len ;
                    while((len = bis.read()) != -1){
                        bos.write(len);
                    }
                    bis.close();
                    bos.close();
                }finally {
                    inputStream.close();
                }
                */
                /*
                // JDK 1.6  不支持这种写法
                try(FileOutputStream fout = new FileOutputStream(new File(saveFile))){
                    entity.writeTo(fout);
                    result = true;
                }
                */
                try{
                    FileOutputStream fout = new FileOutputStream(new File(saveFile));
                    entity.writeTo(fout);
                    result = true;
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    private static String buildHttpUrl(String url) {
        return "http://" + url;
    }

    private static boolean isHttpUrl(String url) {
        return url.startsWith("http://");
    }
}
