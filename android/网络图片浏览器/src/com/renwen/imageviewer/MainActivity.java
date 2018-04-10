package com.renwen.imageviewer;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * 1`加入一个用户访问网络的权限
 * 		<uses-permission android:name="android.permission.INTERNET"/>
 * 
 * 2·子线程负责加载图片，将其结果(更新UI的操作)交给父进程来处理（代码如下）--》这样防止并发（多个线程都去修改UI）
 * 
 * @author Administrator
 *
 */

public class MainActivity extends Activity {

	protected static final int CHANGE_UI = 1;
	protected static final int ERROR = 2;

	ImageView img;
	EditText et;
	
	//主线程创建消息处理器
		private Handler handler=new Handler(){
			public void handleMessage(android.os.Message msg) {
				if(msg.what==CHANGE_UI){
					Bitmap bitmap=(Bitmap)msg.obj;
					img.setImageBitmap(bitmap);
				}else if(msg.what==ERROR){
					Toast.makeText(MainActivity.this, "显示图片失败", Toast.LENGTH_SHORT).show();
				}
			};
		};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		img=(ImageView)findViewById(R.id.iv);
		et=(EditText) findViewById(R.id.et);
	}

	public void btnClick(View view){
		/**
		 * ANR：application not response 应用程序无响应
		 * 产生的原因：主线程需要做的事情有很多，响应点击事情，更新UI等等。。。
		 * 如果在主线程里面阻塞过久的时间，应用程序就会无响应
		 * 
		 * 所有凡是耗时的操作都应该放到子线程里面去执行
		 */
		final String path = et.getText().toString().trim();
		new Thread(){
			public void run() {
				//显示网络图片
				URL url=null;
				HttpURLConnection urlConnection=null;
				InputStream is=null;
				try {
//					url = new URL("http://c.hiphotos.baidu.com/image/w%3D310/sign=f943161d17ce36d3a20485310af13a24/55e736d12f2eb93839a69035d7628535e4dd6f2a.jpg");
					url = new URL(path);
					urlConnection = (HttpURLConnection)url.openConnection();
					urlConnection.setRequestMethod("GET");
					urlConnection.setConnectTimeout(5000);
					urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36");
//					Log.e("TAG", urlConnection+"====");
					int code = urlConnection.getResponseCode();
					if(code==200){
						is = urlConnection.getInputStream(); 
						Bitmap bitmap=BitmapFactory.decodeStream(is);
						//img.setImageBitmap(bitmap);
						//告诉主线程一个消息，帮我更新界面，内容为bitmap
						Message msg=new Message();
						msg.what=CHANGE_UI;
						msg.obj=bitmap;
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

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
