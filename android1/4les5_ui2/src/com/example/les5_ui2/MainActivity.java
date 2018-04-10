package com.example.les5_ui2;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Button 
 * EditText
 * TextView 
 * 
 * ImageButton
 * 修改图片适应屏幕大小工具 draw9.bat批处理文件
 * ImageView
 * 1、显示资源里面的图片
 * 2、显示文件里面的图片（SD卡里面的图片）
 * 3、显示网络图片  socket
 * 每个控件 background 属性 颜色 图片
 * ImageView 图片显示方案
 * matrix 用矩阵缩放图片
 * fitXY	放弃图片最原始的比例 强行放大图片完全填充屏幕对图片横向纵向独立缩放，使得图片完全填充ImageView，可能会变形
   fitStart:保持长宽比，图片较长的边与ImageView对应边一致，然后放在左上角
   fitCenter保持缩放比，图片较长的边与ImageView对应边一致，然后放在中间
   fitEnd:保持缩放比，图片较长的边与ImageView对应边一致，然后放在右下角
   center:图片放在中间，不缩放
   centerCrop:保持纵横比缩放，使得图片能完全覆盖ImageView，不能保证图片能够完整显示在屏幕上
   centerInside:保持纵横比缩放，使得ImageView能完全显示图片

	如果主机连接多台设备 敲 adb shell命令 错误 more than one device
	
	在linux下面列出所有文件或者文件夹 命令：ls
	切换目录：cd
	
	drawable 图片类型   在内存里面 不可操作
	Bitmap 	图片类型 可操作的
	BitmapFactory  从文件里面定义 从资源里面定义 从输入流定义
 * @author Administrator
 *
 */
public class MainActivity extends Activity {
	protected static final int CHANGE_UI = 1;
	protected static final int ERROR = 2;

	ImageView img;
	
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
		setContentView(R.layout.imglayout);
		img=(ImageView)findViewById(R.id.img);
		//从文件创建图片
		/*Bitmap bitmap=BitmapFactory.decodeFile("mnt/sdcard/winds.jpg");
		img.setImageBitmap(bitmap);*/
		
		/*
		 //从输入流创建图片
		try {
			InputStream is=new FileInputStream(new File("mnt/sdcard/winds.jpg"));
			Bitmap bitmap=BitmapFactory.decodeStream(is);
			img.setImageBitmap(bitmap);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//从资源里面创建图片
		/*Bitmap bitmap=BitmapFactory.decodeResource(getResources(), R.drawable.net2);
		img.setImageBitmap(bitmap);*/  
	}

	public void btnClick(View view){
		/**
		 * ANR：application not response 应用程序无响应
		 * 产生的原因：主线程需要做的事情有很多，响应点击事情，更新UI等等。。。
		 * 如果在主线程里面阻塞过久的时间，应用程序就会无响应
		 * 
		 * 所有凡是耗时的操作都应该放到子线程里面去执行
		 */
		new Thread(){
			public void run() {
				//显示网络图片
				URL url=null;
				HttpURLConnection urlConnection=null;
				InputStream is=null;
				try {
					url = new URL("http://c.hiphotos.baidu.com/image/w%3D310/sign=f943161d17ce36d3a20485310af13a24/55e736d12f2eb93839a69035d7628535e4dd6f2a.jpg");
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
	
}
