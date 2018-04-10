package com.example.domain;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.db.DatabaseHelper;
import com.example.dbtest.Constant;

/**
 * 业务操作父类，主要负责数据库的打开与关闭，获取数据库版本。
 * 
 * @author 小孩子 2014年2月25日 09:22:45 QQ：1065885952
 * */
public class BaseEx implements BaseInterface {

	private DatabaseHelper dbHelper = null;
	private SQLiteDatabase db = null;
	private Context mContext = null;

	private int dbVersion = 1;

	public BaseEx(Context context) {

		try {
			this.mContext = context;
			this.dbVersion = context.getPackageManager().getPackageInfo(
					context.getPackageName(), 0).versionCode;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void openDBConnect() {
		dbHelper = new DatabaseHelper(mContext, Constant.DB_NAME, dbVersion);
		db = dbHelper.getWritableDatabase();
	}

	public void closeDBConnect() {
		if (db != null) {
			db.close();
		}
		if (dbHelper != null) {
			dbHelper.close();
		}
	}

	@Override
	public void Add(ContentValues values) {

	}

	@Override
	public void Update(ContentValues values, String whereClause,
			String[] whereArgs) {

	}

	@Override
	public void Delete(String whereClause, String[] whereArgs) {

	}

	@Override
	public Cursor Query(String[] columns, String selection,
			String[] selectionArgs, String groupBy, String having,
			String orderBy) {
		return null;

	}

	public DatabaseHelper getDbHelper() {
		return dbHelper;
	}

	public SQLiteDatabase getDb() {
		return db;
	}

}
