package com.example.callmethod;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service{

	MyReceiver mr;
	
	@Override
	public IBinder onBind(Intent intent) {
		
		return null;
	}
	
	@Override
	public void onCreate() {
		mr = new MyReceiver();
		IntentFilter filter = new IntentFilter();
		filter.addAction("com.example.callmethod");
		registerReceiver(mr, filter);
		super.onCreate();
	}
	
	public void methodInServiced(){
		Toast.makeText(getApplicationContext(), "我是服务的方法MyService", 0).show();
	}
	
	class MyReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			Log.d("TAG", "我是service内部的广播接受者");
			methodInServiced();
		}
	}
	
}
