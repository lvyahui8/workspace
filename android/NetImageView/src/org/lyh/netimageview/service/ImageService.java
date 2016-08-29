package org.lyh.netimageview.service;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.lyh.netimageview.utils.StreamTools;

public class ImageService {
	/**
	 * ��ȡ����ͼƬ
	 * @param imageUrl 
	 * @return
	 * @throws IOException 
	 */
	public static byte[] getImage(String imageUrl) throws IOException {
		
		// TODO Auto-generated method stub
		URL url = new URL( imageUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();//����httpЭ��
		conn.setConnectTimeout(5000);
		conn.setRequestMethod("GET");
		if(conn.getResponseCode() == 200){
			InputStream ins = conn.getInputStream();
			return StreamTools.read(ins);
		}
		return null;
		
	}

}
