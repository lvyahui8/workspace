package com.yahui.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {

	public DBOpenHelper(Context context) {
		super(context, "user.db", null/*ʹ��ϵͳĬ���α깤�������α�*/, 4);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {//�������ݿ�ÿһ�α�����ʱ���õ�
		db.execSQL("create table person(personid integer primary key autoincrement,name vachar(20))");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("alter table person add phone varchar(12) null");
	}

}
