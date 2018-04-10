package com.renwen.sqlite.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Contacts.Intents.Insert;

import com.renwen.sqlite.PersonSqliteOpenHelper;
import com.renwen.sqlite.domain.Person;

public class PersonDao2 {
	
	private PersonSqliteOpenHelper helper;
	
	public PersonDao2(Context ctx){
		helper = new PersonSqliteOpenHelper(ctx);
	}
	
	/**
	 * insert
	 */
	public long add(int id,String name){
		long length=0;
		SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues values=new ContentValues();
		values.put("id", id);
		values.put("name", name);
//		第二个参数：是否允许插入空值，如果表里面定义了不允许插入一个空值，则插不进去；反之，插入一个NULL
		length = db.insert("person", null, values);
		db.close();
//		产生错误返回-1
		return length;
	}
	
	public Person findById(int id){
		SQLiteDatabase db = helper.getWritableDatabase();
		Cursor cursor = db.query("person", new String[]{"id","name"}, "id=?", new String[]{id+""}, null, null, null);
		Person p=null;
		while(cursor.moveToNext()){
			p=new Person(cursor.getInt(cursor.getColumnIndex("id")), cursor.getString(cursor.getColumnIndex("name")));
		}
		cursor.close();
		db.close();
		return p;
	}
	
	/**
	 * 查询记录
	 * @return
	 */
	public List<Person> findAll(){
		List<Person> personList=new ArrayList<Person>();
		SQLiteDatabase db = helper.getWritableDatabase();
		Cursor cursor = db.query(true, "person", new String[]{"id","name"}, null, null, null, null, null, null);
		while(cursor.moveToNext()){
			Person p=new Person(cursor.getInt(cursor.getColumnIndex("id")), cursor.getString(cursor.getColumnIndex("name")));
			personList.add(p);
		}
		cursor.close();
		db.close();
		return personList;
	}
	
	/**
	 * 修改记录
	 * @param id 要修改的人的id
	 */
	public int update(int id,String name){
		int length=0;
		SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues values=new ContentValues();
		values.put("name", name);
		length = db.update("person", values, "id=?", new String[]{id+""});
		db.close();
		return length;
	}
	
	/**
	 * 删除一条记录
	 * @param id 要删除的人的id
	 */
	public int delete(int id){
		int length=0;
		SQLiteDatabase db = helper.getWritableDatabase();
		length = db.delete("person", "id=?", new String[]{id+""});
		db.close();
		return length;
	}
}
