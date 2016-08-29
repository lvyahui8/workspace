package com.example.launchmode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView textView = (TextView)super.findViewById(R.id.textView);
		textView.setText(this.toString());
	}
	
	public void openStandardActivity(View v){
		startActivity(new Intent(this,MainActivity.class));
	}
	
	public void openSingleTopActivity(View v){
		super.startActivity(new Intent(this,SingleTopActivity.class));
	}
	public void openSingleTaskActivity(View v){
		super.startActivity(new Intent(this,SingleTaskActivity.class));
	}
	
	
}
