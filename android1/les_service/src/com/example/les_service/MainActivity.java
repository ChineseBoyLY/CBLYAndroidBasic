package com.example.les_service;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

/**activity 
 * 	执行代码 有界面
 * service
 * 	执行代码 没有界面 
 *  需要在后台执行动作都用服务完成
 *  启动服务有两种方式
 *  1、 startService() 启动服务
 *  	单项操作，不会返回任何结果给调用者
 *  	不管启动服务的组件是否被销毁，服务一直都存在
 *  	onCreate-->onStartCommand
 *  如果服务不存在
 *  	表示服务被创建，同时服务开始运行
 *  如果服务已经存在
 *  	每次startService都只会运行服务
 *  onStartCommand
 *  2、bindService().绑定服务
 *  	双向，可以返回结果给调用者，跨进程操作
 *  	多个组件可以同时绑定同一个服务，当所有组件跟服务解除绑定，服务销毁
 *  	绑定成功之后，服务只会被创建不会运行
 *  	自动解除绑定，当组件绑定服务以后，组件被销毁绑定自动解除
 *  销毁服务
 *  stopService 手动销毁服务
 *  stopSelf() 自动销毁服务
 *  设置界面销毁
 *  
 *  先开启服务，再绑定
 *  	解除绑定服务会被销毁
 *  先绑定，再开启
 *  	按照绑定的规则销毁服务
 *  
 *  登陆验证注册验证
 *  servlet(服务器，完成验证过程)-jsp(客户端，发送请求页面)
 *   servic(服务器) eactivity（客户端）
 *  作业 。Should you use a service or a thread?文档
 *  解决服务参数返回不正常BUG
 * @author kulv16
 *
 */
public class MainActivity extends Activity {
	MyService.MyBinder binder;
	String result="FALSE";
	EditText nameEt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		nameEt=(EditText)findViewById(R.id.nameEt);
	}

	public void btnClick(View view){
		if(view.getId()==R.id.btn1){
			//startService方式启动服务
			Intent intent=new Intent();
			intent.putExtra("name","猴子");
			intent.setClass(this,MyService.class);
			startService(intent);
		}else if(view.getId()==R.id.btn2){
			//销毁服务  手动销毁服务
			Intent intent=new Intent();
			intent.setClass(this,MyService.class);
			stopService(intent);
		}else if(view.getId()==R.id.btn3){
			//绑定服务 1、绑定哪个服务2、连接对象3、标志（如果服务存在或者不存在怎么处理）
			Intent intent=new Intent();
			intent.setClass(this,MyService.class);
			bindService(intent, conn, BIND_AUTO_CREATE);
		}else if(view.getId()==R.id.btn4){
			//解除绑定
			Intent intent=new Intent();
			intent.setClass(this,MyService.class);
			unbindService(conn);
		}else if(view.getId()==R.id.btn5){
			Intent intent=new Intent();
			intent.setClass(this,Service2Activity.class);
			startActivity(intent);
		}else if(view.getId()==R.id.btnLogin){
			//获得用户名
			String name=nameEt.getText().toString();
			//登陆按钮
			Intent intent=new Intent();
			intent.putExtra("name", name);
			intent.setClass(this,MyService.class);
			bindService(intent, conn, BIND_AUTO_CREATE);
			//startService(intent);
			//最后获得服务验证结果
			Log.d("TAG","登陆结果："+result);
		}
	}
	
	//作为连接桥（电话线）
	ServiceConnection conn=new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// 断开连接的方法
			Log.d("TAG","服务断开连接");
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// 连接成功
			result=((MyService.MyBinder)service).getValue();
			Log.d("TAG","登陆结果conn："+result);
			Log.d("TAG","连接成功");
		}
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
