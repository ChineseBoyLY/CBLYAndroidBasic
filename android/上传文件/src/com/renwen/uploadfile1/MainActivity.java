package com.renwen.uploadfile1;

import java.io.File;
import java.io.FileNotFoundException;

import org.apache.http.Header;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class MainActivity extends Activity {

	private EditText et;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
		et=(EditText) findViewById(R.id.et);
	}

	public void click(View view) throws Exception{
		String path = et.getText().toString().trim();
		File file = new File(path);
		if(file.exists()&&file.length()>0){
			AsyncHttpClient client = new AsyncHttpClient();
			String url = "http://10.100.51.162:8080/UpAndDownFile/UpFileServlet1";
			RequestParams params = new RequestParams();
			params.put("profile_picture", file);
			client.post(url, params,new AsyncHttpResponseHandler() {
				
				@Override
				public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
					Toast.makeText(MainActivity.this, "上传成功"+arg2.toString(),  Toast.LENGTH_LONG).show();
				}
				
				@Override
				public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
					Toast.makeText(MainActivity.this, "上传失败", Toast.LENGTH_LONG).show();
				}
			});
		}else{
			Toast.makeText(this, "文件不存在", 0).show();
		}
		
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
