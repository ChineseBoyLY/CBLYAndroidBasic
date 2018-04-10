package com.example.autotextview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

/**
 * ����һ������MultiAutoCompleteTextView�����������������Ĺ���
 * 
 * ��������һ���ַ������ڸ��ַ����ĺ�������һ�����ţ��ڶ���ǰ�������������ո��ٴ������ʱ�򣬻�������ʾ
 * 
 * @author Administrator
 *
 */

public class MainActivity extends Activity {

	AutoCompleteTextView actv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		actv=(AutoCompleteTextView) findViewById(R.id.actv);
		
		String[] names = new String[]{"����","����","��˹","��˹","����"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,names);
	
		actv.setAdapter(adapter);
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
