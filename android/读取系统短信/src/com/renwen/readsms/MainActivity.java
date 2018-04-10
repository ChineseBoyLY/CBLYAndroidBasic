package com.renwen.readsms;

import java.util.ArrayList;
import java.util.List;

import com.renwen.readsms.domain.SmsInfo;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

/**
 * 1·在总清单文件里面配置俩个权限
 * 	<uses-permission android:name="android.permission.READ_SMS"/>
    <uses-permission android:name="android.permission.WRITE_SMS"/>
   2·如下代码
 * @author Administrator
 *
 */
public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void btnClick(View view){
		Uri uri = Uri.parse("content://sms/");
		ContentResolver resolver = getContentResolver();
		Cursor cursor = resolver.query(uri, new String[]{"address","date","type","body"}, null, null, null);
		List<SmsInfo> smsinfos=new ArrayList<SmsInfo>();
		while(cursor.moveToNext()){
			String address = cursor.getString(0);
			Long date = cursor.getLong(1);
			int type = cursor.getInt(2);
			String body = cursor.getString(3);
			SmsInfo si=new SmsInfo(date, type, body, address);
			smsinfos.add(si);
			Log.d("TAG", "address"+address+","+"date"+date+","+"type"+type+","+"body"+body+";");
		}
		SmsUtils.backSms(smsinfos, this);
		cursor.close();
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
