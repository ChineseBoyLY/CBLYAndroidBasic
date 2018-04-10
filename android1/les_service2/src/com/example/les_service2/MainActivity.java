package com.example.les_service2;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;

/**
 * 本地服务
 * 启动服务方式
 * 	startService 不能返回结果
 * 		如果服务不存在，先创建在运行
 * 		如果服务已经存在，只会运行
 * 		stopService stopSelf 销毁服务
 * 绑定服务 可以返回结果
 * 		如果服务不存在，先创建
 * 		如果服务已经存在，。。。
 * 服务运行在主线程，主线程：界面
 * 返回值意义：
 * START_NOT_STICKY 
 * 		当系统把服务杀掉以后，什么都没有，如果需要服务重新运行，用intent再次启动
 * START_STICKY
 * 		当系统把服务杀掉以后，系统会重新创建服务，intent是空的，不会接受到任何以前的参数
 * START_REDELIVER_INTENT
 * 		当系统把服务杀掉以后，系统会重新创建服务，intent是最后一次
 * 断点续传
 * 
 * 服务和线程
 * 	如果用户跟界面正在进行交互，如果后台运行操作，这个操作应该使用线程
 * 	如果用户没有跟界面交互，需要后台运行操作，这个操作应该使用服务
 * 	用户是否正在跟界面进行交互
 * 
 * IntentService
 * 		不能进行非常耗时间的操作
 * 远程服务（AIDL）android接口定义语言
 * 		调用其他应用程序服务 
 * 		qq,酷跑，全民飞机大战，麻将。。。
 * 		本地服务相当于服务端，需要远程调用者相当于客户端
 * 1、新建.aidl文件，必须按照java语法规范定义接口
 * 2、在本地服务里面实现接口
 * 3、在本地服务onBinder方法返回.aidl文件类型
 * 4、在本地服务配置文件里面配置服务组件过滤器
 * 5、拷贝本地服务gen里面包
 * 6、在远程绑定
 * 
 * service
 * 
 * IntnetService
 * 
 * AIDL
 * 
 * 服务和线程区别
 * 
 * 登陆验证
 * 
 * @author kulv16
 *
 */
public class MainActivity extends Activity {

	public void btnClick(View view){
		if(view.getId()==R.id.btn1){
			Intent intent=new Intent();
			intent.setClass(this,MyService.class);
			startService(intent);
		}else if(view.getId()==R.id.btn2){
			Intent intent=new Intent();
			intent.setClass(this,MyIntentService.class);
			startService(intent);
		}
	}
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	ServiceConnection conn=new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// 正常不会调用，只有某些极端情况能够导致持有服务的线程异常崩溃
			
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// 当绑定成功
			
		}
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
