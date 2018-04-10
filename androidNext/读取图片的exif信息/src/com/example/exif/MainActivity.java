package com.example.exif;

import java.io.IOException;

import android.app.Activity;
import android.media.ExifInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void click(View view){
		try {
			ExifInterface exif = new ExifInterface("/sdcard/Pictures/b.jpg");
			String time = exif.getAttribute(ExifInterface.TAG_DATETIME);
			Log.d("TAG", "time:"+time);
			
		    String model = exif.getAttribute(ExifInterface.TAG_MODEL);
		    Log.d("TAG", "model:"+model);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
