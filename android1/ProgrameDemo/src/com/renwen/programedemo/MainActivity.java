package com.renwen.programedemo;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends Activity {

	ListView listView;
	SQLiteDatabase sqlite;
	CursorAdapter adapter;
	
	EditText et_title;
	EditText et_low;
	EditText et_high;
	
	CheckBox cb1;
	CheckBox cb2;
	CheckBox cb3;
	CheckBox cb4;
	CheckBox cb5;
	CheckBox cb6;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = (ListView) this.findViewById(R.id.lv);
		
		et_title=(EditText) findViewById(R.id.title);
		et_low=(EditText) findViewById(R.id.low);
		et_high=(EditText) findViewById(R.id.high);
		
		cb1=(CheckBox) findViewById(R.id.cb1);
		cb2=(CheckBox) findViewById(R.id.cb2);
		cb3=(CheckBox) findViewById(R.id.cb3);
		cb4=(CheckBox) findViewById(R.id.cb4);
		cb5=(CheckBox) findViewById(R.id.cb5);
		cb6=(CheckBox) findViewById(R.id.cb6);
	}
	
	public void btnClick(View view){
		if(view.getId()==R.id.btn1){
			String cb1Text="";
			String cb2Text="";
			String cb3Text="";
			String cb4Text="";
			String cb5Text="";
			String cb6Text="";
			if(cb1.isChecked()){
				cb1Text= cb1.getText().toString();
			}
			if(cb2.isChecked()){
				cb2Text= cb2.getText().toString();
			}
			if(cb3.isChecked()){
				cb3Text= cb3.getText().toString();
			}
			if(cb4.isChecked()){
				cb4Text= cb4.getText().toString();
			}
			if(cb5.isChecked()){
				cb5Text= cb5.getText().toString();
			}
			if(cb6.isChecked()){
				cb6Text= cb6.getText().toString();
			}
			
			MyOpenHelper helper = new MyOpenHelper(MainActivity.this, "book.db",null, 1);
			sqlite = helper.getWritableDatabase();
			
			Cursor cursor = sqlite.rawQuery("select * from bookinfo where category in(?,?,?,?,?,?)", new String[]{cb1Text,cb2Text,cb3Text,cb4Text,cb5Text,cb6Text});
			
			String[] from={"_id","category","introduce","purpose"};
			int[] to={R.id.tv1,R.id.tv2,R.id.tv3,R.id.tv4};
			adapter = new SimpleCursorAdapter(this, R.layout.lv_item, cursor,  from, to);
			
			listView.setAdapter(adapter);
			adapter.notifyDataSetInvalidated();
		}else if(view.getId()==R.id.btn2){
			
		}else if(view.getId()==R.id.btn3){
			
		}else if(view.getId()==R.id.btn4){
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
