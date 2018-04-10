package com.example.les_service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

	String result="FALSE";
	
	//binder ��һ��Э�� �ڲ�ͬ�����֮�佻�����ݵ�Э��
	class MyBinder extends Binder{
		
		/*public void startDownload() {  
	        new Thread(new Runnable() {  
	            @Override  
	            public void run() {  
	                // ִ�о������������  
	            }  
	        }).start();  
	    } */ 
		
		public String getValue(){
			return result;
		}
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		// ��������Ƿ��ܱ������ ��������������������������Ϊ����
		//����з���ֵ ��ʾ��������
		//���û�з���ֵ ��ʾ�����ܱ�����
		MyBinder binder=new MyBinder();
		return binder;
	}
	
	@Override
	public void onCreate() {
		// ���񱻴�����ʱ��
		Log.d("TAG","���񱻴���");
	}
	

	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		/*new Thread(new Runnable() {  
	        @Override  
	        public void run() {  
	            // ��ʼִ�к�̨����  
	        }  
	    }).start();*/
		
		// ��������
		String name=intent.getStringExtra("name");
		//����
		//��½
		//��֤
		result="KO";
		Log.d("TAG","��������"+name);	
		//stopSelf();
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		// ��������
		Log.d("TAG","��������");
	}
	
}
