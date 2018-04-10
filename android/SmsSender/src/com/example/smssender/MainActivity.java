package com.example.smssender;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText et1;
	EditText et2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et1 = (EditText) findViewById(R.id.et1);
		et2 = (EditText) findViewById(R.id.et2);
	}

	public void click(View view){
		if(view.getId()==R.id.btn1){
			//选择联系人
			Intent intent = new Intent(this,SmsListActivity.class);
			//startActivity(intent);
			startActivityForResult(intent, 1);
		}else if(view.getId()==R.id.btn2){
			//选择第二个联系人
			Intent intent = new Intent(this,SmsListActivity.class);
			startActivityForResult(intent, 2);
		}else if(view.getId()==R.id.btn3){
			//发送短信
			
		}
	}
	//当新开启的activity关闭的时候调用的方法
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		if(data!=null){
			String numbert = data.getStringExtra("number");
			if(requestCode==1){
				et1.setText(numbert);
			}else if(requestCode==2){
				et2.setText(numbert);
			}
			
		}
	}
}
