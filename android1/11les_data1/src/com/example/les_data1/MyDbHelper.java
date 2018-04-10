package com.example.les_data1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDbHelper extends SQLiteOpenHelper {
	
	private final static String DATABASE_NAME = "todo_db";
	private final static int DATABASE_VERSION = 1;
	private final static String TABLE_NAME = "todo_table";
	public final static String FIELD_id = "_id";
	public final static String FIELD_TEXT = "todo_text";

	
	//1、上下文对象2、数据库名字3、游标工厂4、数据库版本号
	public MyDbHelper(Context ctx,String name,CursorFactory factory,int version) {
		//super(context, DATABASE_NAME, null, DATABASE_VERSION);
		super(ctx, name, factory, version);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// 当数据库第一次创建的时候调用这个方法  判断数据库文件是否存在
		//如果数据库文件不存在那么创建数据库打开连接 
		//如果数据文件已经存在打开连接
		//作用：用来初始化表数据 创建表  只会调用一次
		String sql="create table bookinfo(bookid int,bookname varchar(10))";
		db.execSQL(sql);
		Log.d("TAG","onCreate"); 
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//当数据库需要更新的时候调用 如果版本号有更新 版本号只能升不能降
		Log.d("TAG","onUpgrade");
		String sql = "drop table if exists " + "bookinfo";
		db.execSQL(sql);
		onCreate(db);
	}

	
	public Cursor select() {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db
				.query(TABLE_NAME, null, null, null, null, null, null);
		return cursor;
	}

	public long insert(String text) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(FIELD_TEXT, text);
		long row = db.insert(TABLE_NAME, null, cv);
		return row;
	}

	public void delete(int id) {
		SQLiteDatabase db = this.getWritableDatabase();
		String where = FIELD_id + " = ?";
		String[] whereValue = { Integer.toString(id) };
		db.delete(TABLE_NAME, where, whereValue);
	}

	public void update(int id, String text) {
		SQLiteDatabase db = this.getWritableDatabase();
		String where = FIELD_id + " = ?";
		String[] whereValue = { Integer.toString(id) };
		ContentValues cv = new ContentValues();
		cv.put(FIELD_TEXT, text);
		db.update(TABLE_NAME, cv, where, whereValue);
	}

}
