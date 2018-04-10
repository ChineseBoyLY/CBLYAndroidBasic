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
 * ����
 * socket
 * httpClient
 * httpUrlConnection post
 * 
 * ���߳����治��ֱ�ӷ������߳�Ԫ��UI����Ԫ��
 * 
 * hanlder
 * 	 �ַ���Ϣ
 * Message 
 * 	��Ϣ����
 * MessageQueue
 * 	��Ϣ����
 * Looper 
 * 	ѭ����Ϣ������Ϣ���п�ʼ������
 * 	
 * 
 * ÿ��handler�����һ���̰߳󶨣�ÿ��handler����ͬʱҲ�����Ϣ���а�
 * 
 * 
 * �첽���� 
 * ͼƬ����
 * 
 * 
 * 
 * �߳�Ĭ����û����Ϣ����
 * ���ĸ��߳����洴����handler���handler�͸��ĸ��̰߳�
 * �߳�Ĭ��ֻ��һ����Ϣ����
 * ��android���������߳�Ĭ����û����Ϣ���У����̳߳���
 * �ļ���
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
					//��������ʽ
					conn.setRequestMethod("POST");
					//���������Ͳ���
					conn.setDoOutput(true);
					//�������ӳ�ʱ
					conn.setConnectTimeout(6000);
					//ƴ����������ַ���
					String data="name=kakx&pwd=123";
					//��������
					OutputStream os=conn.getOutputStream();
					//������д��������
					os.write(data.getBytes());
					//ˢ��
					os.flush();
					os.close();
					InputStreamReader isr=new InputStreamReader(conn.getInputStream());
					isr.close();
					//�Ͽ�����
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
				//����Ϣ������������Ϣ����
				//message ����  ����Ϣ ��������
				//�����̷߳�����Ϣ
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
