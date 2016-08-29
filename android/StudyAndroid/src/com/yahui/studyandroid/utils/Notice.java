package com.yahui.studyandroid.utils;

import android.content.Context;
import android.widget.Toast;

public class Notice {
	public static void toastl(Context context,String text){
		Toast.makeText(context, text, Toast.LENGTH_LONG).show();
	}
	public static void toasts(Context context,String text){
		Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
	}
}
