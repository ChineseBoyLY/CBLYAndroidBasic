package com.example.moduel3g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "��⵽���Զ���Ĺ㲥�¼�", Toast.LENGTH_LONG).show();
	}

}