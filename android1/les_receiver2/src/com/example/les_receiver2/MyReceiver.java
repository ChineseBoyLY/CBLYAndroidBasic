package com.example.les_receiver2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d("TAG","��̬2ע��㲥"+intent.getAction()+"----"+intent.getStringExtra("name"));
		Log.d("TAG", " 2���յ���"+intent.getAction());
	}
}
