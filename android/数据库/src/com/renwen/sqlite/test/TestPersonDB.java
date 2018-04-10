package com.renwen.sqlite.test;

import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import com.renwen.sqlite.PersonSqliteOpenHelper;

public class TestPersonDB extends AndroidTestCase {
	
	public void testCreateDB() throws Exception{
		PersonSqliteOpenHelper helper = new PersonSqliteOpenHelper(getContext());
		helper.getWritableDatabase();
	}
	
	/**
	 * 事物的处理操作
	 */
	public void testTransaction(){
		PersonSqliteOpenHelper helper = new PersonSqliteOpenHelper(getContext());
		SQLiteDatabase db = helper.getWritableDatabase();
		db.beginTransaction();
		
		//转账的一些操作
		
		db.endTransaction();
		db.close();
	}
}
