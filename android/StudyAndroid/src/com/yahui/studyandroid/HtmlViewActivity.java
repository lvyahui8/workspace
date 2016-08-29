package com.yahui.studyandroid;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.yahui.studyandroid.utils.MyStatus;
import com.yahui.studyandroid.utils.Notice;
import com.yahui.studyandroid.utils.StreamTools;

public class HtmlViewActivity extends Activity {

	private EditText urlEdit = null;
	private TextView htmlView = null;
	
	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			switch(msg.what){
			case MyStatus.ERROR:
				Notice.toasts(HtmlViewActivity.this, "请检查网络或者url");
				break;
			case MyStatus.CHANG_UI:
				htmlView.setText((String)msg.obj);
				Notice.toasts(HtmlViewActivity.this, "下载成功");
				break;
			default:
					break;
			}
			
		}
		
	};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_html_view);
		
		urlEdit = (EditText) super.findViewById(R.id.htmlapp_edit);
		htmlView = (TextView) super.findViewById(R.id.htmlapp_text);
		
	}
	
	public void loadHtml(View view){
		final String url = urlEdit.getText().toString().trim();
		if(TextUtils.isEmpty(url)){
			Notice.toasts(this, "路径不能为空");
		}
		else{
			//访问网络要写在子线程里面
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					Message msg = new Message();
					try{
						URL u = new URL(url);
						HttpURLConnection conn = (HttpURLConnection) u.openConnection();
						conn.setRequestMethod("GET");
						conn.setConnectTimeout(5000);
						
						int code = conn.getResponseCode();
						if(200==code){
							InputStream is = conn.getInputStream();
							String content = StreamTools.Html2TextAutoEncoding(is);
							if(content!=null){
								msg.what = MyStatus.CHANG_UI;
								
								//htmlView.setText(content);//不能直接在子线程里设置
								msg.obj = content;
							}
							else{
								msg.what = MyStatus.ERROR;
							}
						}
						else{
							msg.what = MyStatus.ERROR;
						}
					}catch(Exception e){
						e.printStackTrace();
						msg.what = MyStatus.ERROR;
					}
					finally{
						handler.sendMessage(msg);
					}
				}
			}).start();
		}
		
		
	}

}
