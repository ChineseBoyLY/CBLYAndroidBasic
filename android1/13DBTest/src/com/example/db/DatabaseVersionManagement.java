package com.example.db;

import android.database.sqlite.SQLiteDatabase;

/**
 * 数据库版本管理
 * 
 * @author 小孩子 2014年2月25日 09:22:45 QQ：1065885952
 * */
public class DatabaseVersionManagement {

	/**
	 * 数据库版本升级：1 to 2
	 * 
	 * */
	public static void UpgradedVersion1To2(SQLiteDatabase db) {

		try {
			db.execSQL("alter table user rename to temp_user");

			db.execSQL("drop table if exists user");

			db.execSQL("create table if not exists user(id INTEGER PRIMARY KEY AUTOINCREMENT, name varchar(10), remark varchar(50), age varchar(10))");

			db.execSQL("insert into user select id, name, remark, 'age_lala' from temp_user");

			db.execSQL("drop table if exists temp_user");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
