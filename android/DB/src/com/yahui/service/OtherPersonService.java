package com.yahui.service;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.yahui.domain.Shop;

public class OtherPersonService {
	private DBOpenHelper dbOpenHelter;
	
	
	public OtherPersonService(Context context) {
		this.dbOpenHelter = new DBOpenHelper(context);
	}
	public void save(Shop person){
		SQLiteDatabase db = dbOpenHelter.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("name", person.getName());
		values.put("phone", person.getPhone());
		db.insert("person", null, values);
	}
	public void dealete(Integer id){
		SQLiteDatabase db = dbOpenHelter.getWritableDatabase();
		db.delete("person", "personid=?", new String[]{id.toString()});
	}
	public void update(Shop person){
		SQLiteDatabase db = dbOpenHelter.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("name", person.getName());
		values.put("phone", person.getPhone());
		db.update("person", values, "personid=?", new String[] {person.getId().toString()});
	}
	public Shop find(Integer id){
		SQLiteDatabase db = dbOpenHelter.getReadableDatabase();
		Cursor cursor = db.query("person", new String[]{"personid","name","phone"}, 
				"personid=?",new String[]{id.toString()}, null, null, null);
		Shop person = null;
		if(cursor.moveToFirst()){
			person = new Shop();
			person.setId(id);
			person.setName(cursor.getString(cursor.getColumnIndex("name")));
			person.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
		}
		cursor.close();
		return person;
	}
	/**
	 * 分页获取记录
	 * @param offset 跳过前面多少条记录
	 * @param maxResult 每页获取多少条记录
	 * @return
	 */
	public List<Shop> getScrollData(int offset,int maxResult){
		SQLiteDatabase db = dbOpenHelter.getReadableDatabase();
		Cursor cursor = db.query("person", null, null, null, null, null ,"personid asc",offset+","+maxResult);
		List<Shop> persons = new ArrayList<Shop>();
		Shop person = null;
		while(cursor.moveToNext()){
			person = new Shop();
			person.setId(cursor.getInt(cursor.getColumnIndex("personid")));
			person.setName(cursor.getString(cursor.getColumnIndex("name")));
			person.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
			persons.add(person);
		}
		cursor.close();
		return persons;
	}
	
	public long getCount(){
		SQLiteDatabase db = dbOpenHelter.getReadableDatabase();
		Cursor cursor = db.query("person", new String[]{"count(*)"}, null, null, null, null, null);
		cursor.moveToFirst();
		long result = cursor.getLong(0);
		cursor.close();
		return result;
	}
}
