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
	 * ����Ĵ������
	 */
	public void testTransaction(){
		PersonSqliteOpenHelper helper = new PersonSqliteOpenHelper(getContext());
		SQLiteDatabase db = helper.getWritableDatabase();
		db.beginTransaction();
		
		//ת�˵�һЩ����
		
		db.endTransaction();
		db.close();
	}
}
