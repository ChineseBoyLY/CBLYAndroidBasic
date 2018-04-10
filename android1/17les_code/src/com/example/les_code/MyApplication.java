package com.example.les_code;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Application;

public class MyApplication extends Application {
	//应用程序一经安装作用域一直存在 所有地方都可以访问
	List<Activity> activityList=new ArrayList<Activity>();
	
//	int result_exit_ok=9;
	
	public void exit(){
		for (int i = 0; i < activityList.size(); i++) {
			activityList.get(i).finish();
		}
	}
	
}
