package com.example.smssender;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import com.example.smssender.domain.ContactInfo;

public class ContactInfoUtils {

	public static List<ContactInfo> getContacts(Context ctx) {
		List<ContactInfo> list = new ArrayList<ContactInfo>();
		// 1·查询raw_contact表获取联系人的id
		ContentResolver resolver = ctx.getContentResolver();
		// 获取raw_contact表对应的uri
		Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");
		Uri dataUri = Uri.parse("content://com.android.contacts/data");
		Cursor cursor = resolver.query(uri, null, null, null, null);
		while (cursor.moveToNext()) {
			String id = cursor.getString(cursor.getColumnIndex("contact_id"));
			if (id != null) {
				Log.d("TAG", id);
				Cursor dataCursor = resolver.query(dataUri, null,
						"raw_contact_id=?", new String[] { id }, null);
				ContactInfo contactInfo = new ContactInfo();
				while (dataCursor.moveToNext()) {
					String data1 = dataCursor.getString(dataCursor
							.getColumnIndex("data1"));
					String mimetype = dataCursor.getString(dataCursor
							.getColumnIndex("mimetype"));
					Log.d("TAG", "联系人信息：" + data1 + mimetype);
					if ("vnd.android.cursor.item/name".equals(mimetype)) {
						contactInfo.setName(data1);
					} else if ("vnd.android.cursor.item/phone_v2"
							.equals(mimetype)) {
						contactInfo.setNumber(data1);
					}
				}
				list.add(contactInfo);
				dataCursor.close();
			}
		}
		cursor.close();
		return list;
	}
}
