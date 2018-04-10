package com.renwen.sqlite.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.renwen.sqlite.PersonSqliteOpenHelper;
import com.renwen.sqlite.domain.Person;

public class PersonDao {
	
	private PersonSqliteOpenHelper helper;
	
	public PersonDao(Context ctx){
		helper = new PersonSqliteOpenHelper(ctx);
	}
	
	/**
	 * insert
	 */
	public void add(int id,String name){
		SQLiteDatabase db = helper.getWritableDatabase();
		//��ֹsqlע��
		db.execSQL("insert into person values(?,?)",new Object[]{id,name});
		db.close();
	}
	
	/**
	 * ��ѯ��¼�Ƿ����
	 * @param name
	 * @return
	 */
	public List<Person> find(){
		List<Person> personList=new ArrayList<Person>();
		SQLiteDatabase db = helper.getWritableDatabase();
		Cursor cursor = db.rawQuery("select id,name from person", null);
		
		while(cursor.moveToNext()){
			Person p=new Person(cursor.getInt(cursor.getColumnIndex("id")), cursor.getString(cursor.getColumnIndex("name")));
			personList.add(p);
		}
		cursor.close();
		db.close();
		return personList;
	}
	
	/**
	 * �޸ļ�¼
	 * @param id Ҫ�޸ĵ��˵�id
	 */
	public void update(int id,String name){
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL("update person set name=? where id=?", new Object[]{name,id});
		db.close();
	}
	
	/**
	 * ɾ��һ����¼
	 * @param id Ҫɾ�����˵�id
	 */
	public void delete(int id){
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL("delete from person where id=?", new Object[]{id});
		db.close();
	}
}
