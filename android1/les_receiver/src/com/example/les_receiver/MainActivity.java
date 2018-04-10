package com.example.les_receiver;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.Menu;
import android.view.View;

/**
 * Ӧ�ó�����
 * 		���統������ɺ�ϵͳ�����һ���㲥�����յ������㲥����ʵ�ֿ�����������Ĺ��ܣ�
 * 		������״̬�ı�ʱϵͳ�����һ���㲥�����յ������㲥���ܼ�ʱ��������ʾ�ͱ������ݵȲ�����
 * 		����ص����ı�ʱ��ϵͳ�����һ���㲥�����յ������㲥�����ڵ�����ʱ��֪�û���ʱ������ȣ��ȵȡ�	
 * 
 * �㲥���� 
 * ϵͳ��ĳЩ����Ҫ���� �㲥��Ϣ 
 * Ӧ�ó��� ����
 * �㲥��ΧsendBroadcast ����ϵͳ
 * 
 * 
 * ����ע�᷽ʽ
 * 1����̬ע��---->ע��, ���ǳ�פ�͵ģ�Ҳ����˵�㲥����������������ڡ�
 * 	�����㲥
 * 
 * 2����̬ע��---->ע�⣬���ַ�ʽ��ע���ǳ�פ�͵ģ�Ҳ����˵��Ӧ�ùرպ�����й㲥��Ϣ������MyReceiverҲ�ᱻϵͳ���ö��Զ����С�(���嵥�ļ���������)
 * 	����������
 * 	��װӦ�� ж��Ӧ��
 * 	ͨ��actionֵ���ֲ�ͬ�Ĺ㲥��Ϣ
 * �㲥��Ϣ
 * 1���첽�㲥��Ϣ      sendBroadcast
 * 2��ͬ���㲥��Ϣ      sendOrderedBroadcast
 * 3�������㲥��Ϣ      <uses-permission android:name="android.permission.BROADCAST_STICKY"/>
 * 4��Ȩ�޹㲥
 * ���Ź㲥����绰��Ϣ
 * @author kulv16
 *
 */
public class MainActivity extends Activity {
	MyReceiver receiver;
	public void btnClick(View view){
		if(view.getId()==R.id.btn1){
			Intent intent=new Intent();
			intent.setAction("iloveyou");
			//���͹㲥��Ϣ
			sendBroadcast(intent);
		}else if(view.getId()==R.id.btn2){
			//��̬ע��
			IntentFilter filter=new IntentFilter();
			filter.addAction("iloveyou");
//			filter.addAction(Intent.ACTION_SCREEN_ON);
//			filter.addAction(Intent.ACTION_SCREEN_OFF);
			receiver = new MyReceiver();
			registerReceiver(receiver, filter);
			
			Intent intent=new Intent("iloveyou");
			intent.putExtra("name", "tom");
			//���͹㲥��Ϣ
			sendBroadcast(intent);
			
		}else if(view.getId()==R.id.btn3){
			//ȡ��
			unregisterReceiver(receiver);
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	/*@Override
	protected void onResume() {
		//���������ע��
		super.onResume();
	}*/
	@Override
	protected void onPause() {
		super.onPause();
		//��Ҫ������ȡ��ע��
		unregisterReceiver(receiver);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
