package com.example.htmlui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class MainActivity extends Activity {

	/**
	 * ������ڵ�������
	 * 1��Ҫ���internet���������Ȩ��
	 */
	WebView wv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		wv=(WebView) findViewById(R.id.wv);
		
//		wv.clearCache(includeDiskFiles)//�������Ȳ���
		
		wv.loadUrl("http://192.168.4.2:8080/index.html");
	}
}
