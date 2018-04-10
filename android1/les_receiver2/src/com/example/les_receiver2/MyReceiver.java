package com.example.les_receiver2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d("TAG","动态2注册广播"+intent.getAction()+"----"+intent.getStringExtra("name"));
		Log.d("TAG", " 2接收到了"+intent.getAction());
	}
}
