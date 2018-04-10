package com.example.les_service2;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyIntentService extends IntentService {
	
	public MyIntentService() {
		// TODO Auto-generated constructor stub
		super("´ò¹·°ô");
	}
	
	@Override
	protected void onHandleIntent(Intent intent) {
		// TODO Auto-generated method stub
		int i=0;
		while(i<=100){
			try {
				Thread.sleep(1000);
				Log.d("TAG","Ë¯ÁË1Ãë");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
	}

}
