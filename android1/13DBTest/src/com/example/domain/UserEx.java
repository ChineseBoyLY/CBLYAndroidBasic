package com.example.domain;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * User业务操作
 * 
 * @author 小孩子 2014年2月25日 09:22:45 QQ：1065885952
 * */
public class UserEx extends BaseEx {

	private final static String TABLENAME = "user";

	public UserEx(Context context) {
		super(context);
	}

	@Override
	public void Add(ContentValues values) {
		try {
			openDBConnect();

			getDb().insert(TABLENAME, null, values);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDBConnect();
		}
	}

	@Override
	public void Update(ContentValues values, String whereClause,
			String[] whereArgs) {
		try {
			openDBConnect();

			getDb().update(TABLENAME, values, whereClause, whereArgs);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDBConnect();
		}
	}

	@Override
	public void Delete(String whereClause, String[] whereArgs) {
		try {
			openDBConnect();

			getDb().delete(TABLENAME, whereClause, whereArgs);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDBConnect();
		}
	}

	// 该方法可以修改返回值参数为List<T>或其他自定义返回值，注意关闭数据库连接。
	@Override
	public Cursor Query(String[] columns, String selection,
			String[] selectionArgs, String groupBy, String having,
			String orderBy) {
		Cursor cursor = null;
		try {
			openDBConnect();

			cursor = getDb().query(TABLENAME, columns, selection,
					selectionArgs, groupBy, having, orderBy);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// TODO:关闭数据库连接的动作(super.stopDBConnect())，需在Cursor使用结束之后执行。
		}

		return cursor;
	}

}
