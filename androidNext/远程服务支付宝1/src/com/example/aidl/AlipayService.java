package com.example.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class AlipayService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		Log.d("TAG", "远程支付服务onBind");
		return new MyBinde();
	}

	private void methodService(){
		Log.d("TAG", "我是远程支付宝的服务methodService，用来支付");
	}
	
	private class MyBinde extends IService.Stub{

		@Override
		public void callMethodService() {
			methodService();
		}
		
	}
	
	@Override
	public boolean onUnbind(Intent intent) {
		Log.d("TAG", "远程支付服务onUnbind");
		return super.onUnbind(intent);
	}
	
	@Override
	public void onCreate() {
		Log.d("TAG", "远程支付服务onCreate");
		super.onCreate();
	}
	
	@Override
	public void onDestroy() {
		Log.d("TAG", "远程支付服务onDestroy");
		super.onDestroy();
	}
	
}
