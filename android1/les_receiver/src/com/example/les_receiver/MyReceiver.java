package com.example.les_receiver;


import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

	//�绰������
	TelephonyManager manager=null;
	
	@Override
	public void onReceive(Context context, Intent intent) {
		//�ص�����
		Log.d("TAG","��̬"+intent.getAction());
		Log.d("TAG","��̬1ע��㲥"+intent.getAction()+"----"+intent.getStringExtra("name"));
		manager=(TelephonyManager)context.getSystemService(Service.TELEPHONY_SERVICE);
		//TelephonyManager.CALL_STATE_IDLE//��ͨ״̬
		//TelephonyManager.CALL_STATE_OFFHOOK//�Ҷ�״̬
		//TelephonyManager.CALL_STATE_RINGING//����״̬
	}

}
