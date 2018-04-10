package com.example.les_provider;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.view.View;

/**
 * ssh 
 * provider暴露数据规则
 * 内容提供者 跑到人家家里拿东西
 * 人家家里指定一种拿东西规则
 * 规则  进程都是不能互相访问内存
 * 作业：读取下载内容
 * @author kulv16
 *
 */
public class MainActivity extends Activity {

	
	
	public void btnClick(View view){
		//uri构成 协议 主机 端口。。  CONTENT_URI author作者  列名 column 
		if(view.getId()==R.id.btn1){
			//读取联系人 uri用来区分不同的数据库
			Cursor cursor=getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,new String[]{ContactsContract.Contacts.DISPLAY_NAME},null, null, null);
			while(cursor.moveToNext()){
				Log.d("TAG",""+cursor.getString(0));
			}
		}else if(view.getId()==R.id.btn2){
			//读取短信
			Cursor cursor=getContentResolver().query(Uri.parse("content://sms/inbox"),null,null,null,null);
			while(cursor.moveToNext()){
				Log.d("TAG",""+cursor.getString(cursor.getColumnIndex("body")));
			}
		}else if(view.getId()==R.id.btn3){
			//读取系统信息
			Cursor cursor=getContentResolver().query(Uri.parse("content://settings/system"), null, null, null, null);
			while(cursor.moveToNext()){
				Log.d("TAG","系统设置名字："+cursor.getString(cursor.getColumnIndex("name"))+",设置值："+cursor.getString(cursor.getColumnIndex("value")));
			}
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
