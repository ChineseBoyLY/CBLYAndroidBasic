package com.renwen.observer;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.SmsManager;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/*SmsManager manager = SmsManager.getDefault();
		ArrayList<String> texts = manager.divideMessage("15fd4g"
				+ "(吉屋中国短信校验码，请勿泄露)，需要您进行身份验证。【吉屋中国】");
		for (String string : texts) {
			manager.sendTextMessage("77777", null, string, null, null);// 后面俩个为短信的发送状态和短信的接收状态
		}*/

		ContentResolver resolver = getContentResolver();
		Uri uri = Uri.parse("content://sms/");

		resolver.registerContentObserver(uri, true, new MyObserver(
				new Handler()));
	}

	private class MyObserver extends ContentObserver {

		public MyObserver(Handler handler) {
			super(handler);
		}

		// 当内容观察者观察到是数据库的内容变化了调用的方法
		// 观察到消息邮箱里面有一条数据库内容变化的通知
		@Override
		public void onChange(boolean selfChange) {
			super.onChange(selfChange);
			Toast.makeText(MainActivity.this, "数据库内容变化了", 0).show();

			Uri uri = Uri.parse("content://sms/");
			ContentResolver resolver = getContentResolver();
			Cursor cursor = resolver.query(uri, new String[] { "address",
					"date", "type", "body" }, null, null, null);
			cursor.moveToFirst();
			String address = cursor.getString(0);
			String body = cursor.getString(3);
			System.out.println(address + "-----" + body);
			cursor.close();
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
