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
 * provider��¶���ݹ���
 * �����ṩ�� �ܵ��˼Ҽ����ö���
 * �˼Ҽ���ָ��һ���ö�������
 * ����  ���̶��ǲ��ܻ�������ڴ�
 * ��ҵ����ȡ��������
 * @author kulv16
 *
 */
public class MainActivity extends Activity {

	
	
	public void btnClick(View view){
		//uri���� Э�� ���� �˿ڡ���  CONTENT_URI author����  ���� column 
		if(view.getId()==R.id.btn1){
			//��ȡ��ϵ�� uri�������ֲ�ͬ�����ݿ�
			Cursor cursor=getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,new String[]{ContactsContract.Contacts.DISPLAY_NAME},null, null, null);
			while(cursor.moveToNext()){
				Log.d("TAG",""+cursor.getString(0));
			}
		}else if(view.getId()==R.id.btn2){
			//��ȡ����
			Cursor cursor=getContentResolver().query(Uri.parse("content://sms/inbox"),null,null,null,null);
			while(cursor.moveToNext()){
				Log.d("TAG",""+cursor.getString(cursor.getColumnIndex("body")));
			}
		}else if(view.getId()==R.id.btn3){
			//��ȡϵͳ��Ϣ
			Cursor cursor=getContentResolver().query(Uri.parse("content://settings/system"), null, null, null, null);
			while(cursor.moveToNext()){
				Log.d("TAG","ϵͳ�������֣�"+cursor.getString(cursor.getColumnIndex("name"))+",����ֵ��"+cursor.getString(cursor.getColumnIndex("value")));
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
