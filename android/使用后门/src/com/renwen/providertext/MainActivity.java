package com.renwen.providertext;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void btnClick(View view){
		//得到手机的中间人
		ContentResolver resolver = getContentResolver();
		
		if(view.getId()==R.id.btnQuery){
			Uri uri = Uri.parse("content://com.renwen.contextprovider.personprovider/query");
			Cursor cursor = resolver.query(uri, null, null, null, null);
			while(cursor.moveToNext()){
				String id = cursor.getString(cursor.getColumnIndex("id"));
				String name = cursor.getString(cursor.getColumnIndex("name"));
				Log.d("TAG", id+name);
			}
		}else if(view.getId()==R.id.btnInsert){
			Uri uri = Uri.parse("content://com.renwen.contextprovider.personprovider/insert");
			ContentValues values = new ContentValues();
			values.put("id", 1234);
			values.put("name", "jack");
			resolver.insert(uri, values);
		}else if(view.getId()==R.id.btnDelete){
			Uri uri = Uri.parse("content://com.renwen.contextprovider.personprovider/delete");
			String where="id=?";
			String[] selectionArgs = new String[]{"1234"};
			resolver.delete(uri, where, selectionArgs);
		}else if(view.getId()==R.id.btnUpdate){
			Uri uri = Uri.parse("content://com.renwen.contextprovider.personprovider/update");
			ContentValues values = new ContentValues();
			values.put("name", "jack");
			resolver.update(uri, values, "id=?", new String[]{"1"});
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
