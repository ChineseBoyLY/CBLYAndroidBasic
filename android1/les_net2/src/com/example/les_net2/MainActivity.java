package com.example.les_net2;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.widget.ImageView;

/**
 * 网络
 * socket
 * httpClient
 * httpUrlConnection post
 * 
 * 子线程里面不能直接访问主线程元素UI界面元素
 * 
 * hanlder
 * 	 分发消息
 * Message 
 * 	消息对象
 * MessageQueue
 * 	消息队列
 * Looper 
 * 	循环消息（让消息队列开始工作）
 * 	
 * 
 * 每个handler都会跟一个线程绑定，每个handler创建同时也会跟消息队列绑定
 * 
 * 
 * 异步任务 
 * 图片缓存
 * 
 * 
 * 
 * 线程默认是没有消息队列
 * 在哪个线程里面创建的handler这个handler就跟哪个线程绑定
 * 线程默认只有一个消息队列
 * 在android里面所有线程默认是没有消息队列，主线程除外
 * 文件流
 * @author kulv16
 *
 */
public class MainActivity extends Activity {
	ImageView img;
	Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			if(msg.what==1){
				img.setImageResource(R.drawable.ic_launcher);
			}
			
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		img=(ImageView)findViewById(R.id.img);
		
		/*new Thread(){
			public void run() {
				URL url=null;
				HttpURLConnection conn=null;
				try {
					url=new URL("http://19.0.0.130:8080/dataServer/getData");
					conn=(HttpURLConnection)url.openConnection();
					//设置请求方式
					conn.setRequestMethod("POST");
					//设置允许发送参数
					conn.setDoOutput(true);
					//设置连接超时
					conn.setConnectTimeout(6000);
					//拼接请求参数字符串
					String data="name=kakx&pwd=123";
					//获得输出流
					OutputStream os=conn.getOutputStream();
					//输入流写到服务器
					os.write(data.getBytes());
					//刷新
					os.flush();
					os.close();
					InputStreamReader isr=new InputStreamReader(conn.getInputStream());
					isr.close();
					//断开连接
					conn.disconnect();
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();*/
		
		new Thread(){
			public void run() {
				//从消息队列里面那消息出来
				//message 对象  空消息 基本类型
				//给主线程发送消息
				handler.sendEmptyMessage(1);
			}
		}.start();
		
	}

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
