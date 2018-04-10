package com.example.les_service_call;

import com.example.les_service2.IMyService;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	String result="";
	public void btnClick(View view){
		if(view.getId()==R.id.btn1){
			//绑定远程服务
			Intent intent=new Intent();
			intent.setAction("com.example.nativeservice");
			bindService(intent, conn, BIND_AUTO_CREATE);
		}
	}
	
	ServiceConnection conn=new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			try {
				result=IMyService.Stub.asInterface(service).getValue();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Log.d("TAG","绑定结果："+result);
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
