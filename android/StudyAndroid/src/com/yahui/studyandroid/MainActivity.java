package com.yahui.studyandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	/*
	 * 
	 * 
	 */
	
	public void onImageViewAppBtnClick(View v){
		startActivity(new Intent(this,ImageViewActivity.class));
	}
	
	public void onHtmlViewAppBtnClick(View view){
		startActivity(new Intent(this,HtmlViewActivity.class));
	}
	public void onLoginAppBtnClick(View view){
		startActivity(new Intent(this,LoginActivity.class));
	}
	public void onSmartImgViewBtnClick(View view){
		startActivity(new Intent(this,SmartImgViewActivity.class));
	}
}
