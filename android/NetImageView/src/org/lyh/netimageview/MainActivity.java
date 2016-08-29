package org.lyh.netimageview;

import java.io.IOException;

import org.lyh.netimageview.service.ImageService;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnKeyListener{

	/*
	 *use 10.0.2.2 for default AVD and 10.0.3.2 for Genymotion，Genymotion访问主机以10.0.3.2访问 
	 */
	private static final String TAG = "netimage";
	protected static final int DOWNLOAD_OK = 0;
	private EditText image_urlText;
	private ImageView imageView;
	private Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, "netimagemainview");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		image_urlText = (EditText) super.findViewById(R.id.image_url);
		imageView = (ImageView) super.findViewById(R.id.image);
		btn = (Button) super.findViewById(R.id.btn);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				getImage();
			}
		});
//		image_urlText.setOnKeyListener(this);
	}

	private Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			switch (msg.what) {
			case DOWNLOAD_OK:
				Bitmap bitmap = (Bitmap) msg.obj;
				imageView.setImageBitmap(bitmap);
				break;
			default:
				break;
			}
		}
		
	};
	
	public void getImage(){
		final String imageUrl = image_urlText.getText().toString();
		if(!"".equals(imageUrl)){
			new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					byte[] data = null;
					Bitmap bitmap = null;
					try {
						data = ImageService.getImage(imageUrl);
						bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
						Message msg = new Message();
						msg.what = DOWNLOAD_OK;
						msg.obj = bitmap;
						handler.sendMessage(msg);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}		
	}
	
	public void toast(String info){
		Toast.makeText(getApplicationContext(), info, 0).show();
	}
	
	@Override
	public boolean onKey(View v, int keyCode, KeyEvent event) {
		String image_url = image_urlText.getText().toString();
		Log.i(TAG, image_url);
		getImage();
		return false;
	}
//	@Override
//	public void onKey(int primaryCode, int[] keyCodes) {
//		// TODO Auto-generated method stub
//		String image_url = image_urlText.getText().toString();
//		Log.i(TAG, image_url);
//		toast(image_url);
//	}
//	@Override
//	public void onPress(int primaryCode) {
//		// TODO Auto-generated method stub
//		Log.i(TAG, "...onPress");
//	}
//	@Override
//	public void onRelease(int primaryCode) {
//		// TODO Auto-generated method stub
//		Log.i(TAG, "...onRelease");
//	}
//	@Override
//	public void onText(CharSequence text) {
//		// TODO Auto-generated method stub
//		Log.i(TAG, text.toString());
//	}
//	@Override
//	public void swipeDown() {
//		// TODO Auto-generated method stub
//		Log.i(TAG, "...swipeDown");
//	}
//	@Override
//	public void swipeLeft() {
//		// TODO Auto-generated method stub
//		Log.i(TAG, "...swipeLeft");
//	}
//	@Override
//	public void swipeRight() {
//		// TODO Auto-generated method stub
//		Log.i(TAG, "...swipeRight");
//	}
//	@Override
//	public void swipeUp() {
//		// TODO Auto-generated method stub
//		Log.i(TAG, "...swipeUp");
//	}
//

}
