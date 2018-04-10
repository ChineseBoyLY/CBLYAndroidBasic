package com.example.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//可以做一个数据的初始化操作
		Log.d("TAG", "onCreate2");
	}

	@Override
	protected void onStart() {
		super.onStart();
		//UI的更新等操作
		Log.d("TAG", "onStart2");
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		//
		Log.d("TAG", "onResume2");
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		Log.d("TAG", "onPause2");
	}
	
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d("TAG", "onRestart2");
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		Log.d("TAG", "onStop2");
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		//可以做一个数据的持久化操作
		Log.d("TAG", "onDestroy2");
	}

	
}
