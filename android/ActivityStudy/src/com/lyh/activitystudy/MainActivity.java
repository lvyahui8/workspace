package com.lyh.activitystudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
	//onCreate --> onStart --> onResume --> onPause --> onStop --> onDestory
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	System.out.println("onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void tz(View view){
    	startActivity(new Intent(this, OtherActivity.class));
    }

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		System.out.println("onDestory");
		super.onDestroy();
	}

	@Override 
	protected void onStart() {
		// TODO Auto-generated method stub
		System.out.println("onStart");
		super.onStart();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		System.out.println("onPause");
		super.onPause();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		System.out.println("onStop");
		super.onStop();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		System.out.println("onResume");
		super.onResume();
	}
    
    
}
