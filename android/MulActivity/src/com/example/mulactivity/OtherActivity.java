package com.example.mulactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OtherActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_old);
		Intent intent = super.getIntent();//这个意图对象就是激活它的意图对象
//		String name = intent.getStringExtra("name");
//		int age = intent.getIntExtra("age", 0);
		Bundle bundle = intent.getExtras();
		String name = bundle.getString("name");
		int age = bundle.getInt("age");
		TextView textView =(TextView)super.findViewById(R.id.textView);
		textView.setText(name+"---"+age);
	}
	
	
	
	public void returnData(View v){
		Intent data = new Intent();
		data.putExtra("result", "jieguo");
		super.setResult(30, data);
		this.finish();//关闭当前页面
	}
}
