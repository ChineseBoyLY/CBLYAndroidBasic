package com.example.les_net3;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class DataActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_data);
		/*thread=new XmlThread();
		thread.start();*/
		
		/*new Thread(){
			public void run() {
				URL url=null;
				HttpURLConnection conn=null;
				try {
					url=new URL("http://19.0.0.130:8080/dataServer/xmlData");
					conn=(HttpURLConnection)url.openConnection();
					InputStream is=conn.getInputStream();
					InputStreamReader isr=new InputStreamReader(is);
					int size=-1;
					char[] buf=new char[1024];
					StringBuffer sb=new StringBuffer();
					while((size=isr.read(buf))!=-1){
						sb.append(buf, 0, size);
					}
					
					Document doc=DocumentHelper.parseText(sb.toString());
					//获得根节点
					Element root=doc.getRootElement();
					//获得子节点
					Element stu1=root.element("stu1");
					Log.d("TAG", "xml请求结果："+stu1.attributeValue("name"));
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();*/
		
		
		new Thread(){
			public void run() {
				URL url=null;
				HttpURLConnection conn=null;
				try {
					url=new URL("http://19.0.0.130:8080/dataServer/getJsonData");
					conn=(HttpURLConnection)url.openConnection();
					InputStream is=conn.getInputStream();
					InputStreamReader isr=new InputStreamReader(is);
					int size=-1;
					char[] buf=new char[1024];
					StringBuffer sb=new StringBuffer();
					while((size=isr.read(buf))!=-1){
						sb.append(buf, 0, size);
					}
					JSONArray array=new JSONArray(sb.toString());
					JSONObject obj=null;
					for (int i = 0; i < array.length(); i++) {
						obj=array.getJSONObject(i);
						Log.d("TAG",""+obj.getString("name"));
					}
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}.start();
	}


	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.data, menu);
		return true;
	}

}
