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
		
		File path = Environment.getExternalStorageDirectory();//��ȡ�ⲿ�洢·��
//		File path = Environment.getDataDirectory();//�����ⲿ�洢·��
		
		StatFs stat = new StatFs(path.getPath());
		long blockSize = stat.getBlockSize();//���С
		long totalBlocks = stat.getBlockCount();//��ȡ������
		long availableBlocks = stat.getAvailableBlocks();//��ȡ���ÿ�����
		
		long totalSize = blockSize * totalBlocks;
		long availSize = availableBlocks * blockSize;
		
		String totaiStr = Formatter.formatFileSize(this, totalSize);
		String availStr = Formatter.formatFileSize(this, availSize);
		
		
		tv.setText("���ڴ�:"+totaiStr+"\n"+"�����ڴ棺"+availStr);
		
		
		
	}
}
