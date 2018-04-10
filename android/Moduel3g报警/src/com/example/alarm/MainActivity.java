package com.example.alarm;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void click(View view){
		Intent intent = new Intent();
		intent.setAction("com.renwen.iloveyou");
		//把自定义的广播发送出去
		//sendBroadcast(intent);
		
		//有序广播的特点：高优先级的广播接受者可以终止掉广播事件
		//sendOrderedBroadcast(intent, null);
		
		//虽然被终止了但是指定的new FinalReceiver()永远都还是可以接收到的
		//保证有一个接受者可以接收到（防止被恶意的终止，打电话的地方系统就已经应用了这个）
		sendOrderedBroadcast(intent, null, new FinalReceiver(), null, 0, null, null);
	}
	
}
