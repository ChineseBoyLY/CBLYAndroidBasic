package com.example.les_code;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * �ĸ�����ģʽ standard Ĭ�ϼ���ģʽ��ͬһ�����ڿ����ڲ�ͬ�Ķ�ջ����ʵ������� singleTop ֻ�д��ڴ���ջ����ʱ�� singleTask
 * ��ͬһ������ջֻ����������ڵ�һ��ʵ�� singleInstance ����ջ����ֻ����һ������ʵ������ֻ����һ������ 
 * requestCode  �жϴ��ĸ�����ر� ������ 
 * resultCode  �ӽ�����û�д��ݲ�����������
 *  	�ж�Intent����ĸ��Ӳ����Ƿ�Ϊ�� �����ӽ����Ƿ������ر� �����
 *  
 * �˳�Ӧ�ó���ʽ 1���Զ��弯�Ϸ�ʽ�˳�activity, �������м��ϵĵط�application 2��resultCode ֻҪ��activity
 * �϶�����һ��intent��������
 * 
 * ��ҵ �̳��Զ���activity ���ڶ�����뵽��������
 * 
 * ��������
 * 
 * ContextWrapper
 * 
 * context
 * 
 * object
 * 
 * @author kulv16
 * 
 */
public class MainActivity extends BaseActivity {
	TextView resultTv;
	/*
	 * �˳�Ӧ�� 
	 * 		����1������ÿ�����涼Ҫ��һ���˳�Ӧ�õİ�ť��дһ��BaseActivity(onCreate()��onDestory()����ʵ��)
	 * 				����applicationȫ�ֶ���,��һ��List<activity>
	 * 				Ȼ����AndroidManifest.xml�����ļ������������ android:name="com.example.les_code.MyApplication" >
	 * 				Ȼ��extends Application
	 */			
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		resultTv = (TextView) findViewById(R.id.resultTv);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 1) {
			if (resultCode == 3) {
				// �����ɹ�
				resultTv.setText(data.getStringExtra("id"));
			} 
//			else if (resultCode == app.result_exit_ok) {
//				finish();
//			}
		else if(resultCode == 4){
				// ����ʧ��
				resultTv.setText(data.getStringExtra("id"));
			}
		} else if (requestCode == 2) {
			resultTv.setText("����wifi");
		}
	}

	public void btnClick(View view) {
		Intent intent = null;
		if (view.getId() == R.id.btn1) {
			// ����
			intent = new Intent();
			// ���ø��Ӳ���
			intent.putExtra("name", "zz");
			intent.setClass(this, LanguageActivity.class);
			startActivityForResult(intent, 1);
		} else if (view.getId() == R.id.btn2) {
			// wifi
			intent=new Intent(); intent.setClass(this,WifiActivity.class);
			//startActivity(intent);
			startActivityForResult(intent, 2);
		}
	}

}
