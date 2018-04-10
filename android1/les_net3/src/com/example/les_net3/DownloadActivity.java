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
		//֪ͨ �绰���� ���ع���
		manager=(DownloadManager)getSystemService(DOWNLOAD_SERVICE);
		//������������
		DownloadManager.Request request=new DownloadManager.Request(Uri.parse(imgurl));
		//�������ر���·�� 1��·��  mnt/sdcard/pictures 2���ļ���
		request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "pirate.mp4");
		//�������ر���
		request.setTitle("pirate.mp4");
		//�����������ϵͳ���ض���
		id=manager.enqueue(request);
		
		//ע��������ɵĹ㲥��Ϣ
		IntentFilter filter=new IntentFilter();
		filter.addAction(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
		registerReceiver(reciever, filter);
	}

	BroadcastReceiver reciever=new BroadcastReceiver() {
		
		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			Query query=new Query();
			//ͨ��ID����
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
