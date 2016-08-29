package com.yahui.test;

import java.util.List;

import android.database.sqlite.SQLiteOpenHelper;
import android.test.AndroidTestCase;
import android.util.Log;

import com.yahui.domain.Shop;
import com.yahui.service.DBOpenHelper;
import com.yahui.service.OtherPersonService;

public class OtherPersonServiceTest extends AndroidTestCase{
	private static final String TAG = "PersonServiceTest";
	public void testCreateDB() throws Exception{
		SQLiteOpenHelper dbhp = new DBOpenHelper(getContext());
		dbhp.getWritableDatabase();
	}
	
	@Override
	protected void setUp() throws Exception {//每个测试方法调用之前都会调用的方法
		super.setUp();
	}

	public void testSave() throws Exception{
		OtherPersonService service = new OtherPersonService(this.getContext());
		for(int i=0;i<20;i++){
			Shop person = new Shop("亚辉"+i,"1234-"+i);
			service.save(person);
		}
	}
	
	public void testDelete() throws Exception{
		OtherPersonService service = new OtherPersonService(this.getContext());
		service.dealete(21);
	}
	public void testUpdate() throws Exception{
		OtherPersonService service = new OtherPersonService(this.getContext());
		Shop p = service.find(1);
		p.setName("lvyahui");
		service.update(p);
	}
	public void testFind() throws Exception{
		OtherPersonService service = new OtherPersonService(this.getContext());
		Shop p = service.find(1);
		Log.i(TAG, p.toString());
	}
	public void testScrollData() throws Exception{
		OtherPersonService service = new OtherPersonService(this.getContext());
		List<Shop> persons = service.getScrollData(10, 5);
		for(Shop p : persons){
			Log.i(TAG, p.toString());
		}
	}
	public void testGetCount() throws Exception{
		OtherPersonService service = new OtherPersonService(this.getContext());
		long result  = service.getCount();
		Log.i(TAG, String.valueOf(result));
System.err.println(String.valueOf(result));
	}
}
