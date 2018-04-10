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
 * ���ط���
 * ��������ʽ
 * 	startService ���ܷ��ؽ��
 * 		������񲻴��ڣ��ȴ���������
 * 		��������Ѿ����ڣ�ֻ������
 * 		stopService stopSelf ���ٷ���
 * �󶨷��� ���Է��ؽ��
 * 		������񲻴��ڣ��ȴ���
 * 		��������Ѿ����ڣ�������
 * �������������̣߳����̣߳�����
 * ����ֵ���壺
 * START_NOT_STICKY 
 * 		��ϵͳ�ѷ���ɱ���Ժ�ʲô��û�У������Ҫ�����������У���intent�ٴ�����
 * START_STICKY
 * 		��ϵͳ�ѷ���ɱ���Ժ�ϵͳ�����´�������intent�ǿյģ�������ܵ��κ���ǰ�Ĳ���
 * START_REDELIVER_INTENT
 * 		��ϵͳ�ѷ���ɱ���Ժ�ϵͳ�����´�������intent�����һ��
 * �ϵ�����
 * 
 * ������߳�
 * 	����û����������ڽ��н����������̨���в������������Ӧ��ʹ���߳�
 * 	����û�û�и����潻������Ҫ��̨���в������������Ӧ��ʹ�÷���
 * 	�û��Ƿ����ڸ�������н���
 * 
 * IntentService
 * 		���ܽ��зǳ���ʱ��Ĳ���
 * Զ�̷���AIDL��android�ӿڶ�������
 * 		��������Ӧ�ó������ 
 * 		qq,���ܣ�ȫ��ɻ���ս���齫������
 * 		���ط����൱�ڷ���ˣ���ҪԶ�̵������൱�ڿͻ���
 * 1���½�.aidl�ļ������밴��java�﷨�淶����ӿ�
 * 2���ڱ��ط�������ʵ�ֽӿ�
 * 3���ڱ��ط���onBinder��������.aidl�ļ�����
 * 4���ڱ��ط��������ļ��������÷������������
 * 5���������ط���gen�����
 * 6����Զ�̰�
 * 
 * service
 * 
 * IntnetService
 * 
 * AIDL
 * 
 * ������߳�����
 * 
 * ��½��֤
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
			// ����������ã�ֻ��ĳЩ��������ܹ����³��з�����߳��쳣����
			
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// ���󶨳ɹ�
			
		}
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
