package com.example.les11_life;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

/**
 * activity生命周期 
 * 
 * activity	
 * service
 * broadcastreceiver
 * provider
 * 
 * 回退栈
 * 
 * 生命周期回调函数
 * onCreate
 * 当activity第一次被创建的时候才会调用这个方法
 * onRestart
 * 当activity先停止，然后重新回到activity
 * onStart
 * 当activity可见的时候 用户可以看到这个窗口 摸不到（没有焦点）
 * onResume
 * 当activity可以跟用户交互（获得焦点）
 * onPause
 * 当activity暂停，保存数据  用户可见 持有焦点
 * onStop
 * 当activity用户看不到  没有焦点
 * onDestory
 * 当activity销毁的时候（确定activity会被销毁）
 * 1、当用户点击回退键  (销毁当前界面)
 * 		onPause()--onStop()--onDestroy
 * 2、点击home键
 * 		onPause()--onStop()
 * 		回到界面
 * 		onRstart--onStart()--onResume()
 * 3、启动另一个新界面的
 * 		onPause()--onStop()
 * 		回到界面
 * 		onRestart--onStart--onResume
 * 4、锁屏的
 * 		onPuase()--onStop()
 * 		回复界面
 * 		onRestart--onStart--onResume
 * 5、横竖屏 
 * 		会把当前窗口销毁 重新创建窗口对象
 * 6、半个窗口
 * 		onPause
 * 		回复
 * 		onResume
 * 1、任何时候从当前界面切换出去 经过onPause  保存当前状态
 * 2、任何时候从其他界面切换回来的 onResume		回复当前状态
 * 
 * 周期 
 * 1、全生命周期
 * onCreate--onDestory
 * 2、可视生命周期
 * onStart--onStop
 * 3、前台周期
 * onPause--onResume
 * 
 * 状态保存 
 * 当activity 窗口对象被系统销毁的
 * 
 * 系统会杀掉线程 优先级
 * 
 * 
 * onSaveInstanceState  当系统有可能被杀掉才会调用
 * @author Administrator
 *
 */
public class MainActivity extends Activity {

	public void btnClick(View view){
		if(view.getId()==R.id.btn){
			//启动界面 Intent
			Intent intent=new Intent();
			//1、当前界面对象2、需要跳转的界面
			intent.setClass(this,SecondActivity.class);
			startActivity(intent);
			
		}else if(view.getId()==R.id.btn1){
			//启动对话框形式的activity
			Intent intent=new Intent();
			intent.setClass(this,DialogActivity.class);
			startActivity(intent);
		}
	}
	
	EditText edit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//回复 判断当前activity是否第一次被创建
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d("TAG","onCreate");
		edit=(EditText)findViewById(R.id.edit);
		/*if(savedInstanceState==null){
			//第一次被创建
		}else{
			edit.setText(savedInstanceState.getString("name"));
		}*/
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		//保存  当系统有可能杀掉所在线程
		Log.d("TAG","onSaveInstanceState");
		/*String temp=edit.getText().toString();
		outState.putString("name", temp);*/
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// 回复
		super.onRestoreInstanceState(savedInstanceState);
		
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d("TAG","onStart");
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	
		Log.d("TAG","onResume");
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d("TAG","onPause");
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.d("TAG","onStop");
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d("TAG","onDestory");
	}
	
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.d("TAG","onRestart");
	}
	
}
