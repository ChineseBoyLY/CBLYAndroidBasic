package com.example.alarm;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void click(View view){
		Intent intent = new Intent();
		intent.setAction("com.renwen.iloveyou");
		//���Զ���Ĺ㲥���ͳ�ȥ
		//sendBroadcast(intent);
		
		//����㲥���ص㣺�����ȼ��Ĺ㲥�����߿�����ֹ���㲥�¼�
		//sendOrderedBroadcast(intent, null);
		
		//��Ȼ����ֹ�˵���ָ����new FinalReceiver()��Զ�����ǿ��Խ��յ���
		//��֤��һ�������߿��Խ��յ�����ֹ���������ֹ����绰�ĵط�ϵͳ���Ѿ�Ӧ���������
		sendOrderedBroadcast(intent, null, new FinalReceiver(), null, 0, null, null);
	}
	
}
