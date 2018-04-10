package com.renwen.programedemo2;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity {

	ListView listView;
	SQLiteDatabase sqlite;
	CursorAdapter adapter;

	Spinner guoming;
	Spinner falv;
	
	ArrayAdapter<String> adapterCountry;
	ArrayAdapter<String> adapterFalv;
	List<String> countryList;
	List<String> falvList;
	static int countryListPosition=1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = (ListView) this.findViewById(R.id.lv);
		
		guoming=(Spinner) findViewById(R.id.guoming);
		falv=(Spinner) findViewById(R.id.falv);
		
		MyOpenHelper helper = new MyOpenHelper(this, "book.db",null, 1);
		sqlite = helper.getWritableDatabase();
		
		countryList=new ArrayList<String>();
		falvList=new ArrayList<String>();
		
		Cursor cursor = sqlite.rawQuery("select distinct(name) from country",null);
		while(cursor.moveToNext()){
			countryList.add(cursor.getString(cursor.getColumnIndex("name")));
		}
		adapterCountry=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, countryList);
		guoming.setAdapter(adapterCountry);
		
		adapterFalv=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item, falvList);
		falv.setAdapter(adapterFalv);
		
		guoming.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
				countryListPosition=position;
				falvList.clear();
				MyOpenHelper helper = new MyOpenHelper(MainActivity.this, "book.db",null, 1);
				sqlite = helper.getWritableDatabase();
				String name=countryList.get(position);
				Cursor cursor = sqlite.rawQuery("select distinct(falv) from country where name=?",new String[]{name});
				while(cursor.moveToNext()){
					falvList.add(cursor.getString(cursor.getColumnIndex("falv")));
				}
				adapterFalv.notifyDataSetChanged();
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				
			}
		});
		
		falv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				Log.d("TAG", position+"Position");
				Log.d("TAG", countryListPosition+"countryListPosition");
				MyOpenHelper helper = new MyOpenHelper(MainActivity.this,"book.db",null, 1);
				sqlite = helper.getWritableDatabase();
				
				Cursor cursor =sqlite.rawQuery("select * from country where name=? and falv=?",new String[]{countryList.get(countryListPosition),falvList.get(position)});
				  
				String[] from={"_id","falv","tiaowen"}; 
				int[] to={R.id.tv1,R.id.tv2,R.id.tv3}; 
				adapter = new SimpleCursorAdapter(MainActivity.this, R.layout.lv_item, cursor, from, to);
				listView.setAdapter(adapter); 
				
				adapter.notifyDataSetInvalidated();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				
			}
		});
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
