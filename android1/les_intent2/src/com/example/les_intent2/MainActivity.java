package com.example.les_intent2;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

/**
 * Intent  ��ֵ �������
 * 	��ͼ
 * IntentFilter
 * 	��ͼ������
 * activity service
 *�����������ļ�
 * 1����ʾ������ʽ
 * 	ָ���������
 * 2����ʽ�������
 * 	ָ����������ϵͳ����ʵ��
 * ���ĳ�������ǩ����û�����ù�����
 * ��������֧����ʽ����
 * <category android:name="android.intent.category.DEFAULT"/>
 * uri http://www.baidu.com
 * http
 * https
 * ftp
 * setType����
 * setData���� ��ͻ
 * ˭д�ں��� �ĸ����ò�������
 * action ƥ�����(intentFilter�б���Ҫ��action��ǩ�������κ�intent������ͨ��action��֤)
 * 		���IntentFilter������action���ԣ���ôintent��Ҳ����
 * 		���ö�Ӧaction����
 * 		����ж��action���ԣ���ô����Ӧ��ƥ��һ��
 * 		���intentFilter��û������action��ǩ��intent��Ҳû��
 * 		����action����actionƥ��ʧ��
 * dataƥ�����
 * 		���ָֻ�����ݣ���ôintentҲ����ָ������
 * 		���intentFilter��ָ����Э�飬������������ָ������
 * 		intent��Ҳ����ָ������������һ���ģ�������ͨ��
 * 		ƥ��
 * 		���ָֻ�����ͣ���ôintentҲ����ָ����
 * 		setType��setData
 * 		���intentFilter��ͬʱָ�������ݺ����ͣ���ôintent��
 * 		Ҳ����ͬʱָ�����ݺ����ͣ�������ͨ��ƥ��
 * 		���������data���߲�����type����ôintent��Ҳ����
 * 		����data����type
 * categoryƥ�����
 * 		category�����Ӽ���֤��ʽ��intent����ָ����N��category��
 * 		��ĳһ��intentFilter�У�������M��category������M>=N,
 * 		��ô����ƥ��ɹ����������ƥ��ʧ��
 * 
 * @author kulv16
 *
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void btnClick(View view){
		Intent intent=null;
		if(view.getId()==R.id.btn1){
			intent=new Intent();
			//ָ��intent��Ϊ
			intent.setAction("com.example.road");
			startActivity(intent);
		}else if(view.getId()==R.id.btn2){
			//����
			intent=new Intent();
			intent.setAction("com.example.film");
			
			/*intent.setData(Uri.parse("http://180.97.33.107"));
			intent.setType("video/rmvb");*/
			intent.setDataAndType(Uri.parse("http://asdf"),"video/avi");
			startActivity(intent);
		}else if(view.getId()==R.id.btn3){
			//����
			intent=new Intent();
			intent.setAction("com.example.shopping");
			intent.addCategory("com.example.feifei");
			startActivity(intent);
		}else if(view.getId()==R.id.btn4){
			//ϵͳ���������
			intent=new Intent();
			intent.setAction("android.intent.action.VIEW");
			intent.addCategory("android.intent.category.BROWSABLE");
			intent.setData(Uri.parse("about://asdhfa"));
			startActivity(intent);
		}else if(view.getId()==R.id.btn5){
			//ϵͳ������
			intent=new Intent();
			intent.setAction("android.intent.action.MAIN");
			intent.addCategory("android.intent.category.LAUNCHER");
			intent.addCategory("android.intent.category.APP_CALCULATOR");
			startActivity(intent);
		}else if(view.getId()==R.id.btn6){
			//δ֪����
			intent=new Intent();
			intent.setAction("android.intent.action.MAIN");
			intent.addCategory("com.android.internal.category.PLATLOGO");
			startActivity(intent);
		}else if(view.getId()==R.id.btn7){
			//δ֪����2
			intent=new Intent();
			intent.setAction("android.intent.action.MAIN");
			intent.addCategory("android.intent.category.DESK_DOCK");
			startActivity(intent);
		}else if(view.getId()==R.id.btn8){
			//��������Ӧ��
			intent=new Intent();
			intent.setAction("android.intent.action.MAIN");

			
			startActivity(intent);
		
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
