package dj.net.ie_server;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLDemo {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		String str_url = "http://192.168.1.100:8080/myweb/1.html?name=lisi";
		
		URL url = new URL(str_url);
		
		System.out.println("getProtocol:"+url.getProtocol());
		System.out.println("getHost:"+url.getHost());
		System.out.println("getPort:"+url.getPort());
		System.out.println("getFile:"+url.getFile());
		System.out.println("getPath:"+url.getPath());
		System.out.println("getQuery:"+url.getQuery());
		
//		InputStream ins = url.openStream();
		//
		URLConnection conn = url.openConnection();
		InputStream ins = conn.getInputStream();
		
		byte [] buf = new byte[1024];
		int len = ins.read(buf);
		
		String text = new String(buf,0,len);
		System.out.println(text);
		ins.close();
	}

}
