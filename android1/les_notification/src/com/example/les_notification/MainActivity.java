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
 * 传递参数
 * 启动组件
 * 	显示启动组件
 * 	隐式启动组件
 * 		指定功能启动组件
 * 		IntentFilter 过滤器
 * 		action ,data,category
 * 通知栏对话框4.2
 * 一般通知
 * 永久通知
 * 获得系统服务
 * 创建通知对象，设置通知属性
 * 文本 通知文本右下角文本
 * 图片 小图标 大图标 大图片
 * PendingIntent 挂起intent
 * 作业 ，点击通知跳转界面
 * 对话框
 * @author kulv16
 *
 */
public class MainActivity extends Activity {

	//通知系统服务对象
	NotificationManager manager;
	int progress=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//获得系统服务
		manager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
	}

	public void btnClick(View view){
		if(view.getId()==R.id.btn1){
			//简单通知
			Notification.Builder builder=new Notification.Builder(this);
			builder.setSmallIcon(R.drawable.ic_launcher);
			//弹通知 1、通知ID 
			manager.notify(1, builder.build());
		}else if(view.getId()==R.id.btn2){
			//文本通知
			Notification.Builder builder=new Notification.Builder(this);
			//设置通知图标
			builder.setSmallIcon(R.drawable.ic_launcher);
			//设置通知内容
			builder.setContentInfo("内容消息");
			//设置通知文本
			builder.setContentText("通知文本");
			//弹通知 2、通知ID 
			manager.notify(2, builder.build());
		}else if(view.getId()==R.id.btn3){
			//一定设置小图标
			Notification.Builder builder=new Notification.Builder(this).setNumber(99).setSmallIcon(R.drawable.ic_launcher);
			
			manager.notify(3, builder.build());
		}else if(view.getId()==R.id.btn4){
			//图片通知
			Notification.Builder builder=new Notification.Builder(this);
			builder.setSmallIcon(R.drawable.ic_launcher);
			Bitmap bitmap=BitmapFactory.decodeResource(getResources(), R.drawable.s6);
			builder.setLargeIcon(bitmap);
			builder.setContentInfo("大图标");
			manager.notify(4,builder.build());
		}else if(view.getId()==R.id.btn5){
			//大图片通知
			Bitmap bitmap=BitmapFactory.decodeResource(getResources(), R.drawable.s6);
			Notification.BigPictureStyle builder=new Notification.BigPictureStyle(new Notification.Builder(this).setContentInfo("大图片").setSmallIcon(R.drawable.ic_launcher)).bigPicture(bitmap);
			manager.notify(5, builder.build());
			
		}else if(view.getId()==R.id.btn6){
			//进度条通知
			Notification.Builder builder=new Notification.Builder(this);
			builder.setSmallIcon(R.drawable.ic_launcher);
			//true模糊进度条false精确进度条
			builder.setProgress(100,50,false);
			builder.setContentInfo("50%");
			builder.setContentText("qwer.txt");
			
			manager.notify(6,builder.build());
			
		}else if(view.getId()==R.id.btn7){
			//下载
			/*Notification.Builder builder=null;
			for (int i = 1; i < 100; i++) {
				builder=new Notification.Builder(this);
				builder.setSmallIcon(R.drawable.ic_launcher);
				//true模糊进度条false精确进度条
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
			//永久通知
			Notification.Builder builder=new Notification.Builder(this);
			builder.setSmallIcon(R.drawable.ic_launcher);
			builder.setContentText("永久通知");
			//设置通知是否永久 默认false
			//永久通知是只能自己应用清除 其他应用不能清除永久通知
			builder.setOngoing(true);
			manager.notify(7,builder.build());
			
		}else if(view.getId()==R.id.btn9){
			//清除通知
			manager.cancel(7);
		}else if(view.getId()==R.id.btn10){
			//打开一个通知的界面
			Notification.Builder builder=new Notification.Builder(this);
			builder.setSmallIcon(R.drawable.ic_launcher);
			builder.setContentText("打开通知界面");
			
			Intent notificationIntent = new Intent(this, NotifyActivity.class);
			PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

			builder.setContentIntent(pendingIntent);
			manager.notify(8,builder.build());
		}
	}

}
