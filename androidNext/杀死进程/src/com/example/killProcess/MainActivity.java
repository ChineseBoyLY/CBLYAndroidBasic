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
//		//��ȡ��ǰ���̵�pid
//		int pid = android.os.Process.myPid();
//		//�������ֻ��������ɱ����
//		android.os.Process.killProcess(pid);
		
		//��������Ի�ȡ������վ����Ϣ
		ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
		//��Ҫ���һ��Ȩ�ޣ�ֻ��ɱ�����ˣ�����ɱ���Լ���
		am.killBackgroundProcesses("com.android.email");
	}
}
