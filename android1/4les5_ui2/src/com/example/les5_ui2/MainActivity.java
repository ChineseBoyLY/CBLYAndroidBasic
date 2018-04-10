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
 * �޸�ͼƬ��Ӧ��Ļ��С���� draw9.bat�������ļ�
 * ImageView
 * 1����ʾ��Դ�����ͼƬ
 * 2����ʾ�ļ������ͼƬ��SD�������ͼƬ��
 * 3����ʾ����ͼƬ  socket
 * ÿ���ؼ� background ���� ��ɫ ͼƬ
 * ImageView ͼƬ��ʾ����
 * matrix �þ�������ͼƬ
 * fitXY	����ͼƬ��ԭʼ�ı��� ǿ�зŴ�ͼƬ��ȫ�����Ļ��ͼƬ��������������ţ�ʹ��ͼƬ��ȫ���ImageView�����ܻ����
   fitStart:���ֳ���ȣ�ͼƬ�ϳ��ı���ImageView��Ӧ��һ�£�Ȼ��������Ͻ�
   fitCenter�������űȣ�ͼƬ�ϳ��ı���ImageView��Ӧ��һ�£�Ȼ������м�
   fitEnd:�������űȣ�ͼƬ�ϳ��ı���ImageView��Ӧ��һ�£�Ȼ��������½�
   center:ͼƬ�����м䣬������
   centerCrop:�����ݺ�����ţ�ʹ��ͼƬ����ȫ����ImageView�����ܱ�֤ͼƬ�ܹ�������ʾ����Ļ��
   centerInside:�����ݺ�����ţ�ʹ��ImageView����ȫ��ʾͼƬ

	����������Ӷ�̨�豸 �� adb shell���� ���� more than one device
	
	��linux�����г������ļ������ļ��� ���ls
	�л�Ŀ¼��cd
	
	drawable ͼƬ����   ���ڴ����� ���ɲ���
	Bitmap 	ͼƬ���� �ɲ�����
	BitmapFactory  ���ļ����涨�� ����Դ���涨�� ������������
 * @author Administrator
 *
 */
public class MainActivity extends Activity {
	protected static final int CHANGE_UI = 1;
	protected static final int ERROR = 2;

	ImageView img;
	
	//���̴߳�����Ϣ������
	private Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			if(msg.what==CHANGE_UI){
				Bitmap bitmap=(Bitmap)msg.obj;
				img.setImageBitmap(bitmap);
			}else if(msg.what==ERROR){
				Toast.makeText(MainActivity.this, "��ʾͼƬʧ��", Toast.LENGTH_SHORT).show();
			}
		};
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imglayout);
		img=(ImageView)findViewById(R.id.img);
		//���ļ�����ͼƬ
		/*Bitmap bitmap=BitmapFactory.decodeFile("mnt/sdcard/winds.jpg");
		img.setImageBitmap(bitmap);*/
		
		/*
		 //������������ͼƬ
		try {
			InputStream is=new FileInputStream(new File("mnt/sdcard/winds.jpg"));
			Bitmap bitmap=BitmapFactory.decodeStream(is);
			img.setImageBitmap(bitmap);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//����Դ���洴��ͼƬ
		/*Bitmap bitmap=BitmapFactory.decodeResource(getResources(), R.drawable.net2);
		img.setImageBitmap(bitmap);*/  
	}

	public void btnClick(View view){
		/**
		 * ANR��application not response Ӧ�ó�������Ӧ
		 * ������ԭ�����߳���Ҫ���������кܶ࣬��Ӧ������飬����UI�ȵȡ�����
		 * ��������߳������������õ�ʱ�䣬Ӧ�ó���ͻ�����Ӧ
		 * 
		 * ���з��Ǻ�ʱ�Ĳ�����Ӧ�÷ŵ����߳�����ȥִ��
		 */
		new Thread(){
			public void run() {
				//��ʾ����ͼƬ
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
						//�������߳�һ����Ϣ�����Ҹ��½��棬����Ϊbitmap
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
