package com.yahui.readsystemsms.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.xmlpull.v1.XmlSerializer;

import android.content.Context;
import android.os.Environment;
import android.util.Xml;

import com.yahui.readsystemsms.vo.SmsInfo;

public class SmsUtils {
	/**
	 * 短信备份
	 * @param smsInfos
	 * @param context
	 */
	public static boolean backUpSms(List<SmsInfo> smsInfos,Context context){
		boolean flag = false;
		try{
			XmlSerializer serializer = Xml.newSerializer();
			File file = new File(Environment.getExternalStorageDirectory(),
					"backup.xml");
			FileOutputStream os = new FileOutputStream(file);
			serializer.setOutput(os,"utf-8");
			serializer.startDocument("utf-8", true);
			serializer.startTag(null, "smss");
			for(SmsInfo info : smsInfos){
				serializer.startTag(null, "sms");
				//serializer.attribute(null, "id", info.getId()+"");
				
				serializer.startTag(null, "body");
				serializer.text(info.getBody());
				serializer.endTag(null, "body");
				
				serializer.startTag(null, "address");
				serializer.text(info.getAddress());
				serializer.endTag(null, "address");
				 
				serializer.startTag(null, "type");
				serializer.text(info.getType()+"");
				serializer.endTag(null, "type");
				
				serializer.startTag(null, "date");
				serializer.text(info.getDate()+"");
				serializer.endTag(null, "date");
				
				serializer.endTag(null, "sms");
			}
			
			serializer.endTag(null, "smss");
			serializer.endDocument();
			
			os.close();
			flag = true;
			//Toast.makeText(context, "备份成功", 1).show();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}
}
