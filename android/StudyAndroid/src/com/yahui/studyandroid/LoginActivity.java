package com.yahui.studyandroid;

import com.yahui.studyandroid.service.LoginService;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	private EditText usernameEdit ;
	private EditText passwordEdit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.acticity_login);
		usernameEdit = (EditText) super.findViewById(R.id.username);
		passwordEdit = (EditText) super.findViewById(R.id.password);
		
	}
	
	public void onBtnClick(View view	){
		final String username = usernameEdit.getText().toString().trim();
		final String password = passwordEdit.getText().toString().trim();
		final int id = view.getId();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				String result = null;
				switch (id) {
				case R.id.submitbtn:
					result = LoginService.loginByGet(username, password);
					break;
				case R.id.submitbtn2:
					result = LoginService.loginByPost(username, password);
					break;
				default:
					break;
				}
				if(result!=null){
					print(result);
				}
				else{
					print("«Î«Û ß∞‹");
				}
			}
		}).start();
		
	}
	
	public void print(final String text){
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Toast.makeText(LoginActivity.this, text, Toast.LENGTH_SHORT).show();
			}
		});
	}
}
