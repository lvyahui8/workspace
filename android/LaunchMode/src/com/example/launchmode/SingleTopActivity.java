package com.example.launchmode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SingleTopActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_singletop);
		TextView textView = (TextView)super.findViewById(R.id.textView);
		textView.setText(this.toString());
	}

	public void openSingleTopActivity(View v){
		super.startActivity(new Intent(this,SingleTopActivity.class));
	}
}
