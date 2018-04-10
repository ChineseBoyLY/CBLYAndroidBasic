package com.example.les_service2;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class MyService extends Service {

	NotificationManager manager;
	
	class MyBinder extends IMyService.Stub{
		@Override
		public String getValue() throws RemoteException {
			// TODO Auto-generated method stub
			return "À¯±ÊÐ¡ÐÂ";
		}
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		MyBinder binder=new MyBinder();
		return binder;
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		manager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		/*int i=0;
		while(i<=100){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}*/
		Notification.Builder builder=new Notification.Builder(getApplicationContext());
		builder.setSmallIcon(R.drawable.ic_launcher);
		builder.setContentText("asdf");
		Intent intent1=new Intent();
		intent.setClass(getApplicationContext(), MainActivity.class);
		
		PendingIntent intent2=PendingIntent.getActivity(getApplicationContext(), 1, intent1,0);
		builder.setContentIntent(intent2);
		manager.notify(1,builder.build());
		
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

}
