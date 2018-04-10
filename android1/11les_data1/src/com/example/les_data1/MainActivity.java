package com.example.les_data1;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

/**
 * oracle number
 * sqlserver int money
 * mysql	int integer
 * sqlite官方网站确认数据类型  有版本区别
 * 数据存储 提供几种解决方案
 * 1、以键值对的形式存储数据    sharedPreferences
 * 2、手机内存存储                         io
 * 3、外部目录的存储
 * 4、SQLite Databases 数据库 被广泛应用于移动终端设备 Android ios 塞班 wp8...
 * 		轻量级数据库     sqlserver  mysql
 * 5、云服务 
	SQLiteDatabase 每个数据库文件对应一个这样的对象
	数据库文件所在目录
	data/data/应用程序包名/databases/数据库文件
	
	两种创建数据库方式
	sqliteOpenHelper 对象 创建数据和创建表
	getReadableDatabase 打开数据库连接
		如果磁盘已经写满，只会返回只读的数据库操作对象
	getWriteableDatbase 打开数据库连接
		如果磁盘已经写满或者因为权限问题会导致不能正常返回数据库操作对象
	sqlite3 部分命令  .exit退出当前编辑界面
	.tables 查看数据库文件里面所有表
	Cursor 游标
	
	main Thread主线程   只要在activity里面的方法 都是属于主线程
	
	1、数组适配器
	2、简单适配器
	3、游标适配器 作业
	4、自定义适配器
	
 * @author Administrator
 *
 */
public class MainActivity extends Activity {
	SQLiteDatabase sqlite=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//打开数据  只能在ContextWrapper类子类中打开  创建或者打开一个数据库连接
		//如果数据库已经存在就打开数据库 如果数据库不存在就创建一个数据库
		//1、数据库的名字2、数据库的访问模式3、游标工厂  游标类似ResultSet
	/*	SQLiteDatabase sqlite=openOrCreateDatabase("stu", MODE_PRIVATE, null);
		//创建表
		String sql="create table stuinfo(humanid int primary key,humanname varchar(10))";
		//sqlite.execSQL(sql);
		
		sql="insert into humaninfo values(1,'亚当')";
		
		//操作数据库
		//sqlite.execSQL(sql);
		
		//查询数据
		sql="select * from stuinfo";
		//sqlite.query(distinct, table, columns, selection, selectionArgs, groupBy, having, orderBy, limit, cancellationSignal)
		Cursor cursor=sqlite.rawQuery(sql, null);
		if(cursor.moveToFirst()){
			do {
				Log.d("TAG",""+cursor.getString(1));
			} while (cursor.moveToNext());
		}*/
	}

	public void btnClick(View view){
		
		if(view.getId()==R.id.btnCreate){
			//创建数据库
			MyDbHelper helper=new MyDbHelper(this,"bookdb",null,2);
			//非法操作
			sqlite=helper.getReadableDatabase();
		}else if(view.getId()==R.id.btnadd){
			String sql="insert into bookinfo values(1,'小叮当')";
			sqlite.execSQL(sql);
		}else if(view.getId()==R.id.btndel){
			//删除
			String sql="delete from bookinfo where bookid=1";
			sqlite.execSQL(sql);
		}else if(view.getId()==R.id.btnupdate){
			//修改
			String sql="update bookinfo set bookname='血色浪漫' where bookid=1";
			sqlite.execSQL(sql);
			
		}
	}

}
