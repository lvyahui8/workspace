package com.yahui.readsystemsms;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.yahui.readsystemsms.util.SmsUtils;
import com.yahui.readsystemsms.vo.SmsInfo;

public class MainActivity extends Activity {
	
	public static final String TAG = "ReadySystemSMS";
	
	private EditText phoneNumber = null;
	private EditText smsContent = null;
	private ContentResolver resolver = null; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		phoneNumber = (EditText) super.findViewById(R.id.phonenumber);
		smsContent = (EditText) super.findViewById(R.id.smscontent);
		resolver = getContentResolver(); 
	}
	
	public void onBackUpBtnClick(View view){
		//content://sms/
		Uri uri = Uri.parse("content://sms/");
		Cursor cursor = resolver.query(uri, new String[]{
				 "address","date","type","body"
		}, null, null, null);
		List<SmsInfo> smsInfos = new ArrayList<SmsInfo>();
		while(cursor.moveToNext()){
			String address = cursor.getString(0);
			long date = cursor.getLong(1);
			int type = cursor.getInt(2);
			String body = cursor.getString(3);
			
			SmsInfo smsinfo = new SmsInfo(date,type,body,address);
			smsInfos.add(smsinfo);
			Log.i(TAG, "address:"+address+" date:"+date+" type:"+type+" body:"+body);
		}
		cursor.close();
		if(SmsUtils.backUpSms(smsInfos, this)){
			Toast.makeText(this, "短信成功备份到SD卡（backup.xml）", 0).show();
		}
		else{
			Toast.makeText(this, "备份失败", 0).show();
		}
	}
	public void onInsertBtnClick(View view){
		Uri uri = Uri.parse("content://sms/");
		ContentValues values = new ContentValues();
		String pNumber = phoneNumber.getText().toString();
		if(pNumber == null || "".equals(pNumber)){
			pNumber = "95518";
		}
		values.put("address",pNumber);
		values.put("type", 1);
		values.put("date", System.currentTimeMillis());
		String sContent = smsContent.getText().toString();
		if(sContent == null || "".equals(sContent)){
			sContent = "您尾号为2015的建行账号收到一笔不小的转账。。。";
		}
		values.put("body", sContent);
		resolver.insert(uri, values);
	}
}
