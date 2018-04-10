package com.renwen.writesms;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		new Thread(){
			public void run() {
				ContentResolver resolver = getContentResolver();
				Uri uri = Uri.parse("content://sms/");
				ContentValues values = new ContentValues();
				values.put("address", "1111993679");
				values.put("type", "2");
				values.put("date", System.currentTimeMillis());
				values.put("body", "Äú±»ÖÐ½±2000Íò");
				resolver.insert(uri, values);
				Log.d("TAG", "ANDY");
			};
		}.start();
		
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
