package com.example.les_net2;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.Menu;
import android.widget.ImageView;

public class AsyActivity extends Activity {
	ImageView imgAsy;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_asy);
		imgAsy=(ImageView)findViewById(R.id.imgAsy);
		//����������ֻ������������
		/*new AsyncTask<String,Integer,String>() {
			
			@Override
			protected String doInBackground(String... params) {
				// 
				
				//һ����doInBackground�����е���publishProgress 
				//���ӵ���onProgressUpdate ������
				//publishProgress(values)
				
				//��������
				URL url=null;
				HttpURLConnection conn=null;
				StringBuffer sb=new StringBuffer();
				try {
					url=new URL("http://19.0.0.130:8080/dataServer/getData");
					conn=(HttpURLConnection)url.openConnection();
					InputStream is=conn.getInputStream();
					int size=-1;
					
					char[] buf=new char[1024];
					InputStreamReader isr=new InputStreamReader(is);
					while((size=isr.read(buf))!=-1){
						publishProgress(size);
						sb.append(buf, 0, size);
					}
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return sb.toString();
			}
			
			
			protected void onProgressUpdate(Integer[] values) {
				Log.d("TAG","onProgressUpdate="+values[0]);
				
			}
			
			@Override
			protected void onPostExecute(String result) {
				// TODO Auto-generated method stub
				
				//������Ӧ
				Log.d("TAG","result="+result);
			}
			
		}.execute("http://19.0.0.130:8080/dataServer/getData");*/
	
		//����ͼƬ�첽����
		/*new AsyncTask<String, Void,Bitmap>() {
			@Override
			protected Bitmap doInBackground(String... params) {
				// TODO Auto-generated method stub
				Bitmap bitmap=null;
				URL url=null;
				HttpURLConnection conn=null;
						try {
							url=new URL(params[0]);
							conn=(HttpURLConnection)url.openConnection();
							InputStream is=conn.getInputStream();
							bitmap=BitmapFactory.decodeStream(is);
						} catch (MalformedURLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				return bitmap;
			}
			
			protected void onPostExecute(Bitmap result) {
				imgAsy.setImageBitmap(result);
			}
			
		}.execute("http://19.0.0.130:8080/dataServer/s3.jpg","123");*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.asy, menu);
		return true;
	}

}
