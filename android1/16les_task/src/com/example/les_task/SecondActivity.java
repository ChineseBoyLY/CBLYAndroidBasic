package com.example.les_task;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
	}
	
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d("TAG","第二个窗口销毁");
	}
	
	public void btnClick(View view){
		if(view.getId()==R.id.btn21){
			//启动第二个界面
			Intent intent=new Intent();
			intent.setClass(this,SecondActivity.class);
			startActivity(intent);
		}else if(view.getId()==R.id.btn22){
			Intent intent=new Intent();
			intent.setClass(this,MainActivity.class);
			startActivity(intent);
		}else if(view.getId()==R.id.btn23){
			Intent intent=new Intent();
			intent.setClass(this,ThirdActivity.class);
			startActivity(intent);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

}
