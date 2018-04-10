package com.renwen.writecontact;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * 1·同样先加入俩个权限 <uses-permission
 * android:name="android.permission.READ_CONTACTS"/> <uses-permission
 * android:name="android.permission.WRITE_CONTACTS"/>
 * 
 * 2·如下的代码
 * 
 * @author Administrator
 * 
 */

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void btnClick(View view) {
		// 1`向raw_contact表中写入联系人的id
		ContentResolver resolver = getContentResolver();
		// 获取raw_contact表对应的uri
		Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");
		Uri dataUri = Uri.parse("content://com.android.contacts/data");

		// 必须知道最后一条联系人的id是多少
		Cursor cursor = resolver.query(uri, new String[] { "_id" }, null, null, null);
		int newId = 0; 
		if (cursor.moveToLast()) {
			int lastId = cursor.getInt(0);
			newId = lastId + 1;
			Log.d("TAG", newId+"");
			ContentValues values = new ContentValues();
			values.put("contact_id", newId);
			resolver.insert(uri, values);
		}
		// 2`使用添加联系人的id 向data表里面添加数据
		ContentValues phoneValues = new ContentValues();
		phoneValues.put("data1", "15399893649");
		phoneValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
		phoneValues.put("raw_contact_id", newId);
		resolver.insert(dataUri, phoneValues);

		ContentValues emailValues = new ContentValues();
		emailValues.put("data1", "5469103652@qq.com");
		emailValues.put("mimetype", "vnd.android.cursor.item/email_v2");
		emailValues.put("raw_contact_id", newId);
		resolver.insert(dataUri, emailValues);

		ContentValues nameValues = new ContentValues();
		nameValues.put("data1", "tom");
		nameValues.put("mimetype", "vnd.android.cursor.item/name");
		nameValues.put("raw_contact_id", newId);
		resolver.insert(dataUri, nameValues);

		// cursor.close();
		Toast.makeText(this, "添加成功！", 0).show();
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
