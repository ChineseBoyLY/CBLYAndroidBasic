package com.renwen.contextprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

/**
 * 1·首先需要在配置清单里面配置provider
 * 2·写一个类继承ContentProvider
 * @author Administrator
 *
 */
public class PersonDBProvider extends ContentProvider {

//	定义一个uri的匹配器用于匹配uri，如果路径不满足条件就返回-1
	private static UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
	private static final int INSERT = 1;
	private static final int DELETE = 2;
	private static final int UPDATE = 3;
	private static final int QUERY = 4;
	private static final int QUERYONE = 5;
	
	private PersonSqliteOpenHelper helper;
	
	static{
		//添加一组匹配规则
		matcher.addURI("com.renwen.contextprovider.personprovider", "insert", INSERT);
		matcher.addURI("com.renwen.contextprovider.personprovider", "delete", DELETE);
		matcher.addURI("com.renwen.contextprovider.personprovider", "update", UPDATE);
		matcher.addURI("com.renwen.contextprovider.personprovider", "query", QUERY);
		matcher.addURI("com.renwen.contextprovider.personprovider", "query/#", QUERYONE);
	}
	
//	content://com.renwen.contextprovider.personprovider/insert 
//	content://com.renwen.contextprovider.personprovider/delete 
//	content://com.renwen.contextprovider.personprovider/update 
//	content://com.renwen.contextprovider.personprovider/query 
	@Override
	public boolean onCreate() {
		helper=new PersonSqliteOpenHelper(getContext());
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		if(matcher.match(uri)==QUERY){
			//返回查询的结果集
			Log.d("TAG", "打印了");
			SQLiteDatabase db = helper.getReadableDatabase();
			Cursor cursor = db.query("person", projection, selection, selectionArgs, null, null, sortOrder);
			return cursor;
		}else if(matcher.match(uri)==QUERYONE){
			long id = ContentUris.parseId(uri);
			SQLiteDatabase db=helper.getReadableDatabase();
			Cursor cursor=db.query("person", projection, "id=?", new String[]{id+""}, null, null, sortOrder);
			return cursor;
		}else{
			throw new IllegalArgumentException("路径不匹配，不能查询");
		}
		
	}

	@Override
	public String getType(Uri uri) {
		if(matcher.match(uri)==QUERY){
			//返回查询的结果集
			return "vnd.android.cursor.dir/person";
		}else if(matcher.match(uri)==QUERYONE){
			return "vnd.android.cursor.item/person";
		}
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		if(matcher.match(uri)==INSERT){
			//返回查询的结果集
			Log.d("TAG", "打印了");
			SQLiteDatabase db = helper.getWritableDatabase();
			db.insert("person", null, values);
			db.close();
		}else{
			throw new IllegalArgumentException("路径不匹配，不能插入");
		}
		return uri;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		int length=0;
		if(matcher.match(uri)==DELETE){
			//返回查询的结果集
			Log.d("TAG", "打印了");
			SQLiteDatabase db = helper.getWritableDatabase();
			length = db.delete("person", selection, selectionArgs);
		}else{
			throw new IllegalArgumentException("路径不匹配，不能删除");
		}
		return length;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		int length=0;
		if(matcher.match(uri)==UPDATE){
			//返回查询的结果集
			Log.d("TAG", "打印了");
			SQLiteDatabase db = helper.getWritableDatabase();
			length = db.update("person", values, selection, selectionArgs);
		}else{
			throw new IllegalArgumentException("路径不匹配,不能修改");
		}
		return length;
	}

}
