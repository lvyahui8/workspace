package com.lyh.smssender;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText ePhone = null;
	EditText eContent = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ePhone = (EditText) super.findViewById(R.id.phone_number);
		eContent = (EditText) super.findViewById(R.id.send_content);
	}
	
	public void selectPhone(View view){
		Intent intent = new Intent(this,SelectActivity.class);
		//startActivity(intent);
		startActivityForResult(intent, 0);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(data!=null){
			String number = data.getStringExtra("number");
			ePhone.setText(number);
		}
	}
	
	public void sendSms(View view){
	
	}
}
