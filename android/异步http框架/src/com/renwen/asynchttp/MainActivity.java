package com.renwen.asynchttp;

import java.net.URLEncoder;

import org.apache.http.Header;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * 1`导入一个jar包
 * 2·添加网络访问权限
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
		AsyncHttpClient client = new AsyncHttpClient();
		String path = "http://192.168.1.100:8080/web/LoginServlet?username="
				+ URLEncoder.encode("liuyi")
				+ "&pwd="
				+ URLEncoder.encode("123");
		client.get(path, new AsyncHttpResponseHandler() {
			
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
				Toast.makeText(MainActivity.this, "请求成功", Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
				Toast.makeText(MainActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
				
			}
		});
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
