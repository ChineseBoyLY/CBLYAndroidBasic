package com.example.les_code;

import android.app.Activity;
import android.os.Bundle;

public class BaseActivity extends Activity {

	MyApplication app;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		app=(MyApplication)getApplication();
		app.activityList.add(this);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		app.activityList.remove(this);
	}
}
