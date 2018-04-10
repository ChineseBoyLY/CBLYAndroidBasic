package com.example.testservice;

import com.example.testservice.MyService.MyBinder;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	MyService.MyBinder myBinder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view){
    	if(view.getId()==R.id.btn1){
    		//开启服务
    		//开启服务，就算activity退出了，服务还是会长期在后台运行
    		Intent intent = new Intent(this,MyService.class);
    		startService(intent);
    	}else if(view.getId()==R.id.btn2){
    		//停止 服务
    		Intent intent = new Intent(this,MyService.class);
    		stopService(intent);
    	}else if(view.getId()==R.id.btn3){
    		//调用服务里面的方法
    		myBinder.callSing("月亮之上");
    	}else if(view.getId()==R.id.btn4){
    		//绑定
    		//这种方式，activity一旦销毁，服务也跟着销毁了
    		Intent intent = new Intent(this,MyService.class);
    		//中间参数为代理人  中间人对象  用来跟服务建立联系   不能为空
    		bindService(intent, conn, BIND_AUTO_CREATE);
    	}else if(view.getId()==R.id.btn5){
    		//解绑服务
    		//不能被多次解绑，会报错，
    		//在没有解绑的情况下，退出了应用程序会报错；一般在onDestory（）方法里面解绑
    		unbindService(conn);
    	}
    }
    
    protected void onDestroy() {
    	//这里可以防止应用程序退出的时候报错
    	try {
			unbindService(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
    };
    
    ServiceConnection conn = new ServiceConnection(){
    	//服务被成功绑定的时候调用的方法
		@Override
		public void onServiceConnected(ComponentName name,
				IBinder service) {
			Log.d("TAG", "春哥把代理人返回回来了");
			myBinder = (MyBinder) service;
		}

		//服务被解除绑定的的时候调用的方法（异常退出，或者kill掉的，）
		@Override
		public void onServiceDisconnected(ComponentName name) {
			Log.d("TAG", "onServiceDisconnected");
		}
	};
	
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
