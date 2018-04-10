package com.example.les11_life;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

/**
 * activity�������� 
 * 
 * activity	
 * service
 * broadcastreceiver
 * provider
 * 
 * ����ջ
 * 
 * �������ڻص�����
 * onCreate
 * ��activity��һ�α�������ʱ��Ż�����������
 * onRestart
 * ��activity��ֹͣ��Ȼ�����»ص�activity
 * onStart
 * ��activity�ɼ���ʱ�� �û����Կ���������� ��������û�н��㣩
 * onResume
 * ��activity���Ը��û���������ý��㣩
 * onPause
 * ��activity��ͣ����������  �û��ɼ� ���н���
 * onStop
 * ��activity�û�������  û�н���
 * onDestory
 * ��activity���ٵ�ʱ��ȷ��activity�ᱻ���٣�
 * 1�����û�������˼�  (���ٵ�ǰ����)
 * 		onPause()--onStop()--onDestroy
 * 2�����home��
 * 		onPause()--onStop()
 * 		�ص�����
 * 		onRstart--onStart()--onResume()
 * 3��������һ���½����
 * 		onPause()--onStop()
 * 		�ص�����
 * 		onRestart--onStart--onResume
 * 4��������
 * 		onPuase()--onStop()
 * 		�ظ�����
 * 		onRestart--onStart--onResume
 * 5�������� 
 * 		��ѵ�ǰ�������� ���´������ڶ���
 * 6���������
 * 		onPause
 * 		�ظ�
 * 		onResume
 * 1���κ�ʱ��ӵ�ǰ�����л���ȥ ����onPause  ���浱ǰ״̬
 * 2���κ�ʱ������������л������� onResume		�ظ���ǰ״̬
 * 
 * ���� 
 * 1��ȫ��������
 * onCreate--onDestory
 * 2��������������
 * onStart--onStop
 * 3��ǰ̨����
 * onPause--onResume
 * 
 * ״̬���� 
 * ��activity ���ڶ���ϵͳ���ٵ�
 * 
 * ϵͳ��ɱ���߳� ���ȼ�
 * 
 * 
 * onSaveInstanceState  ��ϵͳ�п��ܱ�ɱ���Ż����
 * @author Administrator
 *
 */
public class MainActivity extends Activity {

	public void btnClick(View view){
		if(view.getId()==R.id.btn){
			//�������� Intent
			Intent intent=new Intent();
			//1����ǰ�������2����Ҫ��ת�Ľ���
			intent.setClass(this,SecondActivity.class);
			startActivity(intent);
			
		}else if(view.getId()==R.id.btn1){
			//�����Ի�����ʽ��activity
			Intent intent=new Intent();
			intent.setClass(this,DialogActivity.class);
			startActivity(intent);
		}
	}
	
	EditText edit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//�ظ� �жϵ�ǰactivity�Ƿ��һ�α�����
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d("TAG","onCreate");
		edit=(EditText)findViewById(R.id.edit);
		/*if(savedInstanceState==null){
			//��һ�α�����
		}else{
			edit.setText(savedInstanceState.getString("name"));
		}*/
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		//����  ��ϵͳ�п���ɱ�������߳�
		Log.d("TAG","onSaveInstanceState");
		/*String temp=edit.getText().toString();
		outState.putString("name", temp);*/
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// �ظ�
		super.onRestoreInstanceState(savedInstanceState);
		
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d("TAG","onStart");
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	
		Log.d("TAG","onResume");
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d("TAG","onPause");
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.d("TAG","onStop");
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d("TAG","onDestory");
	}
	
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.d("TAG","onRestart");
	}
	
}
