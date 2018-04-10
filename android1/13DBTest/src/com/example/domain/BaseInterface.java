package com.example.domain;

import android.content.ContentValues;
import android.database.Cursor;

/**
 * 业务操作接口，可自定义适合自己的查询方法
 * 
 * @author 小孩子 2014年2月25日 09:22:45 QQ：1065885952
 * */
public interface BaseInterface {

	/**
	 * 新增
	 * 
	 * @param 新增内容
	 *            key-value
	 * */
	abstract void Add(ContentValues values);

	/**
	 * 更新
	 * 
	 * @param values
	 *            更新内容 key-value
	 * @param whereClause
	 *            更新条件 例如：id=?，?为通配符
	 * @param whereArgs
	 *            条件集合 例如：new String[]{"1"}
	 * 
	 * */
	abstract void Update(ContentValues values, String whereClause,
			String[] whereArgs);

	/**
	 * 更新
	 * 
	 * @param whereClause
	 *            删除条件 例如：id=?，?为通配符
	 * @param whereArgs
	 *            删除集合 例如：new String[]{"1"}
	 * 
	 * */
	abstract void Delete(String whereClause, String[] whereArgs);

	/**
	 * 查询
	 * 
	 * 必须在Cursor使用之后，才可以关闭数据库连接。 例如：Cursor.moveToNext()执行的时候，才会去查询数据库中是否有数据。
	 * 
	 * @param columns
	 *            返回列
	 * @param selection
	 *            查询条件 例如：id=?，?为通配符
	 * @param selectionArgs
	 *            条件集合 例如： new String[]{"1"}
	 * @param groupBy
	 *            分组
	 * @param having
	 * @param orderBy
	 *            排序
	 * 
	 * */
	abstract Cursor Query(String[] columns, String selection,
			String[] selectionArgs, String groupBy, String having,
			String orderBy);

}
