package com.yahui.readcontactsinfo;

import java.util.Random;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private EditText name = null;
	private EditText phoneNumber = null;
	private ContentResolver resolver = null;
	private Random r = new Random();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		name = (EditText) super.findViewById(R.id.name);
		phoneNumber = (EditText) super.findViewById(R.id.phonenumber);
		resolver = super.getContentResolver();
	}
	
	public void onQueryBtnClick(View view){
		Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");
		Uri dataUri = Uri.parse("content://com.android.contacts/data");
		Cursor cursor = resolver.query(uri, null, null, null, null);
		while(cursor.moveToNext()){
			String id = cursor.getString(cursor.getColumnIndex("contact_id"));
			//System.out.println(id);
			Cursor dataCursor = resolver.query(dataUri, null, "contact_id=?", new String[]{id}, null);
			//dataCursor.getColumnNames();//这里底层是以视图进行的查询，所以可以先用这个方法查询获取到的结果集的列名
			//System.out.println(dataCursor.getColumnNames().toString()+"");
			while(dataCursor.moveToNext()){
				String data1 = dataCursor.getString(dataCursor.getColumnIndex("data1"));
				String mimetype_id = dataCursor.getString(dataCursor.getColumnIndex("mimetype"));//视图中不存在mimetype_id这一列
				System.out.println(data1+"="+mimetype_id);
			}
		}
		cursor.close();
	}
	
	public void onInsertBtnClick(View view){
		Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");
		Uri dataUri = Uri.parse("content://com.android.contacts/data");
		//确定id
		Cursor cursor = resolver.query(uri, new String[]{"_id"}, null, null, null);
		int newId ;
		if(cursor!=null){
			cursor.moveToLast();
			newId = cursor.getInt(0)+1;
		}
		else{
			newId = r.nextInt(10000)+10000;
		}
		ContentValues values = new ContentValues();
		values.put("contact_id", newId);
		//插入id
		resolver.insert(uri, values);

		//获取姓名
		String na = name.getText().toString();
		if(na == null || "".equals(na)){
			na = "DJ";
		}
		ContentValues nameValues = new ContentValues();
		nameValues.put("row_contact_id", newId);
		nameValues.put("data1", na);
		nameValues.put("mimetype_id", 7);
		nameValues.put("mimetype", "vnd.android.cursor.item/name");
		System.out.println(nameValues.toString()+":"+dataUri.toString());
		//插入姓名
		resolver.insert(dataUri, nameValues);            
		
		//获取电话号码
		String pNumber = phoneNumber.getText().toString();
		if(pNumber == null || "".equals(pNumber)){
			pNumber = "1213141633";
		}
		ContentValues phoneValues = new ContentValues();
		phoneValues.put("row_contact_id", newId);
		phoneValues.put("data1", pNumber);
		phoneValues.put("mimetype_id", 5);
		phoneValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
		//插入电话
		resolver.insert(dataUri, phoneValues);            
		
		print("添加成功");
	}
	
	public void print(String text){
		Toast.makeText(getApplicationContext(), text, 0).show();
	}
}
