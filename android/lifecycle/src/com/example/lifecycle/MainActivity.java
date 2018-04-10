package com.example.lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
/**
 * 启动应用：
 * onCreate  activity被创建
 * onStart	   用户可见
 * onResume  获取焦点
 * 
 * 按下回退键：
 * onPause	 失去焦点
 * onStop   不可见
 * onDestroy activity被销毁
 * 
 * 
 * 1·按下Home键/锁屏：onPause->onStop；
 * 恢复/开屏：onRestart->onStart->onResume
 * 
 * 2·当弹出的是一个对话框的时候：onPause
 * 恢复：onResume
 * 
 * 3·横屏/竖屏：onPause->onStop->onDestroy->onCreate->onStart->onResume
 * 应用：防止游戏数据丢失的
 * 		防止措施1，在主配置文件里面配置：android:screenOrientation="landscape" 横屏
 * 									  android:screenOrientation="portrait" 竖屏
 * 									   使其保证总是横屏或者竖屏
 * 		防止措施2：在主配置文件里面配置：android:configChanges="orientation|keyboardHidden|screenSize"
 * 
 * 		防止措施3：	getWindowManager().getDefaultDisplay().getWidth()获取屏幕的分辨率做判断												screenSize不用加
 * @author Administrator
 *
 */
public class MainActivity extends Activity {

	
	public void click(View view){
		if(view.getId()==R.id.btn1){
			Intent intent = new Intent();
			intent.setClass(this, SecondActivity.class);
			startActivity(intent);
		}else if(view.getId()==R.id.btn2){
			Intent intent = new Intent();
			intent.setClass(this, ThirdActivity.class);
			startActivity(intent);
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//可以做一个数据的初始化操作
		Log.d("TAG", "onCreate");
	}

	@Override
	protected void onStart() {
		super.onStart();
		//UI的更新等操作
		Log.d("TAG", "onStart");
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		//
		Log.d("TAG", "onResume");
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		Log.d("TAG", "onPause");
	}
	
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d("TAG", "onRestart");
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		Log.d("TAG", "onStop");
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		//可以做一个数据的持久化操作
		Log.d("TAG", "onDestroy");
	}
}
