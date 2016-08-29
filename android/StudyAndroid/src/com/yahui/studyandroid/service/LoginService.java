package com.yahui.studyandroid.service;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.yahui.studyandroid.utils.StreamTools;

public class LoginService {
	public static String loginByGet(String username,String password){
		String path = "http://10.0.3.2/webservice/loginservlet?username="+username+"&password="+password;
		try {
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(4999);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:33.0) Gecko/20100101 Firefox/33.0");
			int code = conn.getResponseCode();
			if(200==code){
				InputStream is = conn.getInputStream();
				String text = StreamTools.Html2Text(is);
				return text;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static String loginByPost(String username,String password){
		String path = "http://10.0.3.2/webservice/loginservlet";
		try {
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(4999);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:33.0) Gecko/20100101 Firefox/33.0");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			
			//post方式将参数放到了请求体里面，所以需要单独输出给服务器
			conn.setDoOutput(true);
			OutputStream os = conn.getOutputStream();
			String data = "username="+username+"&password="+password;
			os.write(data.getBytes());
			
			int code = conn.getResponseCode();
			if(200==code){
				InputStream is = conn.getInputStream();
				String text = StreamTools.Html2Text(is);
				return text;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
