package com.example.style;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * 自定义样式
 * 	1·在values的styles.xml文件里面定义一个自己的样式
 *  2·添加item项   name就是xml里面的textColor  值就是   #669922这样的形式
 *  3`样式是可以继承的
 *  
 * 自定义主题
 * 	1·主题是放在主配置文件里面的
 * 	2·作用域范围比样式要广
 * 	3·Theme
 *  4·与style是同一级别的
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
