package cn.hnctcm.tescocampus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import cn.hnctcm.tescocampus.adapter.ShopAdapter;
import cn.hnctcm.tescocampus.domain.Shop;

public class MainActivity extends Activity implements OnGestureListener,OnDoubleTapListener  {
	private static final int FLING_MIN_DISTANCE = 50;
	private static final int FLING_MIN_VELOCITY = 0;
	
	Random r = new Random();
	
	private boolean isRun = true;
	private boolean showNext = true;
	
	private ListView home_listView = null;
	private ViewFlipper viewFlipper = null;
	private GestureDetector gestureDetector;

	protected final int SHOW_NEXT = 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		gestureDetector = new GestureDetector(this);
		viewFlipper = (ViewFlipper)super.findViewById(R.id.home_flipper);
//	    viewFlipper.setLongClickable(true);
	    
		home_listView = (ListView)super.findViewById(R.id.home_list);
		
//		MyScrollView myScrollView = (MyScrollView) findViewById(R.id.home_scroll);
//		myScrollView.setOnTouchListener(new OnTouchListener() {
//			
//			@Override
//			public boolean onTouch(View v, MotionEvent event) {
//				// TODO Auto-generated method stub
//				return gestureDetector.onTouchEvent(event);
//			}
//		});
//		myScrollView.setGestureDetector(gestureDetector);
		
		init();
		thread.start();
	}
	
	private void init() {
		List<Shop> shops = new ArrayList<Shop>();
		for (int i = 0; i < 30; i++) {
			shops.add(new Shop("商店"+i,"商店信息介绍"+i,r.nextInt(5)+5,R.drawable.msn007,new Date(System.currentTimeMillis())));
		}
		
		ShopAdapter adapter = new ShopAdapter(this, shops, R.layout.home_list_element);
		home_listView.setAdapter(adapter);
//		setListViewHeightBasedOnChildren(home_listView); 
	}
	
	Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			switch (msg.what) {
			case SHOW_NEXT:
				if (showNext) {
					showNextView();
				} else {
					showPreviousView(); 
				}
				break;

			default:
				break;
			}
		}
		
	};
	Thread thread = new Thread(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(isRun){
				try {
					Thread.sleep(1000 * 3);
					Message msg = new Message();
					msg.what = SHOW_NEXT ;
					
					handler.sendMessage(msg);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	};
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
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		Log.i("Fling", "Activity onTouchEvent!");  
        return this.gestureDetector.onTouchEvent(event);  
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
//		toast("..onFling...");
		// TODO Auto-generated method stub
//		if(e1.getX() > e2.getX()) {//move to left   
//	           viewFlipper.showNext();   
//	       }else if(e1.getX() < e2.getX()) {   
//	    	   viewFlipper.setInAnimation(getApplicationContext(), R.anim.push_right_in);   
//	    	   viewFlipper.setOutAnimation(getApplicationContext(), R.anim.push_right_out);   
//	    	   viewFlipper.showPrevious();   
//	    	   viewFlipper.setInAnimation(getApplicationContext(), R.anim.push_left_in);   
//	    	   viewFlipper.setOutAnimation(getApplicationContext(), R.anim.push_left_out);   
//	       }else {   
//	           return false;   
//	       }   
//	       return true;  
		Log.e("view", "onFling");
		if (e1.getX() - e2.getX()> FLING_MIN_DISTANCE  
                && Math.abs(velocityX) > FLING_MIN_VELOCITY ) {
			Log.e("fling", "left");
			showNextView();
			showNext = true;
//			return true;
		} else if (e2.getX() - e1.getX() > FLING_MIN_DISTANCE  
                && Math.abs(velocityX) > FLING_MIN_VELOCITY){
			Log.e("fling", "right");
			showPreviousView();
			showNext = false;
//			return true;
		}
		return false;
	}
	
	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
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
	
	public void toast(String info){
		Toast.makeText(getApplicationContext(), info, 0).show();
	}

	@Override
	public boolean onDoubleTap(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onDoubleTapEvent(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onSingleTapConfirmed(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}
	
	//修正ListView嵌套在ScrollView中只显示一行的问题
	/**
	 * @param listView
	 */
	public void setListViewHeightBasedOnChildren(ListView listView) {
		// 获取ListView对应的Adapter
		ListAdapter listAdapter = listView.getAdapter();
		if (listAdapter == null) {
			return;
		}

		int totalHeight = 0;
		for (int i = 0, len = listAdapter.getCount(); i < len; i++) {
			// listAdapter.getCount()返回数据项的数目
			View listItem = listAdapter.getView(i, null, listView);
			// 计算子项View 的宽高
			listItem.measure(0, 0);
			// 统计所有子项的总高度
			totalHeight += listItem.getMeasuredHeight();
		}
		
		ViewGroup.LayoutParams params = listView.getLayoutParams();
		params.height = totalHeight
				+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
		
		// listView.getDividerHeight()获取子项间分隔符占用的高度
		// params.height最后得到整个ListView完整显示需要的高度
		listView.setTop(viewFlipper.getHeight());
		listView.setLayoutParams(params);
	
	}

	public void openStores(View v){
		toast("商店");
		Intent intent = new Intent();
		intent.setClass(this, StoreActivity.class);
		super.startActivity(intent);
	}
	
	public void openUserCenter(View v){
		toast("个人中兴");
	}
	
	
}
