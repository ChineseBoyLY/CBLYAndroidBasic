package com.example.game;

import com.example.aidl.IService;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	
	IService iService;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void click(View view){
		Intent intent = new Intent();
		intent.setAction("con.example.aidls");
		if(view.getId()==R.id.btn1){
			//绑定远程服务
			bindService(intent, conn,  BIND_AUTO_CREATE);
		}else if(view.getId()==R.id.btn2){
			//调用远程服务的方法
			try {
				iService.callMethodService();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}
	
	ServiceConnection conn = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			iService=IService.Stub.asInterface(service);
		}
	};
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
