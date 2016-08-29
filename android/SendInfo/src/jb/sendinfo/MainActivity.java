package jb.sendinfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	

	private EditText infoEditText;
	private List<String> allPhones;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		infoEditText = (EditText)super.findViewById(R.id.info);
		
		try {
			File file = new File(Environment.getExternalStorageDirectory(),"allphones.xml");
			InputStream phonesXml;
			phonesXml = new FileInputStream(file);
			allPhones = PhoneService.getAllPhones(phonesXml);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void sendMsg(View v){
		if(allPhones!=null){
			String msg = infoEditText.getText().toString().trim();
			new SendSMSer(allPhones, this).send(msg)
			;
		}
	}
}
