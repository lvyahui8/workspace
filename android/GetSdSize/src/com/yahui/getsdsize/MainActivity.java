package com.yahui.getsdsize;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.format.Formatter;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TextView tv = (TextView) super.findViewById(R.id.tv);
		
		File path = Environment.getExternalStorageDirectory();//获取外部存储路径
//		File path = Environment.getDataDirectory();//获内外部存储路径
		
		StatFs stat = new StatFs(path.getPath());
		long blockSize = stat.getBlockSize();//块大小
		long totalBlocks = stat.getBlockCount();//获取块总数
		long availableBlocks = stat.getAvailableBlocks();//获取可用块总数
		
		long totalSize = blockSize * totalBlocks;
		long availSize = availableBlocks * blockSize;
		
		String totaiStr = Formatter.formatFileSize(this, totalSize);
		String availStr = Formatter.formatFileSize(this, availSize);
		
		
		tv.setText("总内存:"+totaiStr+"\n"+"可用内存："+availStr);
		
		
		
	}
}
