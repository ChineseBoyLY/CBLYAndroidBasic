package com.renwen.zihttp;

import java.net.URLEncoder;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void click(View view){
		//1`开启子线程 执行一个http请求在后台执行  在子线程执行
		//2`子线程执行完毕后通知UI界面更行
		AsyncHttpClient client = new AsyncHttpClient();
		String path = "http://192.168.1.100:8080/web/LoginServlet?username="
				+ URLEncoder.encode("liuyi")
				+ "&pwd="
				+ URLEncoder.encode("123");
		client.get(path, new MyHandler(){

			@Override
			public void onFailure(String content) {
				Toast.makeText(MainActivity.this, content, 0).show();
				super.onFailure(content);
			}

			@Override
			public void onSuccess(String content) {
				Toast.makeText(MainActivity.this, content, 0).show();
				super.onSuccess(content);
			}
			
		});
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
