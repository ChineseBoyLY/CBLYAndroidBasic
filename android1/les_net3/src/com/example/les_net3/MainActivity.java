package com.example.les_net3;

import android.os.Bundle;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.Menu;
import android.widget.Gallery;

/**
 * 网络 
 * 图片缓存
 * 文件流
 * 下载管理器
 * DownloadManager
 * PageView
 * ViewFilper
 * xml json
 * ListView 
 * 显示图片
 * @author kulv16
 *
 */
public class MainActivity extends Activity {
	Gallery gly;
	String[] imgurls={
			"http://19.0.0.130:8080/dataServer/s3.jpg",
			"http://19.0.0.130:8080/dataServer/s4.jpg",
			"http://19.0.0.130:8080/dataServer/s5.jpg",
			"http://19.0.0.130:8080/dataServer/s6.jpg",
			"http://19.0.0.130:8080/dataServer/s7.jpg",
			"http://19.0.0.130:8080/dataServer/s8.jpg"
			
	};
	GlyAdapter adapter;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		gly=(Gallery)findViewById(R.id.gly);
		adapter=new GlyAdapter(this, imgurls);
		gly.setAdapter(adapter);
		
		//注册下载完成的广播消息
				IntentFilter filter=new IntentFilter();
				filter.addAction(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
				registerReceiver(reciever, filter);
	}

BroadcastReceiver reciever=new BroadcastReceiver() {
		
		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			Log.d("TAG","下载完成");
			adapter.notifyDataSetChanged();
		}
	};
	
	protected void onPause() {
		super.onPause();
		unregisterReceiver(reciever);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
