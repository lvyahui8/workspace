package com.example.mulactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void onOpenNewPage(View v){
		Intent intent = new Intent();//意图对象用来激活Activity和传递软件参数
		//以下五种都是显示Intent
		intent.setClassName("com.example.mulactivity", "com.example.mulactivity.OtherActivity");//可以用来激活其他应用的Activity
//		intent.setClass(this, OtherActivity.class);
//		intent.setClassName(this, "com.example.mulactivity.OtherActivity");
//		intent.setComponent(new ComponentName(this, OtherActivity.class));
//		Intent intent = new Intent(this,OtherActivity.class);
		
//		intent.putExtra("name", "lvyahui");
//		intent.putExtra("age", 19);
		
		Bundle bundle = new Bundle();
		bundle.putString("name", "lvyahui");
		bundle.putInt("age", 19);
		intent.putExtras(bundle);//批量添加
		
//		startActivity(intent); 
		//要想获得打开的页面返回的数据，必须使用startActivityForResult打开页面
		startActivityForResult(intent, 200);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		String result = data.getStringExtra("result");
		Toast.makeText(this, result, 1).show();
	}
	
	
}
