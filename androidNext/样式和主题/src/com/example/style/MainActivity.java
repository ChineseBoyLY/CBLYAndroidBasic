package com.example.style;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * �Զ�����ʽ
 * 	1����values��styles.xml�ļ����涨��һ���Լ�����ʽ
 *  2�����item��   name����xml�����textColor  ֵ����   #669922��������ʽ
 *  3`��ʽ�ǿ��Լ̳е�
 *  
 * �Զ�������
 * 	1�������Ƿ����������ļ������
 * 	2��������Χ����ʽҪ��
 * 	3��Theme
 *  4����style��ͬһ�����
 * @author Administrator
 *
 */

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
