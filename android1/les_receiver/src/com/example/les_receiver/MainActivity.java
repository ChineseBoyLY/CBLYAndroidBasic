package com.example.les_receiver;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.Menu;
import android.view.View;

/**
 * 应用场景：
 * 		例如当开机完成后系统会产生一条广播，接收到这条广播就能实现开机启动服务的功能；
 * 		当网络状态改变时系统会产生一条广播，接收到这条广播就能及时地做出提示和保存数据等操作；
 * 		当电池电量改变时，系统会产生一条广播，接收到这条广播就能在电量低时告知用户及时保存进度，等等。	
 * 
 * 广播接收 
 * 系统有某些很重要事情 广播消息 
 * 应用程序 接收
 * 广播范围sendBroadcast 整个系统
 * 
 * 
 * 两种注册方式
 * 1、动态注册---->注意, 不是常驻型的，也就是说广播会跟随程序的生命周期。
 * 	开机广播
 * 
 * 2、静态注册---->注意，这种方式的注册是常驻型的，也就是说当应用关闭后，如果有广播信息传来，MyReceiver也会被系统调用而自动运行。(在清单文件里面配置)
 * 	锁屏，解锁
 * 	安装应用 卸载应用
 * 	通过action值区分不同的广播消息
 * 广播消息
 * 1、异步广播消息      sendBroadcast
 * 2、同步广播消息      sendOrderedBroadcast
 * 3、持续广播消息      <uses-permission android:name="android.permission.BROADCAST_STICKY"/>
 * 4、权限广播
 * 短信广播，打电话消息
 * @author kulv16
 *
 */
public class MainActivity extends Activity {
	MyReceiver receiver;
	public void btnClick(View view){
		if(view.getId()==R.id.btn1){
			Intent intent=new Intent();
			intent.setAction("iloveyou");
			//发送广播消息
			sendBroadcast(intent);
		}else if(view.getId()==R.id.btn2){
			//动态注册
			IntentFilter filter=new IntentFilter();
			filter.addAction("iloveyou");
//			filter.addAction(Intent.ACTION_SCREEN_ON);
//			filter.addAction(Intent.ACTION_SCREEN_OFF);
			receiver = new MyReceiver();
			registerReceiver(receiver, filter);
			
			Intent intent=new Intent("iloveyou");
			intent.putExtra("name", "tom");
			//发送广播消息
			sendBroadcast(intent);
			
		}else if(view.getId()==R.id.btn3){
			//取消
			unregisterReceiver(receiver);
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	/*@Override
	protected void onResume() {
		//如果在这里注册
		super.onResume();
	}*/
	@Override
	protected void onPause() {
		super.onPause();
		//就要在这里取消注册
		unregisterReceiver(receiver);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
