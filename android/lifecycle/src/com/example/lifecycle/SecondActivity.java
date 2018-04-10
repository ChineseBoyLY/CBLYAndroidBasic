package com.example.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//������һ�����ݵĳ�ʼ������
		Log.d("TAG", "onCreate2");
	}

	@Override
	protected void onStart() {
		super.onStart();
		//UI�ĸ��µȲ���
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
		//������һ�����ݵĳ־û�����
		Log.d("TAG", "onDestroy2");
	}

	
}
