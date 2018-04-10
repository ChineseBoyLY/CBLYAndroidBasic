package com.example.les_receiver2;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends Activity {
	MyReceiver receiver;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		receiver = new MyReceiver();  
//        
//		IntentFilter filter = new IntentFilter();  
//		filter.addAction("iloveyou");  
//		registerReceiver(receiver, filter);  
	}

	@Override
	protected void onDestroy() {
		unregisterReceiver(receiver);
		super.onDestroy();
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
