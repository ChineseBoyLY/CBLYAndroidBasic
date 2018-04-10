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
 * 	ִ�д��� �н���
 * service
 * 	ִ�д��� û�н��� 
 *  ��Ҫ�ں�ִ̨�ж������÷������
 *  �������������ַ�ʽ
 *  1�� startService() ��������
 *  	������������᷵���κν����������
 *  	�����������������Ƿ����٣�����һֱ������
 *  	onCreate-->onStartCommand
 *  ������񲻴���
 *  	��ʾ���񱻴�����ͬʱ����ʼ����
 *  ��������Ѿ�����
 *  	ÿ��startService��ֻ�����з���
 *  onStartCommand
 *  2��bindService().�󶨷���
 *  	˫�򣬿��Է��ؽ���������ߣ�����̲���
 *  	����������ͬʱ��ͬһ�����񣬵�����������������󶨣���������
 *  	�󶨳ɹ�֮�󣬷���ֻ�ᱻ������������
 *  	�Զ�����󶨣�������󶨷����Ժ���������ٰ��Զ����
 *  ���ٷ���
 *  stopService �ֶ����ٷ���
 *  stopSelf() �Զ����ٷ���
 *  ���ý�������
 *  
 *  �ȿ��������ٰ�
 *  	����󶨷���ᱻ����
 *  �Ȱ󶨣��ٿ���
 *  	���հ󶨵Ĺ������ٷ���
 *  
 *  ��½��֤ע����֤
 *  servlet(�������������֤����)-jsp(�ͻ��ˣ���������ҳ��)
 *   servic(������) eactivity���ͻ��ˣ�
 *  ��ҵ ��Should you use a service or a thread?�ĵ�
 *  �������������ز�����BUG
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
			//startService��ʽ��������
			Intent intent=new Intent();
			intent.putExtra("name","����");
			intent.setClass(this,MyService.class);
			startService(intent);
		}else if(view.getId()==R.id.btn2){
			//���ٷ���  �ֶ����ٷ���
			Intent intent=new Intent();
			intent.setClass(this,MyService.class);
			stopService(intent);
		}else if(view.getId()==R.id.btn3){
			//�󶨷��� 1�����ĸ�����2�����Ӷ���3����־�����������ڻ��߲�������ô����
			Intent intent=new Intent();
			intent.setClass(this,MyService.class);
			bindService(intent, conn, BIND_AUTO_CREATE);
		}else if(view.getId()==R.id.btn4){
			//�����
			Intent intent=new Intent();
			intent.setClass(this,MyService.class);
			unbindService(conn);
		}else if(view.getId()==R.id.btn5){
			Intent intent=new Intent();
			intent.setClass(this,Service2Activity.class);
			startActivity(intent);
		}else if(view.getId()==R.id.btnLogin){
			//����û���
			String name=nameEt.getText().toString();
			//��½��ť
			Intent intent=new Intent();
			intent.putExtra("name", name);
			intent.setClass(this,MyService.class);
			bindService(intent, conn, BIND_AUTO_CREATE);
			//startService(intent);
			//����÷�����֤���
			Log.d("TAG","��½�����"+result);
		}
	}
	
	//��Ϊ�����ţ��绰�ߣ�
	ServiceConnection conn=new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// �Ͽ����ӵķ���
			Log.d("TAG","����Ͽ�����");
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// ���ӳɹ�
			result=((MyService.MyBinder)service).getValue();
			Log.d("TAG","��½���conn��"+result);
			Log.d("TAG","���ӳɹ�");
		}
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
