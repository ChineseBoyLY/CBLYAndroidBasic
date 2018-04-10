package com.example.datademo;

import java.util.List;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends Activity {

	private ListView listView;
	SQLiteDatabase sqlite;
	//private CursorAdapter adapter;
	private MyCursorAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = (ListView) this.findViewById(R.id.lv);
		
		MyOpenHelper helper=new MyOpenHelper(MainActivity.this,"bookdb",null,2);
		sqlite= helper.getWritableDatabase();
//		String sql="insert into bookinfo values(5,'tom')";
//		sqlite.execSQL(sql);
		Cursor cursor=sqlite.rawQuery("select * from bookinfo", null);
		adapter=new MyCursorAdapter(this, cursor);
		
		//adapter=new SimpleCursorAdapter(this, R.layout.activity_main, cursor,  new String[]{"_id","book_name"}, new int[]{R.id.tv1,R.id.tv2});
		listView.setAdapter(adapter);  
		
		adapter.notifyDataSetInvalidated();
//		cursor.close();
//		sqlite.close();  
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
