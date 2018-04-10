package com.example.les_net3;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;

public class DownloadActivity extends Activity {
	String imgurl="http://19.0.0.130:8080/dataServer/pirate.mp4";
	DownloadManager manager;
	long id;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_download);
		//通知 电话管理 下载管理
		manager=(DownloadManager)getSystemService(DOWNLOAD_SERVICE);
		//生成下载请求
		DownloadManager.Request request=new DownloadManager.Request(Uri.parse(imgurl));
		//设置下载保存路径 1、路径  mnt/sdcard/pictures 2、文件名
		request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "pirate.mp4");
		//设置下载标题
		request.setTitle("pirate.mp4");
		//下载请求添加系统下载队列
		id=manager.enqueue(request);
		
		//注册下载完成的广播消息
		IntentFilter filter=new IntentFilter();
		filter.addAction(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
		registerReceiver(reciever, filter);
	}

	BroadcastReceiver reciever=new BroadcastReceiver() {
		
		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			Query query=new Query();
			//通过ID过滤
			query.setFilterById(id);
			Cursor cursor=manager.query(query);
			while(cursor.moveToNext()){
				Log.d("TAG",""+cursor.getString(cursor.getColumnIndex("title")));
			}
		}
	};
	
	protected void onPause() {
		super.onPause();
		unregisterReceiver(reciever);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.download, menu);
		return true;
	}

}
