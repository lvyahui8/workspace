package org.lyh.ipdail.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class OutCallReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		System.out.println("有新的外拨电话");
		
		String number = super.getResultData();
		
		System.out.println("number:"+number);
		
		SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		String ipnumber = sp.getString("config","");
		String newnumber = ipnumber + number;
		
		
		super.setResultData(newnumber);
		
	}

}
