package com.example.les_files;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class DataActivity extends Activity {

	SQLiteDatabase sqlite;
	SimpleCursorAdapter adapter;
	ListView resultlv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_data);
		sqlite=openOrCreateDatabase("studb",MODE_PRIVATE,null);
		Cursor cursor=sqlite.rawQuery("select * from classinfo", null);
		//列名
		String[] from={"cname"};
		//对应的列的数据显示到哪个控件里面
		int[] to={R.id.cursortv};
		adapter=new SimpleCursorAdapter(this, R.layout.cursoritem, cursor, from, to);
		resultlv=(ListView)findViewById(R.id.resultlv);
		resultlv.setAdapter(adapter);
	}

	public void btnClick(View view){
		if(view.getId()==R.id.query){
			Cursor cursor=sqlite.query("stuinfo", new String[]{"stuname"}, null, null, null, null, null);
			while(cursor.moveToNext()){
				Log.d("TAG",cursor.getString(0));
			}
		}else if(view.getId()==R.id.add){
			ContentValues cv=new ContentValues();
			cv.put("_id",2);
			cv.put("stuname","好色仙人");
			sqlite.insert("stuinfo", null, cv);
		}else if(view.getId()==R.id.update){
			ContentValues cv=new ContentValues();
			cv.put("stuname", "qq");

			sqlite.update("stuinfo", cv, "_id=? or _id=?", new String[]{"1","2"});
		}else if(view.getId()==R.id.del){
			sqlite.delete("stuinfo","_id=?", new String[]{"1"});
		}
	}

}
