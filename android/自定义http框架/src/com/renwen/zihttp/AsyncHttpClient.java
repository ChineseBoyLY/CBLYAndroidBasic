package com.renwen.zihttp;

import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.Message;

public class AsyncHttpClient {
	
	public void get(final String path, final MyHandler myHandler){
		new Thread(){
			public void run() {
				HttpClient client = new DefaultHttpClient();
				HttpGet httpGet = new HttpGet(path);
				try{
					//执行成功
					HttpResponse response = client.execute(httpGet);
					InputStream is = response.getEntity().getContent();
					String content = StreamTools.readInputStream(is);
					Message msg = new Message();
					msg.obj = content;
					msg.what = 1;
					myHandler.sendMessage(msg);
				}catch(Exception e){
					//执行失败
					e.printStackTrace();
					Message msg = new Message();
					msg.obj = "请求失败";
					msg.what = 2;
					myHandler.sendMessage(msg);
				}
			};
		}.start();
	}
}
