package com.renwen.readcontact;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

/**
 * 1`�������������ļ������������Ȩ�� <uses-permission
 * android:name="android.permission.READ_CONTACTS"/> <uses-permission
 * android:name="android.permission.WRITE_CONTACTS"/>
 * 
 * 2����д���´���
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
		// 1����ѯraw_contact���ȡ��ϵ�˵�id
		ContentResolver resolver = getContentResolver();
		// ��ȡraw_contact���Ӧ��uri
		Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");
		Uri dataUri = Uri.parse("content://com.android.contacts/data");
		Cursor cursor = resolver.query(uri, null, null, null, null);
		while (cursor.moveToNext()) {
			String id = cursor.getString(cursor.getColumnIndex("contact_id"));
			if (id != null) {
				Log.d("TAG", id);
				Cursor dataCursor = resolver.query(dataUri, null,
						"raw_contact_id=?", new String[] { id }, null);
				while (dataCursor.moveToNext()) {
					String data1 = dataCursor.getString(dataCursor
							.getColumnIndex("data1"));
					String mimetype = dataCursor.getString(dataCursor
							.getColumnIndex("mimetype"));
					Log.d("TAG", "��ϵ����Ϣ��" + data1 + mimetype);
				}
				dataCursor.close();
			}
		}
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
