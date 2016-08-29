package com.yahui.studyandroid.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamTools {
	public static String Html2TextAutoEncoding(InputStream is){
		
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int len = 0;
			byte [] buffer = new byte[1024*4];
			while((len = is.read(buffer)) != -1)
			{
				baos.write(buffer, 0, len);
			}
			is.close();
			baos.close();//内存流不用关闭
			
			//获取html的编码
			byte [] res = baos.toByteArray();
			String temp = new String(res);
			if(temp.contains("utf-8")){
				return temp;
			}else if(temp.contains("gb2312")){
				return new String(res,"gb2312");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static String Html2Text(InputStream is){
		
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int len = 0;
			byte [] buffer = new byte[1024*4];
			while((len = is.read(buffer)) != -1)
			{
				baos.write(buffer, 0, len);
			}
			is.close();
			baos.close();//内存流不用关闭
			
			//获取html的编码
			byte [] res = baos.toByteArray();
			String temp = new String(res,"gbk");
			return temp;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
