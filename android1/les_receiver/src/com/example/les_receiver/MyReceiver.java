package com.example.les_receiver;


import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

	//电话管理器
	TelephonyManager manager=null;
	
	@Override
	public void onReceive(Context context, Intent intent) {
		//回调函数
		Log.d("TAG","静态"+intent.getAction());
		Log.d("TAG","动态1注册广播"+intent.getAction()+"----"+intent.getStringExtra("name"));
		manager=(TelephonyManager)context.getSystemService(Service.TELEPHONY_SERVICE);
		//TelephonyManager.CALL_STATE_IDLE//接通状态
		//TelephonyManager.CALL_STATE_OFFHOOK//挂断状态
		//TelephonyManager.CALL_STATE_RINGING//响铃状态
	}

}
