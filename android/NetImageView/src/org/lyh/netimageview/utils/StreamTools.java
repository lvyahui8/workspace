package org.lyh.netimageview.utils;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamTools {

	public static byte[] read(InputStream ins) throws IOException {
		// TODO Auto-generated method stub
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		
		byte [] buffer = new byte[1024];
		int len = 0;
		while((len = ins.read(buffer) )!= -1 ){
			outStream.write(buffer,0,len);
		}
		ins.close();
		return outStream.toByteArray();
	}

}
