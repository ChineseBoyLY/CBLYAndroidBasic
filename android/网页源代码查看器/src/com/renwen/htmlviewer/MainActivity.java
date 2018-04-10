package com.renwen.htmlviewer;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.renwen.utils.StreamTools;

/**
 * 1`添加网络访问权限
 * 			<uses-permission android:name="android.permission.INTERNET"/>
 * 2·如下代码
 * 
 * 3·解决中文乱码问题
 * @author Administrator
 *
 */

public class MainActivity extends Activity {

	protected static final int ERROR = 1;
	protected static final int SHOW_HTML = 2;
	EditText et;
	TextView tv;
	
//	定义一个消息处理器
	private Handler handler=new Handler(){
		@Override
		public void handleMessage(Message msg) {
			switch(msg.what){
			case ERROR:
				Toast.makeText(MainActivity.this, "数据获取失败", Toast.LENGTH_SHORT).show();
				break;
			case SHOW_HTML:
				tv.setText((String) msg.obj);
				break;
			}
		}
	};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		et=(EditText) findViewById(R.id.et);
		tv=(TextView) findViewById(R.id.tv);
	}

	public void btnClick(View view){
		final String path = et.getText().toString().trim();
		
		if(TextUtils.isEmpty(path)){
			Toast.makeText(this, "路径不能为空", Toast.LENGTH_SHORT).show();
		}else{
			new Thread(){
				public void run() {
					try {
						URL url=new URL(path);
						HttpURLConnection conn = (HttpURLConnection)url.openConnection();
						conn.setRequestMethod("GET");
						conn.setConnectTimeout(5000);
						conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36 QIHU 360SE");
						
						int code = conn.getResponseCode();
						if(code == 200){
							InputStream is = conn.getInputStream();
							String result = StreamTools.readInputStream(is);
							//tv.setText(result);
							Message msg=new Message();
							msg.what=SHOW_HTML;
							msg.obj=result;
							handler.sendMessage(msg);
						}else{
							Message msg=new Message();
							msg.what=ERROR;
							handler.sendMessage(msg);
						}
					} catch (Exception e) {
						e.printStackTrace();
						Message msg=new Message();
						msg.what=ERROR;
						handler.sendMessage(msg);
					}
				};
			}.start();
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
