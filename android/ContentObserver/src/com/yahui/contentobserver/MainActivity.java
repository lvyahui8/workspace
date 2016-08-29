package com.yahui.contentobserver;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ContentResolver resolver = getContentResolver();
		Uri uri = Uri.parse("content://sms/");
		
		resolver.registerContentObserver(uri, true, new MyObserver(new Handler()));
	}
	
	private class MyObserver extends ContentObserver{

		public MyObserver(Handler handler) {
			super(handler);
			
		}

		@Override
		public void onChange(boolean selfChange) {
			super.onChange(selfChange);
			Toast.makeText(MainActivity.this, "短信数据库容变化了", 1).show();
		}
		
	}
	
	
}
