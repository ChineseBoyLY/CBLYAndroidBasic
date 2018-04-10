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
		Log.d("TAG","��������������");
	}
	
	public void btnClick(View view){
		if(view.getId()==R.id.btn31){
			//������3������
			Intent intent=new Intent();
			intent.setClass(this,ThirdActivity.class);
			startActivity(intent);
		}else if(view.getId()==R.id.btn32){
			//�����ڶ�������
			Intent intent=new Intent();
			intent.setClass(this,SecondActivity.class);
			startActivity(intent);
		}else if(view.getId()==R.id.btn33){
			//������1������
			Intent intent=new Intent();
			intent.setClass(this,MainActivity.class);
			startActivity(intent);
		}else if(view.getId()==R.id.btn34){
			//������4������
			Intent intent=new Intent();
			intent.setClass(this,FourActivity.class);
			startActivity(intent);
		}
	}

}
