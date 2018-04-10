package com.example.menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/**
	 * 当菜单的选项被点击的时候调用的方法
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		
		if (id == R.id.menu1) {
			Toast.makeText(this, "menu1", 0).show();
			return true;
		}else if (id == R.id.menu2) {
			Toast.makeText(this, "menu2", 0).show();
			return true;
		}else if (id == R.id.menu3) {
			Toast.makeText(this, "menu3", 0).show();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
