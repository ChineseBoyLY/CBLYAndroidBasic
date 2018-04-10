package com.renwen.contextprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class PersonSqliteOpenHelper extends SQLiteOpenHelper{
/**
 * 数据库的构造方法
 * @param context
 * @param name
 * @param factory
 * @param version
 */
	public PersonSqliteOpenHelper(Context context) {
		super(context, "person.db", null, 1);
	}

	/**
	 * 数据库第一次被创建的时候调用的方法
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		//初始化数据库的表结构
//		db.execSQL("create table person(id int primary key,name varchar(20))");
		
//		for (int i = 0; i < 30; i++) {
//			ContentValues values = new ContentValues();
//			values.put("id", i+1);
//			values.put("name", "tom"+i+1);
//			db.insert("person", null, values);
//		}
	}
	
	/**
	 * 当数据库的版本号增加的时候调用
	 * 更新数据库的表结构的时候使用
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.i("TAG", "数据库的版本号发生了变化");
		db.execSQL("alter table person add account varchar(20)");
	}
	
}
