package com.yahui.studyandroid;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.yahui.studyandroid.utils.Notice;

public class ImageViewActivity extends Activity {
	
	private EditText pathEdit = null;
	private ImageView imageView = null;
	public static final int CONN_OUT_TIME = 1000; 
	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			if(msg.what==CHANG_UI){
				Bitmap bitmap = (Bitmap) msg.obj;
				imageView.setImageBitmap(bitmap);
			}
			else if(msg.what == ERROR){
				Notice.toastl(ImageViewActivity.this, "获取图片失败，请检查网络或者url");
			}
		}
	};
	public static final int CHANG_UI = 1;
	protected static final int ERROR = 2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_view);
		pathEdit = (EditText) findViewById(R.id.imageapp_edit);
		imageView = (ImageView) super.findViewById(R.id.imageapp_imageview);
	}
	
	/*
	 * 本方法在2.3无错误，只要给权限就行，但在4.1以上就不行了，错误的原因是4以后
	 * 为了保证应用的速度，访问网络的操作不能在主线程上，这涉及到android中一个
	 * 重要的问题-ANR
	 * 
	 * 
	 * */
	public void loadImage1(View view){
		String path = pathEdit.getText().toString().trim();
		if(TextUtils.isEmpty(path)){
			Notice.toasts(this, "图片路径不能为空");
		}
		else{
			//连接服务器，并获取图片
			try{
				URL url = new URL(path);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setConnectTimeout(CONN_OUT_TIME);
				
				//访问服务器，并获取返回码
				int code = conn.getResponseCode();
				if(200==code){
					InputStream is = conn.getInputStream();
					Bitmap bitmap = BitmapFactory.decodeStream(is);
					imageView.setImageBitmap(bitmap);
				}
				Notice.toasts(this, "获取成功");
			}catch(Exception e){
				e.printStackTrace();
				Notice.toasts(this, "获取图片失败"+e.getMessage());
			}
		}
	}
	/*
	 * 这个方法能成功显示图片，但还是会ANR，原因是在子线程里toast,修改了UI
	 */
	public void loadImage2(View view){
		final String path = pathEdit.getText().toString().trim();
		if(TextUtils.isEmpty(path)){
			Notice.toasts(this, "图片路径不能为空");
		}
		else{
			new Thread(){
				public void run(){
					//连接服务器，并获取图片
					try{
						URL url = new URL(path);
						HttpURLConnection conn = (HttpURLConnection) url.openConnection();
						conn.setRequestMethod("GET");
						conn.setConnectTimeout(CONN_OUT_TIME);
						
						//访问服务器，并获取返回码
						int code = conn.getResponseCode();
						if(200==code){
							InputStream is = conn.getInputStream();
							final Bitmap bitmap = BitmapFactory.decodeStream(is);
							imageView.post(new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									imageView.setImageBitmap(bitmap);
								}
							});
						}
						Notice.toasts(ImageViewActivity.this, "获取成功");
					}catch(Exception e){
						e.printStackTrace();
						Notice.toasts(ImageViewActivity.this, "获取图片失败"+e.getMessage());
					}
				}
			}.start();
			
		}
	}
	
	public void loadImage3(View view){
		final String path = pathEdit.getText().toString().trim();
		if(TextUtils.isEmpty(path)){
			Notice.toasts(this, "图片路径不能为空");
		}
		else{
			new Thread(){
				public void run(){
					Message msg = new Message();
					//连接服务器，并获取图片
					try{
						URL url = new URL(path);
						HttpURLConnection conn = (HttpURLConnection) url.openConnection();
						conn.setRequestMethod("GET");
						conn.setConnectTimeout(CONN_OUT_TIME);
						
						//访问服务器，并获取返回码
						int code = conn.getResponseCode();
						if(200==code){
							InputStream is = conn.getInputStream();
							final Bitmap bitmap = BitmapFactory.decodeStream(is);
							//告诉主线程一个消息，帮我改界面，内容是bitmap
							msg.what = CHANG_UI ;
							msg.obj = bitmap;
							handler.sendMessage(msg);
						}
					}catch(Exception e){
						e.printStackTrace();
						msg.what = ERROR;
					}
				}
			}.start();
			
		}
	}
}
