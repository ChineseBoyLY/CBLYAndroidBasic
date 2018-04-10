package com.example.les_task;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

/**
 * orm  oa 
 * �������ջ  �����Ѿ��򿪹�����Щactivity��������棬���˵�ָ���ĸ����� ����ָ�����ĸ����棩
 * ���� ���Ѿ��򿪵�activity�ļ��� 
 * ��ջ�������Ѿ��򿪹���activity����������һ����ջ���棬���մ򿪵�˳�򱣴�ļ���
 * ÿ��androidӦ�ó������Լ�������Ͷ�ջ
 * �����ĳ��activity�Ӷ�ջ���浯���� ���activity�Ѿ�������
 * ����ģʽ
 * standard ��׼����ģʽ ͬһ������ջ����ͬһ�����ڵĶ��ʵ��
 * ͬһ�����ڵĶ��ʵ��Ҳ���Դ����ڲ�ͬ������ջ����
 * singleTop �����ڴ���ջ����ʱ�򣬲�����ʵ��������
 * ������ڲ�����ջ��������ģʽ��standardһ��
 * singleTask ͬһ�����ڵ�ʵ��ֻ�ܴ�����һ������ջ����
 * singleInstance ��������ջ������ֻ����һ������
 * ��ҵ��ʹ��Intent��ǩʵ��
 * @author kulv16
 *
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void btnClick(View view){
		if(view.getId()==R.id.btn1){
			Intent intent=new Intent();
			//1����ǰ�������2����Ҫ��ת�������
			intent.setClass(this,SecondActivity.class);
			//��������
			startActivity(intent);
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
