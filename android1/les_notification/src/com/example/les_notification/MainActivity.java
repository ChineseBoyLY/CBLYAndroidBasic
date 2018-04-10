package com.example.les_notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

/**
 * intent 
 * ���ݲ���
 * �������
 * 	��ʾ�������
 * 	��ʽ�������
 * 		ָ�������������
 * 		IntentFilter ������
 * 		action ,data,category
 * ֪ͨ���Ի���4.2
 * һ��֪ͨ
 * ����֪ͨ
 * ���ϵͳ����
 * ����֪ͨ��������֪ͨ����
 * �ı� ֪ͨ�ı����½��ı�
 * ͼƬ Сͼ�� ��ͼ�� ��ͼƬ
 * PendingIntent ����intent
 * ��ҵ �����֪ͨ��ת����
 * �Ի���
 * @author kulv16
 *
 */
public class MainActivity extends Activity {

	//֪ͨϵͳ�������
	NotificationManager manager;
	int progress=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//���ϵͳ����
		manager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
	}

	public void btnClick(View view){
		if(view.getId()==R.id.btn1){
			//��֪ͨ
			Notification.Builder builder=new Notification.Builder(this);
			builder.setSmallIcon(R.drawable.ic_launcher);
			//��֪ͨ 1��֪ͨID 
			manager.notify(1, builder.build());
		}else if(view.getId()==R.id.btn2){
			//�ı�֪ͨ
			Notification.Builder builder=new Notification.Builder(this);
			//����֪ͨͼ��
			builder.setSmallIcon(R.drawable.ic_launcher);
			//����֪ͨ����
			builder.setContentInfo("������Ϣ");
			//����֪ͨ�ı�
			builder.setContentText("֪ͨ�ı�");
			//��֪ͨ 2��֪ͨID 
			manager.notify(2, builder.build());
		}else if(view.getId()==R.id.btn3){
			//һ������Сͼ��
			Notification.Builder builder=new Notification.Builder(this).setNumber(99).setSmallIcon(R.drawable.ic_launcher);
			
			manager.notify(3, builder.build());
		}else if(view.getId()==R.id.btn4){
			//ͼƬ֪ͨ
			Notification.Builder builder=new Notification.Builder(this);
			builder.setSmallIcon(R.drawable.ic_launcher);
			Bitmap bitmap=BitmapFactory.decodeResource(getResources(), R.drawable.s6);
			builder.setLargeIcon(bitmap);
			builder.setContentInfo("��ͼ��");
			manager.notify(4,builder.build());
		}else if(view.getId()==R.id.btn5){
			//��ͼƬ֪ͨ
			Bitmap bitmap=BitmapFactory.decodeResource(getResources(), R.drawable.s6);
			Notification.BigPictureStyle builder=new Notification.BigPictureStyle(new Notification.Builder(this).setContentInfo("��ͼƬ").setSmallIcon(R.drawable.ic_launcher)).bigPicture(bitmap);
			manager.notify(5, builder.build());
			
		}else if(view.getId()==R.id.btn6){
			//������֪ͨ
			Notification.Builder builder=new Notification.Builder(this);
			builder.setSmallIcon(R.drawable.ic_launcher);
			//trueģ��������false��ȷ������
			builder.setProgress(100,50,false);
			builder.setContentInfo("50%");
			builder.setContentText("qwer.txt");
			
			manager.notify(6,builder.build());
			
		}else if(view.getId()==R.id.btn7){
			//����
			/*Notification.Builder builder=null;
			for (int i = 1; i < 100; i++) {
				builder=new Notification.Builder(this);
				builder.setSmallIcon(R.drawable.ic_launcher);
				//trueģ��������false��ȷ������
				builder.setProgress(100,progress,false);
				builder.setContentInfo(progress+"%");
				builder.setContentText("qwer.txt");
				manager.notify(6,builder.build());
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				progress+=5;
			}*/
		}else if(view.getId()==R.id.btn8){
			//����֪ͨ
			Notification.Builder builder=new Notification.Builder(this);
			builder.setSmallIcon(R.drawable.ic_launcher);
			builder.setContentText("����֪ͨ");
			//����֪ͨ�Ƿ����� Ĭ��false
			//����֪ͨ��ֻ���Լ�Ӧ����� ����Ӧ�ò����������֪ͨ
			builder.setOngoing(true);
			manager.notify(7,builder.build());
			
		}else if(view.getId()==R.id.btn9){
			//���֪ͨ
			manager.cancel(7);
		}else if(view.getId()==R.id.btn10){
			//��һ��֪ͨ�Ľ���
			Notification.Builder builder=new Notification.Builder(this);
			builder.setSmallIcon(R.drawable.ic_launcher);
			builder.setContentText("��֪ͨ����");
			
			Intent notificationIntent = new Intent(this, NotifyActivity.class);
			PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

			builder.setContentIntent(pendingIntent);
			manager.notify(8,builder.build());
		}
	}

}
