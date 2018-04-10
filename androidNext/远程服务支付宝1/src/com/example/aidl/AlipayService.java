package com.example.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class AlipayService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		Log.d("TAG", "Զ��֧������onBind");
		return new MyBinde();
	}

	private void methodService(){
		Log.d("TAG", "����Զ��֧�����ķ���methodService������֧��");
	}
	
	private class MyBinde extends IService.Stub{

		@Override
		public void callMethodService() {
			methodService();
		}
		
	}
	
	@Override
	public boolean onUnbind(Intent intent) {
		Log.d("TAG", "Զ��֧������onUnbind");
		return super.onUnbind(intent);
	}
	
	@Override
	public void onCreate() {
		Log.d("TAG", "Զ��֧������onCreate");
		super.onCreate();
	}
	
	@Override
	public void onDestroy() {
		Log.d("TAG", "Զ��֧������onDestroy");
		super.onDestroy();
	}
	
}
