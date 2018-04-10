package com.example.moduel3g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver3 extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "3检测到了自定义的广播事件", Toast.LENGTH_LONG).show();
	}

}
