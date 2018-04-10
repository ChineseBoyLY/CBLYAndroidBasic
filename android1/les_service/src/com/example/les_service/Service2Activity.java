package com.example.les_service;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;

public class Service2Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service2);
	}

	public void btnClick(View view){
		if(view.getId()==R.id.btnBind2){
			Intent intent=new Intent();
			intent.setClass(this,MyService.class);
			bindService(intent, conn,BIND_AUTO_CREATE);
		}else if(view.getId()==R.id.btnBind3){
			unbindService(conn);
		}
		
	}
	ServiceConnection conn=new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			
		}
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.service2, menu);
		return true;
	}

}
