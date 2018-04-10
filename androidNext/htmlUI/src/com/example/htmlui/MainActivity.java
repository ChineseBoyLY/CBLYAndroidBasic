package com.example.htmlui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class MainActivity extends Activity {

	/**
	 * 例如大众点评网的
	 * 1·要添加internet的网络访问权限
	 */
	WebView wv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		wv=(WebView) findViewById(R.id.wv);
		
//		wv.clearCache(includeDiskFiles)//清除缓存等操作
		
		wv.loadUrl("http://192.168.4.2:8080/index.html");
	}
}
