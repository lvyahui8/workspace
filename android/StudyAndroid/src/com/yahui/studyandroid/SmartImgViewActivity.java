package com.yahui.studyandroid;

import com.loopj.android.image.SmartImageView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SmartImgViewActivity extends Activity {

	private SmartImageView simgView = null;
	private EditText editText = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_smartimgview);
		simgView = (SmartImageView) super.findViewById(R.id.smartimgview_imageview);
		editText = (EditText) super.findViewById(R.id.smartimgview_edit);
	}

	public void loadImage(View view){
		simgView.setImageUrl(editText.getText().toString().trim(),R.drawable.ic_launcher,R.drawable.ic_launcher);
	}

}
