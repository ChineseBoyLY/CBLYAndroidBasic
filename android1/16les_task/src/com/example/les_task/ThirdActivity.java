package com.example.les_task;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class ThirdActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d("TAG","第三个窗口销毁");
	}
	
	public void btnClick(View view){
		if(view.getId()==R.id.btn31){
			//启动第3个界面
			Intent intent=new Intent();
			intent.setClass(this,ThirdActivity.class);
			startActivity(intent);
		}else if(view.getId()==R.id.btn32){
			//启动第二个界面
			Intent intent=new Intent();
			intent.setClass(this,SecondActivity.class);
			startActivity(intent);
		}else if(view.getId()==R.id.btn33){
			//启动第1个界面
			Intent intent=new Intent();
			intent.setClass(this,MainActivity.class);
			startActivity(intent);
		}else if(view.getId()==R.id.btn34){
			//启动第4个界面
			Intent intent=new Intent();
			intent.setClass(this,FourActivity.class);
			startActivity(intent);
		}
	}

}
