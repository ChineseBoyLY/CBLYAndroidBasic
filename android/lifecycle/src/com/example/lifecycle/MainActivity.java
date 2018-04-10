package com.example.lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
/**
 * ����Ӧ�ã�
 * onCreate  activity������
 * onStart	   �û��ɼ�
 * onResume  ��ȡ����
 * 
 * ���»��˼���
 * onPause	 ʧȥ����
 * onStop   ���ɼ�
 * onDestroy activity������
 * 
 * 
 * 1������Home��/������onPause->onStop��
 * �ָ�/������onRestart->onStart->onResume
 * 
 * 2������������һ���Ի����ʱ��onPause
 * �ָ���onResume
 * 
 * 3������/������onPause->onStop->onDestroy->onCreate->onStart->onResume
 * Ӧ�ã���ֹ��Ϸ���ݶ�ʧ��
 * 		��ֹ��ʩ1�����������ļ��������ã�android:screenOrientation="landscape" ����
 * 									  android:screenOrientation="portrait" ����
 * 									   ʹ�䱣֤���Ǻ�����������
 * 		��ֹ��ʩ2�����������ļ��������ã�android:configChanges="orientation|keyboardHidden|screenSize"
 * 
 * 		��ֹ��ʩ3��	getWindowManager().getDefaultDisplay().getWidth()��ȡ��Ļ�ķֱ������ж�												screenSize���ü�
 * @author Administrator
 *
 */
public class MainActivity extends Activity {

	
	public void click(View view){
		if(view.getId()==R.id.btn1){
			Intent intent = new Intent();
			intent.setClass(this, SecondActivity.class);
			startActivity(intent);
		}else if(view.getId()==R.id.btn2){
			Intent intent = new Intent();
			intent.setClass(this, ThirdActivity.class);
			startActivity(intent);
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//������һ�����ݵĳ�ʼ������
		Log.d("TAG", "onCreate");
	}

	@Override
	protected void onStart() {
		super.onStart();
		//UI�ĸ��µȲ���
		Log.d("TAG", "onStart");
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		//
		Log.d("TAG", "onResume");
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		Log.d("TAG", "onPause");
	}
	
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d("TAG", "onRestart");
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		Log.d("TAG", "onStop");
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		//������һ�����ݵĳ־û�����
		Log.d("TAG", "onDestroy");
	}
}
