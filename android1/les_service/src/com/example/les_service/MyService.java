package com.example.les_service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

	String result="FALSE";
	
	//binder 是一种协议 在不同的组件之间交互数据的协议
	class MyBinder extends Binder{
		
		/*public void startDownload() {  
	        new Thread(new Runnable() {  
	            @Override  
	            public void run() {  
	                // 执行具体的下载任务  
	            }  
	        }).start();  
	    } */ 
		
		public String getValue(){
			return result;
		}
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		// 允许服务是否能被组件绑定 如果不想服务被组件绑定这个方法可视为打酱油
		//如果有返回值 表示可以连接
		//如果没有返回值 表示服务不能被连接
		MyBinder binder=new MyBinder();
		return binder;
	}
	
	@Override
	public void onCreate() {
		// 服务被创建的时候
		Log.d("TAG","服务被创建");
	}
	

	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		/*new Thread(new Runnable() {  
	        @Override  
	        public void run() {  
	            // 开始执行后台任务  
	        }  
	    }).start();*/
		
		// 服务启动
		String name=intent.getStringExtra("name");
		//网络
		//登陆
		//验证
		result="KO";
		Log.d("TAG","服务运行"+name);	
		//stopSelf();
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		// 服务销毁
		Log.d("TAG","服务被销毁");
	}
	
}
