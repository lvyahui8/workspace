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
				Notice.toastl(ImageViewActivity.this, "��ȡͼƬʧ�ܣ������������url");
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
	 * ��������2.3�޴���ֻҪ��Ȩ�޾��У�����4.1���ϾͲ����ˣ������ԭ����4�Ժ�
	 * Ϊ�˱�֤Ӧ�õ��ٶȣ���������Ĳ������������߳��ϣ����漰��android��һ��
	 * ��Ҫ������-ANR
	 * 
	 * 
	 * */
	public void loadImage1(View view){
		String path = pathEdit.getText().toString().trim();
		if(TextUtils.isEmpty(path)){
			Notice.toasts(this, "ͼƬ·������Ϊ��");
		}
		else{
			//���ӷ�����������ȡͼƬ
			try{
				URL url = new URL(path);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setConnectTimeout(CONN_OUT_TIME);
				
				//���ʷ�����������ȡ������
				int code = conn.getResponseCode();
				if(200==code){
					InputStream is = conn.getInputStream();
					Bitmap bitmap = BitmapFactory.decodeStream(is);
					imageView.setImageBitmap(bitmap);
				}
				Notice.toasts(this, "��ȡ�ɹ�");
			}catch(Exception e){
				e.printStackTrace();
				Notice.toasts(this, "��ȡͼƬʧ��"+e.getMessage());
			}
		}
	}
	/*
	 * ��������ܳɹ���ʾͼƬ�������ǻ�ANR��ԭ���������߳���toast,�޸���UI
	 */
	public void loadImage2(View view){
		final String path = pathEdit.getText().toString().trim();
		if(TextUtils.isEmpty(path)){
			Notice.toasts(this, "ͼƬ·������Ϊ��");
		}
		else{
			new Thread(){
				public void run(){
					//���ӷ�����������ȡͼƬ
					try{
						URL url = new URL(path);
						HttpURLConnection conn = (HttpURLConnection) url.openConnection();
						conn.setRequestMethod("GET");
						conn.setConnectTimeout(CONN_OUT_TIME);
						
						//���ʷ�����������ȡ������
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
						Notice.toasts(ImageViewActivity.this, "��ȡ�ɹ�");
					}catch(Exception e){
						e.printStackTrace();
						Notice.toasts(ImageViewActivity.this, "��ȡͼƬʧ��"+e.getMessage());
					}
				}
			}.start();
			
		}
	}
	
	public void loadImage3(View view){
		final String path = pathEdit.getText().toString().trim();
		if(TextUtils.isEmpty(path)){
			Notice.toasts(this, "ͼƬ·������Ϊ��");
		}
		else{
			new Thread(){
				public void run(){
					Message msg = new Message();
					//���ӷ�����������ȡͼƬ
					try{
						URL url = new URL(path);
						HttpURLConnection conn = (HttpURLConnection) url.openConnection();
						conn.setRequestMethod("GET");
						conn.setConnectTimeout(CONN_OUT_TIME);
						
						//���ʷ�����������ȡ������
						int code = conn.getResponseCode();
						if(200==code){
							InputStream is = conn.getInputStream();
							final Bitmap bitmap = BitmapFactory.decodeStream(is);
							//�������߳�һ����Ϣ�����ҸĽ��棬������bitmap
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
