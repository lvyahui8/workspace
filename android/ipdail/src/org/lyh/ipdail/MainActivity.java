package org.lyh.ipdail;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText et_ipnumber;
	private SharedPreferences sp ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et_ipnumber = (EditText) super.findViewById(R.id.et_ipnumber);
		sp = super.getSharedPreferences("config", MODE_PRIVATE);
		et_ipnumber.setText(sp.getString("ipnumber", ""));
	}
	
	public void onCallClick(View view){
		String ipnumber = et_ipnumber.getText().toString().trim();
		Editor editor = sp.edit();
		editor.putString("ipnumber", ipnumber);
		editor.commit();
		
		Toast.makeText(this, "…Ë÷√ÕÍ≥…", Toast.LENGTH_SHORT).show();
	}
}
