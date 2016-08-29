package com.yahui.readcontactsinfo.service;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.yahui.readcontactsinfo.domain.ContactInfo;

public class ContactInfoService {
	public static List<ContactInfo> getContactInfo(Context context){
		List<ContactInfo> allPhones = new ArrayList<ContactInfo>();
		ContentResolver resolver = context.getContentResolver();
		Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");
		Uri dataUri = Uri.parse("content://com.android.contacts/data");
		Cursor cursor = resolver.query(uri, new String[]{"contact_id"}, null, null, null);
		while(cursor.moveToNext()){
			String id = cursor.getString(0);
			if(id != null){
				//System.out.println(id);
				Cursor dataCursor = resolver.query(dataUri, new String[]{"data1","mimetype"}, 
						"raw_contact_id=?", new String[]{id}, null);
				//dataCursor.getColumnNames();//����ײ�������ͼ���еĲ�ѯ�����Կ����������������ѯ��ȡ���Ľ����������
				//System.out.println(dataCursor.getColumnNames().toString()+"");
				
				ContactInfo cont = new ContactInfo();
				
				while(dataCursor.moveToNext()){
					String data1 = dataCursor.getString(dataCursor.getColumnIndex("data1"));
					String mimetype = dataCursor.getString(dataCursor.getColumnIndex("mimetype"));//��ͼ�в�����mimetype_id��һ��
					System.out.println(data1+"="+mimetype);
					
					if("vnd.android.cursor.item/name".equals(mimetype)){
						cont.setName(data1);
					}
					else if("vnd.android.cursor.item/phone_v2".equals(mimetype)){
						cont.setNumber(data1);
					}
				}
				allPhones.add(cont);
			}
		}
		cursor.close();
		return allPhones;
	}
}
