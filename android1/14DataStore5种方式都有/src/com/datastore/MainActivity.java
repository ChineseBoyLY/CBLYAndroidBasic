package com.datastore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	private TextView mTextView1, mTextView2, mTextView3, mTextView4;
	private Activity mActivity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mActivity = MainActivity.this;
		
		mTextView1 = (TextView) this.findViewById(R.id.share_preferences);
		mTextView1.setOnClickListener(this);
		mTextView2 = (TextView) this.findViewById(R.id.files);
		mTextView2.setOnClickListener(this);
		mTextView3 = (TextView) this.findViewById(R.id.network);
		mTextView3.setOnClickListener(this);
		mTextView4 = (TextView) this.findViewById(R.id.sqlite);
		mTextView4.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.share_preferences:
			Intent intent = new Intent();
			intent.setClass(mActivity, SharePreferencesActivity.class);
			startActivity(intent);
			break;
		case R.id.files:
			Intent intent1 = new Intent();
			intent1.setClass(mActivity, FilesActivity.class);
			startActivity(intent1);
			break;
		case R.id.network:
			Intent intent2 = new Intent();
			intent2.setClass(mActivity, NetworkActivity.class);
			startActivity(intent2);			
			break;
		case R.id.sqlite:
			Intent intent3 = new Intent();
			intent3.setClass(mActivity, SqliteActivity.class);
			startActivity(intent3);	
			break;
		}
	}

}
