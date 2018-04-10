package com.example.testtaskstack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * 1��standard��ÿ�ζ�����뵽�������ջ��taskstack������ȥ
 * 
 * 2��singleTop�����ջ���Ѿ����ڣ��Ͳ���������룬�������������ջ�������ǻ���������
 * Ӧ�ó��������������ǩ
 * 
 * 3��singleTask������������ջ���涼ֻ����һ����ͬ��activity��
 * 				�ڿ���activity��ʱ����ȥ�������ջ��������ڣ�����ǰ���activityȫ����ջ��ʹ����Ϊջ��
 * Ӧ�ã���Լ��Դ������Դ��Ӧ�ó������ʹ�ã�
 * 
 * 4��singleInstance������һ���µ�����ջ��ֻ��һ��activity��ʵ�����ڣ�
 * 					������activity���������Ͱ�����µ�����ջ�ŵ�ԭ�����Ǹ���ǰ�棻
 * 					������activity�������Ͱ�ԭ�����Ǹ�����ջ�ŵ�����µ�����ջ��ǰ�档
 * 	Ӧ�ã���ͬʱ�кܶ��˴�绰����ʱ��ֻ����һ��������ʾ���棻
 * 		��������
 * 		�е��ʵ�Ŀ���ȡ��
 *
 * @author Administrator
 *
 */

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void click(View view){
		if(view.getId()==R.id.btn1){
			Intent intent = new Intent(this, SecondActivity.class);
			startActivity(intent);
		}else if(view.getId()==R.id.btn2){
			Intent intent = new Intent(this, ThirdActivity.class);
			startActivity(intent);
		}
	}
}
