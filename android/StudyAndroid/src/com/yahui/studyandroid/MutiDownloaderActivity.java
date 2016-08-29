package com.yahui.studyandroid;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.yahui.studyandroid.download.DownLoader;
import com.yahui.studyandroid.utils.Notice;
import com.yahui.studyandroid.utils.SDCardUtils;
import com.yahui.studyandroid.utils.T;

public class MutiDownloaderActivity extends Activity {

	private EditText et_path;
	private ProgressBar pb;
	private int nThreads = 3;
	
	
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case SDCardUtils.SPACE_NOT_ENOUGH:
				T.showShort(MutiDownloaderActivity.this, "磁盘空间不够");
				break;
			default:
				break;
			}
		}
		
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mutidownload);
		et_path = (EditText) super.findViewById(R.id.text_path);
		pb = (ProgressBar) super.findViewById(R.id.downloadProgressBar);
	}
	
	public void downLoad(View view){
		final String uri  = et_path.getText().toString().trim();
		if(TextUtils.isEmpty(uri)){
			Notice.toasts(this, "路径有问题");
			return;
		}
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				DownLoader downloader = new DownLoader(uri); 
				
				long length = downloader.getSize();
				if(length<=0 && !SDCardUtils.hasSpace(length)){
					//文件大小为0或空间不够
					Message msg =  Message.obtain();
					msg.what = SDCardUtils.SPACE_NOT_ENOUGH;
					handler.sendMessage(msg);
					return;
				}
				
				String fileFullName = SDCardUtils.getSDCardPath()+"everthing.exe";
				downloader.setFileFullName(fileFullName);		//设置下载文件名
				downloader.setThreadCount(nThreads);		//设置线程下载的文件数
				
				downloader.startDownload();
			}
			
		}).start();
	}
	
	public void onFinish(){
		
	}
}
