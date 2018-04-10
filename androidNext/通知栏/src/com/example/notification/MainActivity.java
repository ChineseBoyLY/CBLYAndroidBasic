package com.example.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void click(View view){
		//获取手机系里面的通知管理器
		NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		//实例化notification 表示通知的具体内容
		//在以前的版本中用这个(建议使用的，通用)
		Notification notification = new Notification(R.drawable.ic_launcher, "aaaa", System.currentTimeMillis());
		//设置notification点击后的状态
//		notification.flags = Notification.FLAG_INSISTENT;//一直在
		notification.flags = Notification.FLAG_AUTO_CANCEL;//点击之后就会消失
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_CALL);
		intent.setData(Uri.parse("tel:110"));
		PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
		notification.setLatestEventInfo(this, "标题", "内容", pi);
		//在2.3以后的版本用这个
		/*Notification.Builder builder = new Builder(this);
		builder.setContentTitle("我的notification的标题");
		builder.setContentText("我是内容体");
		builder.setSmallIcon(R.drawable.ic_launcher);
		builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher));
		Notification notification = builder.getNotification();*/
		nm.notify(0, notification);
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
