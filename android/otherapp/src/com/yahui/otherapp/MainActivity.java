package com.yahui.otherapp;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final String TAG = "othreapp";
	private TextView text = null;
	private static final int tosttime = Toast.LENGTH_LONG;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		text = (TextView)super.findViewById(R.id.text);
	}
	
	public void onQueryBtnClick(View view){
		ContentResolver resolver = getContentResolver();
		Uri uri = Uri.parse("content://com.yahui.db.personprovider/query");
		Cursor cursor = resolver.query(uri, null, null, 
				null,null);
		Toast.makeText(getApplicationContext(), "*"+cursor.toString(), tosttime).show();
		Log.i(TAG, cursor.toString());
		StringBuilder sb = new StringBuilder();
		while(cursor.moveToNext()){
			String name = cursor.getString(cursor.getColumnIndex("name"));
			String id = cursor.getString(cursor.getColumnIndex("personid"));
			//System.out.println(name+"-->"+id);
			Log.i(TAG, name+"-->"+id);
			sb.append(name+"-->"+id);
		}
		text.setText(sb.toString());
	}
	
	public void onInsertBtnClick(View view){
		ContentResolver resolver = getContentResolver();
		Uri uri = Uri.parse("content://com.yahui.db.personprovider/insert");
		ContentValues values = new ContentValues();
		values.put("phone", "158598");
		values.put("name", "吕亚辉");
		values.put("personid", "33");
		resolver.insert(uri, values);
		Toast.makeText(getApplicationContext(), "插入成功", tosttime).show();
	}
	
	public void onUpdateBtnClick(View view){
		ContentResolver resolver = getContentResolver();
		Uri uri = Uri.parse("content://com.yahui.db.personprovider/update");
		ContentValues values = new ContentValues();
		values.put("phone", "10");
		resolver.update(uri, values, "personid=?", new String[]{"5"});
		Toast.makeText(getApplicationContext(), "更新成功", tosttime).show();
	}
	
	public void onDeleteBtnClick(View view){
		ContentResolver resolver = getContentResolver();
		Uri uri = Uri.parse("content://com.yahui.db.personprovider/delete");
		resolver.delete(uri, "personid=?", new String[]{"15"});
		Toast.makeText(getApplicationContext(), "删除成功", tosttime).show();
	}
}
