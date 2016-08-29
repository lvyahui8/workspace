package cn.test.viewflippetrtest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends Activity implements OnGestureListener{

	private ViewFlipper viewFlipper;
	private Button btn_next ;
	private Button btn_pres ;
	private GestureDetector mGestureDetector;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		viewFlipper = (ViewFlipper) super.findViewById(R.id.home_flipper);
		btn_next = (Button) super.findViewById(R.id.btn_next);
		btn_pres = (Button) super.findViewById(R.id.btn_pres);
		btn_pres.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showPreviousView();
			}
		});
		btn_next.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showNextView();
			}
		});
		viewFlipper.setFlipInterval(1000);
		viewFlipper.startFlipping();
		mGestureDetector = new GestureDetector(this);
	}
	
	
	protected void showNextView() {
		// TODO Auto-generated method stub
		viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_in));
		viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_out));		
		viewFlipper.showNext();
	}

	protected void showPreviousView() {
		// TODO Auto-generated method stub
		viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_right_in));
		viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.push_right_out));
		viewFlipper.showPrevious();
	}

 


	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		Log.i("TAG", "...onDown...");  
		return false;
	}


	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// TODO Auto-generated method stub
		Log.i("TAG", "...onFling...");   
	       if(e1.getX() > e2.getX()) {//move to left   
	           viewFlipper.showNext();   
	       }else if(e1.getX() < e2.getX()) {   
	    	   viewFlipper.setInAnimation(getApplicationContext(), R.anim.push_right_in);   
	    	   viewFlipper.setOutAnimation(getApplicationContext(), R.anim.push_right_out);   
	    	   viewFlipper.showPrevious();   
	    	   viewFlipper.setInAnimation(getApplicationContext(), R.anim.push_left_in);   
	    	   viewFlipper.setOutAnimation(getApplicationContext(), R.anim.push_left_out);   
	       }else {   
	           return false;   
	       }   
	       return true;   
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		Log.i("Fling", "Activity onTouchEvent!");  
        return mGestureDetector.onTouchEvent(event);  
	
	}


	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}


	
}
