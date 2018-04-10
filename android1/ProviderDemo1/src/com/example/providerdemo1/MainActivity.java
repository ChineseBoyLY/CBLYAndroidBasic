package com.example.providerdemo1;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void click(View view){
		Cursor cursor = getContentResolver().query(Uri.parse("content://downloads/my_downloads"), null, null, null, null);
		while(cursor.moveToNext()){
//			String title = cursor.getString(cursor.getColumnIndex("title"));
			String title = cursor.getString(0);
			Log.d("TAG", "title:"+title);
		}
	}
}
