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
				+ "(�����й�����У���룬����й¶)����Ҫ�����������֤���������й���");
		for (String string : texts) {
			manager.sendTextMessage("77777", null, string, null, null);// ��������Ϊ���ŵķ���״̬�Ͷ��ŵĽ���״̬
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

		// �����ݹ۲��߹۲쵽�����ݿ�����ݱ仯�˵��õķ���
		// �۲쵽��Ϣ����������һ�����ݿ����ݱ仯��֪ͨ
		@Override
		public void onChange(boolean selfChange) {
			super.onChange(selfChange);
			Toast.makeText(MainActivity.this, "���ݿ����ݱ仯��", 0).show();

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
