package com.yahui.service;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.yahui.domain.Shop;

public class PersonService {
	private DBOpenHelper dbOpenHelter;
	
	
	public PersonService(Context context) {
		this.dbOpenHelter = new DBOpenHelper(context);
	}
	public void save(Shop person){
		SQLiteDatabase db = dbOpenHelter.getWritableDatabase();
		db.execSQL("insert into person(name,phone) values(?,?)"
				,new Object[]{person.getName(),person.getPhone()}); 
		
	}
	public void dealete(Integer id){
		SQLiteDatabase db = dbOpenHelter.getWritableDatabase();
		db.execSQL("delete from person where personid=?"
				,new Object[]{id}); 
	}
	public void update(Shop person){
		SQLiteDatabase db = dbOpenHelter.getWritableDatabase();
		db.execSQL("update person set name=?,phone=? where personid=?"
				,new Object[]{person.getName(),person.getPhone(),person.getId()}); 
	}
	public Shop find(Integer id){
		SQLiteDatabase db = dbOpenHelter.getReadableDatabase();
		Cursor cursor = db.rawQuery("select * from person where personid=?", new String[]{id.toString()});
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
		Cursor cursor = db.rawQuery("select * from person order by personid asc limit ?,?",
				new String[]{String.valueOf(offset),String.valueOf(maxResult)});
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
	public Cursor getCursorData(int offset,int maxResult){
		SQLiteDatabase db = dbOpenHelter.getReadableDatabase();
		Cursor cursor = db.rawQuery("select personid as _id,name,phone from person order by personid asc limit ?,?",
				new String[]{String.valueOf(offset),String.valueOf(maxResult)});
		
		return cursor;
	}
	public long getCount(){
		SQLiteDatabase db = dbOpenHelter.getReadableDatabase();
		Cursor cursor = db.rawQuery("select count(*) from person",
				null);
		cursor.moveToFirst();
		long result = cursor.getLong(0);
		cursor.close();
		return result;
	}
}
