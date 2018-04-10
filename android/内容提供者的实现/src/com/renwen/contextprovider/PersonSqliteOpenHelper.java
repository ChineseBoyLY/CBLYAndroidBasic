package com.renwen.contextprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class PersonSqliteOpenHelper extends SQLiteOpenHelper{
/**
 * ���ݿ�Ĺ��췽��
 * @param context
 * @param name
 * @param factory
 * @param version
 */
	public PersonSqliteOpenHelper(Context context) {
		super(context, "person.db", null, 1);
	}

	/**
	 * ���ݿ��һ�α�������ʱ����õķ���
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		//��ʼ�����ݿ�ı�ṹ
//		db.execSQL("create table person(id int primary key,name varchar(20))");
		
//		for (int i = 0; i < 30; i++) {
//			ContentValues values = new ContentValues();
//			values.put("id", i+1);
//			values.put("name", "tom"+i+1);
//			db.insert("person", null, values);
//		}
	}
	
	/**
	 * �����ݿ�İ汾�����ӵ�ʱ�����
	 * �������ݿ�ı�ṹ��ʱ��ʹ��
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.i("TAG", "���ݿ�İ汾�ŷ����˱仯");
		db.execSQL("alter table person add account varchar(20)");
	}
	
}
