package com.example.les_code;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Application;

public class MyApplication extends Application {
	//Ӧ�ó���һ����װ������һֱ���� ���еط������Է���
	List<Activity> activityList=new ArrayList<Activity>();
	
//	int result_exit_ok=9;
	
	public void exit(){
		for (int i = 0; i < activityList.size(); i++) {
			activityList.get(i).finish();
		}
	}
	
}
