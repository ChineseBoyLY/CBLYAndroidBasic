package com.example.les_net2;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.widget.Gallery;

public class GlyActivity extends Activity {
	
	String[] imgUrls={
			"http://19.0.0.130:8080/dataServer/s3.jpg",
			"http://19.0.0.130:8080/dataServer/s4.jpg",
			"http://19.0.0.130:8080/dataServer/s5.jpg",
			"http://19.0.0.130:8080/dataServer/s6.jpg",
			"http://19.0.0.130:8080/dataServer/s7.jpg",
			"http://19.0.0.130:8080/dataServer/s8.jpg"
	};
	
	ImgAdapter adapter;
	Bitmap[] bitmaps=new Bitmap[6];
	DownloadThredad thread;
	Gallery gly;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gly);
		gly=(Gallery)findViewById(R.id.gly);
		/*for (int i = 0; i < imgUrls.length; i++) {
			thread=new DownloadThredad(imgUrls[i],i);
			thread.start();
		}*/
		/*for (int i = 0; i <imgUrls.length ; i++) {
			bitmaps[i]=BitmapFactory.decodeResource(getResources(), R.drawable.net3);
		}*/
		
		//异步任务下载六张图片
		for (int i = 0; i < imgUrls.length; i++) {
			final int index=i;
			new AsyncTask<String, Void, Bitmap>() {
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
				
				@Override
				protected void onPostExecute(Bitmap result) {
					// TODO Auto-generated method stub
					bitmaps[index]=result;
					adapter.notifyDataSetChanged();
				}
				
			}.execute(imgUrls[i]);
		}
		
		adapter=new ImgAdapter(this, bitmaps);
		gly.setAdapter(adapter);
	}

	class DownloadThredad extends Thread{
		String url="";
		int index=0;
		public DownloadThredad(String url,int i) {
			// TODO Auto-generated constructor stub
			this.url=url;
			this.index=i;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			URL url=null;
			HttpURLConnection conn=null;
			try {
				url=new URL(this.url);
				conn=(HttpURLConnection)url.openConnection();
				InputStream is=conn.getInputStream();
				bitmaps[this.index]=BitmapFactory.decodeStream(is);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gly, menu);
		return true;
	}

}
