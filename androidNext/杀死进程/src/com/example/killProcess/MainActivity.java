package com.example.killProcess;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void click(View view){
//		//获取当前进程的pid
//		int pid = android.os.Process.myPid();
//		//这个方法只能用于自杀操作
//		android.os.Process.killProcess(pid);
		
		//这个还可以获取到任务站的信息
		ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
		//需要添加一个权限（只能杀死别人，不能杀死自己）
		am.killBackgroundProcesses("com.android.email");
	}
}
