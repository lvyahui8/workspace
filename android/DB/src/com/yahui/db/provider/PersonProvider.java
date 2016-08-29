package com.yahui.db.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.yahui.service.DBOpenHelper;

public class PersonProvider extends ContentProvider {

	private DBOpenHelper helper;
	//  http://www.google.com		//网络资源uri规范
	//android uri命名规范
	//	content://com.yahui.db.personprovider/insert  	添加操作
	//	content://com.yahui.db.personprovider/delete  	删除操作
	//	content://com.yahui.db.personprovider/update  	更新操作
	//	content://com.yahui.db.personprovider/query		查询操作
	
	//定义一个uri的匹配器，用于匹配uri，如果不满足条件返回UriMatcher.NO_MATCH，就是-1
	private static UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
	private static final int INSERT = 1;
	private static final int DELETE = 2;
	private static final int UPDATE = 3;
	private static final int QUERY = 4;
	
	static {
		matcher.addURI("com.yahui.db.personprovider","insert",INSERT);
		matcher.addURI("com.yahui.db.personprovider","delete",DELETE);
		matcher.addURI("com.yahui.db.personprovider","update",UPDATE);
		matcher.addURI("com.yahui.db.personprovider","query",QUERY);
	}
	
	@Override
	public int delete(Uri uri, String selection, String[] args) {
		// TODO Auto-generated method stub
		if(matcher.match(uri) == DELETE){
			//返回查询的结果集
			SQLiteDatabase db = helper.getReadableDatabase();
			db.delete("person", selection, args);
			return 0;
		}
		else{
			throw new IllegalArgumentException("路径不匹配，不能执行 删除");
		}
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		if(matcher.match(uri) == INSERT){
			//返回查询的结果集
			SQLiteDatabase db = helper.getReadableDatabase();
			db.insert("person", null,values);
			return null;
		}
		else{
			throw new IllegalArgumentException("路径不匹配，不能执行 插入");
		}
	}

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		helper = new DBOpenHelper(getContext());
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		
		if(matcher.match(uri) == QUERY){
			//返回查询的结果集
			SQLiteDatabase db = helper.getReadableDatabase();
			Cursor cursor = db.query("person", projection, selection, selectionArgs, null, null, sortOrder);
			return cursor;
		}
		else{
			throw new IllegalArgumentException("路径不匹配，不能执行 查询");
		}
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		if(matcher.match(uri) == UPDATE){
			//返回查询的结果集
			SQLiteDatabase db = helper.getReadableDatabase();
			db.update("person", values, selection, selectionArgs);
			return 0;
		}
		else{
			throw new IllegalArgumentException("路径不匹配，不能执行 查询");
		}
	}

}
