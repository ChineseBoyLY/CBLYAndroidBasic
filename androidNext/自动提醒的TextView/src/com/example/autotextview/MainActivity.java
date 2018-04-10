package com.example.autotextview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

/**
 * 还有一个就是MultiAutoCompleteTextView，可以完成连续输入的功能
 * 
 * 当输入完一个字符串后在该字符串的后面输入一个逗号，在逗号前后可以有任意个空格，再次输入的时候，还会有提示
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
		
		String[] names = new String[]{"张三","李四","李斯","李斯","赵六"};
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
