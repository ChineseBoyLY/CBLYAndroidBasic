package com.example.testservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

	
	@Override
	public IBinder onBind(Intent intent) {
		Log.d("TAG", "onBind");
		return new MyBinder();
	}
	
	/**
	 * 相当于代理人
	 */
	public class MyBinder extends Binder{
		
		public void callSing(String sing){
			change(sing);
		}
	} 
	
	public void change(String sing){
		Toast.makeText(getApplicationContext(), "changge"+sing, 0).show();
	}

	@Override
	public void onCreate() {
		Log.d("TAG", "onCreate");
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		Log.d("TAG", "onDestroy");
		super.onDestroy();
	}

	@Override
	public void onRebind(Intent intent) {
		Log.d("TAG", "onRebind");
		super.onRebind(intent);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d("TAG", "onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public boolean onUnbind(Intent intent) {
		Log.d("TAG", "onUnbind");
		return super.onUnbind(intent);
	}
}
