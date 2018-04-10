package com.renwen.readsms;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.xmlpull.v1.XmlSerializer;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.util.Xml;
import android.widget.Toast;

import com.renwen.readsms.domain.SmsInfo;


public class SmsUtils {
	
	public static void backSms(List<SmsInfo> smsinfos, Context ctx){
		XmlSerializer serializer =  Xml.newSerializer();

		File file=new File(Environment.getExternalStorageDirectory(),"backup2.xml");
		FileOutputStream fos=null;
		try {
			fos = new FileOutputStream(file);
			Log.d("TAG", "I LOVE YOU");
//		��ʼ�����к���ָ����xml����д�뵽�ĸ��ļ� ����ָ���ļ��ı��뷽ʽ
			serializer.setOutput(fos, "utf-8");
//		�����ʾ���xml�ļ��Ƿ����
			serializer.startDocument("utf-8", true);
			serializer.startTag(null, "smss");
			for (SmsInfo info : smsinfos) {
				serializer.startTag(null, "sms");
				//serializer.attribute(null, "id", info.getId()+"");
				
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
			Toast.makeText(ctx, "���ݳɹ�", 0).show();
		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(ctx, "����ʧ��", 0).show();
		}
	}
}
