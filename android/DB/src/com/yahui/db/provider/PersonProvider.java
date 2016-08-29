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
	//  http://www.google.com		//������Դuri�淶
	//android uri�����淶
	//	content://com.yahui.db.personprovider/insert  	��Ӳ���
	//	content://com.yahui.db.personprovider/delete  	ɾ������
	//	content://com.yahui.db.personprovider/update  	���²���
	//	content://com.yahui.db.personprovider/query		��ѯ����
	
	//����һ��uri��ƥ����������ƥ��uri�������������������UriMatcher.NO_MATCH������-1
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
			//���ز�ѯ�Ľ����
			SQLiteDatabase db = helper.getReadableDatabase();
			db.delete("person", selection, args);
			return 0;
		}
		else{
			throw new IllegalArgumentException("·����ƥ�䣬����ִ�� ɾ��");
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
			//���ز�ѯ�Ľ����
			SQLiteDatabase db = helper.getReadableDatabase();
			db.insert("person", null,values);
			return null;
		}
		else{
			throw new IllegalArgumentException("·����ƥ�䣬����ִ�� ����");
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
			//���ز�ѯ�Ľ����
			SQLiteDatabase db = helper.getReadableDatabase();
			Cursor cursor = db.query("person", projection, selection, selectionArgs, null, null, sortOrder);
			return cursor;
		}
		else{
			throw new IllegalArgumentException("·����ƥ�䣬����ִ�� ��ѯ");
		}
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		if(matcher.match(uri) == UPDATE){
			//���ز�ѯ�Ľ����
			SQLiteDatabase db = helper.getReadableDatabase();
			db.update("person", values, selection, selectionArgs);
			return 0;
		}
		else{
			throw new IllegalArgumentException("·����ƥ�䣬����ִ�� ��ѯ");
		}
	}

}
