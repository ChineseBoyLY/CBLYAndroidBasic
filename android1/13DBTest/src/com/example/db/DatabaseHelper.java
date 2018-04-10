package com.example.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 数据库管理
 * 
 * @author 小孩子 2014年2月25日 09:22:45 QQ：1065885952
 * */
public class DatabaseHelper extends SQLiteOpenHelper {

	private DatabaseHelper(Context context, String dbName,
			CursorFactory factory, int version) {
		super(context, dbName, factory, version);
	}

	public DatabaseHelper(Context context, String dbName, int version) {
		this(context, dbName, null, version);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		System.out.println("DBHelper onCreate");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		System.out.println("DBHelper onUpgrade");

		try {
			// // 备份数据库到SD卡的/aDBTest/DBTest.db
			// CopyDBToSDCard.CopyDB(mContext);
			for (int i = oldVersion; i < newVersion; i++) {
				switch (i) {
				case 1:
					DatabaseVersionManagement.UpgradedVersion1To2(db);
					break;

				default:
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
