package com.example.c4bomb.service;

import java.util.List;
import java.util.concurrent.Executors;

import android.content.Context;
import android.os.Looper;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

public class SendSMSer {
	private static final String TAG = "allPhones";
	private List<String> allPhones ;
	Context context;
	public SendSMSer(List<String> allPhones,Context context){
		this.allPhones = allPhones;
		this.context = context;
	}
	
	public  void send(final String msg) {
		// TODO Auto-generated method stub
		Executors.newScheduledThreadPool(1).execute(new Runnable() {
			
			@Override
			public void run() {
				long time = System.currentTimeMillis();
				// TODO Auto-generated method stub				
				Log.i(TAG, allPhones.toString());
				if(null == allPhones){
					return ;
				}
				SmsManager manager = SmsManager.getDefault();
				for (String phone : allPhones) {
					Log.i(TAG, phone);
					manager.sendTextMessage(phone, null, msg, null, null);
					Log.i(TAG,"OK");
				}
				long useTime = System.currentTimeMillis() - time;
				Log.i(TAG, "All Ok"+"use:"+useTime);
				Looper.prepare();
				Toast.makeText(context.getApplicationContext(), "��Ϣ��\""+msg+"\"�Ѿ����͵���ս��Ա���У���ʱ"+useTime+"mS", 1).show();
				Looper.loop();
				Log.i(TAG, "��Ϣ��\""+msg+"\"�Ѿ����͵���ս��Ա���У���ʱ"+useTime+"mS");
			}
		});
	}

}
