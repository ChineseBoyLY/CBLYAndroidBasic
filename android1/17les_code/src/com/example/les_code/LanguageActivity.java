package com.example.les_code;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class LanguageActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_language);
//		从MainActivity界面拿值
		Intent intent=getIntent();
		Log.d("TAG", intent.getStringExtra("name"));
	}
	
//	@Override
//	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//		if(requestCode==1){
//			if(resultCode==app.result_exit_ok){
//				setResult(app.result_exit_ok);
//				finish();
//			}
//		}
//	}
	
	public void btnClick(View view){
		if(view.getId()==R.id.success){
			//设置成功
			Intent intent=new Intent();
			intent.putExtra("id", "设置语言成功");
			setResult(3,intent);
			finish();
		}else if(view.getId()==R.id.failed){
			//设置失败
			Intent intent=new Intent();
			intent.putExtra("id", "设置语言不成功");
			setResult(3,intent);
			finish();
		}else if(view.getId()==R.id.btnCurrentExit){
			System.exit(0);//只会把当前界面销毁
		}else if(view.getId()==R.id.btnthird){
//			启动第三个界面
			Intent intent=new Intent();
			intent.setClass(this,ThirdActivity.class);
			startActivityForResult(intent, 2);
		}
	}
}
