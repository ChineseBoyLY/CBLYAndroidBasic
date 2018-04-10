package com.renwen.productxml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.xmlpull.v1.XmlSerializer;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Xml;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.renwen.productxml.domain.SmsInfo;

public class MainActivity extends Activity {

	private List<SmsInfo> smsinfos;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		smsinfos=new ArrayList<SmsInfo>();
		Random random=new Random();
		long number = 135000001;
		for (int i = 0; i < 10; i++) {
			smsinfos.add(new SmsInfo(System.currentTimeMillis(),
					random.nextInt(2)+1,"短信内容"+i,Long.toString(number+i),i));
		}
	}
	
	public void backSms2(View view){
		XmlSerializer serializer =  Xml.newSerializer();
		File file=new File(Environment.getExternalStorageDirectory(),"backup2.xml");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
//		初始化序列号器指定的xml数据写入到哪个文件 并且指定文件的编码方式
			serializer.setOutput(fos, "utf-8");
//		后面表示这个xml文件是否独立
			serializer.startDocument("utf-8", true);
			serializer.startTag(null, "smss");
			for (SmsInfo info : smsinfos) {
				serializer.startTag(null, "sms");
				serializer.attribute(null, "id", info.getId()+"");
				
				serializer.startTag(null, "body");
				serializer.text(info.getBody());
				serializer.endTag(null, "body");
				
				serializer.startTag(null, "address");
				serializer.text(info.getAddress());
				serializer.endTag(null, "address");
				
				serializer.startTag(null, "type");
				serializer.text(info.getType()+"");
				serializer.endTag(null, "type");
				
				serializer.startTag(null, "date");
				serializer.text(info.getDate()+"");
				serializer.endTag(null, "date");
				
				serializer.endTag(null, "sms");
			}
			serializer.endTag(null, "smss");
			serializer.endDocument();
			fos.close();
			Toast.makeText(this, "备份成功", 0).show();
		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(this, "备份失败", 0).show();
		}
	}
	
	
//  备份手机的短信
	public void backSms(View view){
		//假设已经获取到了所有的短信
		StringBuilder sb=new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		sb.append("<smss>");
		for (SmsInfo info : smsinfos) {
			sb.append("<sms>");
			sb.append("<address>");
			sb.append(info.getAddress());
			sb.append("</address>");
			
			sb.append("<type>");
			sb.append(info.getType());
			sb.append("</type>");
			
			sb.append("<body>");
			sb.append(info.getBody());
			sb.append("</body>");
			
			sb.append("<date>");
			sb.append(info.getDate());
			sb.append("</date>");
			
			sb.append("</sms>");
		}
		sb.append("</smss>");
		
		File file=new File(Environment.getExternalStorageDirectory(),"backup.xml");
		FileOutputStream fos=null;
		try {
			fos = new FileOutputStream(file);
			fos.close();
			Toast.makeText(this, "备份成功", 0).show();
		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(this, "备份失败", 0).show();
		}
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
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
