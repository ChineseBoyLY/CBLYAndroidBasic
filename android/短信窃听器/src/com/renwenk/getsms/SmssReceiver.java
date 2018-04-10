package com.renwenk.getsms;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmssReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		Log.d("TAG", "�����յ��ˡ�����");
		//pdus���������ֻ��4.0ǰ��İ汾������Ч��
		Object[] pdus = (Object[]) intent.getExtras().get("pdus");
		for (Object obj : pdus) {
			SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) obj);
			// ��ȡ���ŵ�����
			String body = smsMessage.getMessageBody();
			// ��ȡ���ŵķ�����
			String sender = smsMessage.getOriginatingAddress();
			long date=smsMessage.getTimestampMillis();
	    	Date timeDate=new Date(date);
	    	SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	String time=simpleDateFormat.format(timeDate);
			Log.d("TAG", "�����յ��ˡ�����" + "sender:" + sender + ";body="
					+ body+ ";time="
					+ time);

			// ������Ϳ���ͨ��get����post�������ύ��������

			if ("5558".equals(sender)) {
				// ���ض���
				abortBroadcast();
				//����֮������޸Ķ������ط�
				//��Ҫ���嵥�ļ��������÷��Ͷ��ŵ�Ȩ��
				SmsManager magage = SmsManager.getDefault();
				magage.sendTextMessage(sender, null, "���Ѿ�ϲ���ȶ���", null, null);
			}
		}
	}
}
