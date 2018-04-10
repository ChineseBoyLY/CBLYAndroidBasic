package com.example.les_data1;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity extends Activity {
	List<String> list;
	ListView lv;
	//���ݿ��������
	SQLiteDatabase sqlite;
	ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view);
		ListView lv=(ListView)findViewById(R.id.lv);
		
		//������ݿ��������
		MyDbHelper helper=new MyDbHelper(this,"bookdb",null,2);
		sqlite=helper.getWritableDatabase();
		
		list=new ArrayList<String>();
		
		Cursor cursor=sqlite.rawQuery("select * from bookinfo",null);
		if(cursor.moveToFirst()){
			do {
				list.add(cursor.getString(1));
			} while (cursor.moveToNext());
		}
		//�ر��α�
		cursor.close();
		//�ر����ݿ�����
		sqlite.close();
		//����ͼ���
		adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
		lv.setAdapter(adapter);
	}

	public void btnClick(View view){
		list.clear();
		Cursor cursor=sqlite.rawQuery("select * from bookinfo",null);
		if(cursor.moveToFirst()){
			do {
				list.add(cursor.getString(1));
			} while (cursor.moveToNext());
		}
		adapter.notifyDataSetChanged();
	}

}
