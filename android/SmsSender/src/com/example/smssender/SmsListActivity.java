package com.example.smssender;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.smssender.domain.ContactInfo;

public class SmsListActivity extends Activity {

	ListView lv;
	List<ContactInfo> list; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sms_list);
		
		lv=(ListView) findViewById(R.id.lv);
		list = ContactInfoUtils.getContacts(this);
		lv.setAdapter(new ContactAdapter());
		
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				ContactInfo info = list.get(position);
				String number = info.getNumber();
				
				Intent data = new Intent();
				data.putExtra("number", number);
				setResult(0, data);
				finish();
			}
		});
	}

	
	private class ContactAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ContactInfo info = list.get(position);
			View view = View.inflate(getApplicationContext(), R.layout.lv_item, null);
			TextView tv_name = (TextView)view.findViewById(R.id.tv1);
			TextView tv_number = (TextView)view.findViewById(R.id.tv2);
			
			tv_name.setText(info.getName());
			tv_number.setText(info.getNumber());
			
			return view;
		}
		
	}
	
}
