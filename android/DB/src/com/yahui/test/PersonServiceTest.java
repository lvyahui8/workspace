package com.yahui.test;

import java.util.List;

import android.database.sqlite.SQLiteOpenHelper;
import android.test.AndroidTestCase;
import android.util.Log;

import com.yahui.domain.Shop;
import com.yahui.service.DBOpenHelper;
import com.yahui.service.PersonService;

public class PersonServiceTest extends AndroidTestCase{
	private static final String TAG = "PersonServiceTest";
	public void testCreateDB() throws Exception{
		SQLiteOpenHelper dbhp = new DBOpenHelper(getContext());
		dbhp.getWritableDatabase();
	}

	public void testSave() throws Exception{
		PersonService service = new PersonService(this.getContext());
		for(int i=0;i<20;i++){
			Shop person = new Shop("ÑÇ»Ô"+i,"1234-"+i);
			service.save(person);
		}
		
	}
	public void testDelete() throws Exception{
		PersonService service = new PersonService(this.getContext());
		service.dealete(21);
	}
	public void testUpdate() throws Exception{
		PersonService service = new PersonService(this.getContext());
		Shop p = service.find(1);
		p.setName("lvyahui");
		service.update(p);
	}
	public void testFind() throws Exception{
		PersonService service = new PersonService(this.getContext());
		Shop p = service.find(1);
		if(p!=null) Log.i(TAG, p.toString());
	}
	public void testScrollData() throws Exception{
		PersonService service = new PersonService(this.getContext());
		List<Shop> persons = service.getScrollData(10, 5);
		for(Shop p : persons){
			Log.i(TAG, p.toString());
		}
	}
	public void testGetCount() throws Exception{
		PersonService service = new PersonService(this.getContext());
		long result  = service.getCount();
		Log.i(TAG, String.valueOf(result));
System.out.println(String.valueOf(result));
	}
}
