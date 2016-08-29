package cn.yahui.audioplayer;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	


	private static final String TAG = "TAG";
	private EditText audioNameText ;
	private String audio_path;
	private MediaPlayer mediaPlayer;
	private boolean pause;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mediaPlayer = new MediaPlayer();
		audioNameText =  (EditText) super.findViewById(R.id.audio_name);
		super.findViewById(R.id.play).setOnClickListener(this);
		super.findViewById(R.id.pause).setOnClickListener(this);
		super.findViewById(R.id.replay).setOnClickListener(this);
		super.findViewById(R.id.stop).setOnClickListener(this);
	}
	
	
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		this.mediaPlayer.release();
		this.mediaPlayer = null;
		super.onDestroy();
	}



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Log.e(TAG, "onClick");
		switch (v.getId()) {
		case R.id.play:
			String audio_name =  audioNameText.getText().toString();
			File audio = new File(Environment.getExternalStorageDirectory(),audio_name);
			if(audio.exists()){
				audio_path = audio.getAbsolutePath();
				play();
			}
			else{
				audio_path = null;
				Toast.makeText(getApplicationContext(), R.string.file_not_exist	,0).show();
			}
			break;
		case R.id.pause:
			if(this.mediaPlayer.isPlaying()){
				mediaPlayer.pause();
				pause = true;
				((Button)v).setText(R.string.continues);
			}
			else{
				if(pause){
					mediaPlayer.start();
					pause = false;
					((Button)v).setText(R.string.pause);
				}
			}
			break;
		case R.id.replay:
			if(this.mediaPlayer.isPlaying()){
				mediaPlayer.seekTo(0);
			}
			else {
				if(audio_path != null){
					play();
				}
			}
			break;
		case R.id.stop:
			if (this.mediaPlayer.isPlaying()) {
				this.mediaPlayer.stop();
			}
		default:
			break;
		}
	}


	private void play() {
		// TODO Auto-generated method stub
		this.mediaPlayer.reset();//各项参数重置
		try {
			this.mediaPlayer.setDataSource(audio_path);
			this.mediaPlayer.prepare();//进行缓冲
			this.mediaPlayer.setOnPreparedListener(new PrepareListener());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public class PrepareListener implements OnPreparedListener {

		@Override
		public void onPrepared(MediaPlayer mp) {
			// TODO Auto-generated method stub
			MainActivity.this.mediaPlayer.start();
		}

	}
}
