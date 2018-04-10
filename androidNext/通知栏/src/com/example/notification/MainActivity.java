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
		//��ȡ�ֻ�ϵ�����֪ͨ������
		NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		//ʵ����notification ��ʾ֪ͨ�ľ�������
		//����ǰ�İ汾�������(����ʹ�õģ�ͨ��)
		Notification notification = new Notification(R.drawable.ic_launcher, "aaaa", System.currentTimeMillis());
		//����notification������״̬
//		notification.flags = Notification.FLAG_INSISTENT;//һֱ��
		notification.flags = Notification.FLAG_AUTO_CANCEL;//���֮��ͻ���ʧ
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_CALL);
		intent.setData(Uri.parse("tel:110"));
		PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
		notification.setLatestEventInfo(this, "����", "����", pi);
		//��2.3�Ժ�İ汾�����
		/*Notification.Builder builder = new Builder(this);
		builder.setContentTitle("�ҵ�notification�ı���");
		builder.setContentText("����������");
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
