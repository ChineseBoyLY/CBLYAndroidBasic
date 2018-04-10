package com.supermario.filemanager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
public class SearchBroadCast extends BroadcastReceiver {	
	public static  String mServiceKeyword = "";//���������ؼ��ֵľ�̬����
    public static  String mServiceSearchPath = "";//��������·���ľ�̬����   
	@Override
	public void onReceive(Context context, Intent intent) {
		//ȡ��intent
		String mAction = intent.getAction();
		if(MainActivity.KEYWORD_BROADCAST.equals(mAction)){
			//ȡ��intent���ݹ�������Ϣ
			mServiceKeyword = intent.getStringExtra("keyword");
			mServiceSearchPath = intent.getStringExtra("searchpath");
		}
	}
}
