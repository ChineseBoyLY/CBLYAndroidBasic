package com.example.ipdail;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

public class OutCallReceiver extends BroadcastReceiver{

	//当有广播事件产生的时候就会执行这个方法
	@Override
	public void onReceive(Context context, Intent intent) {
		//获取到向外拨打的电话号码
		String number = getResultData();
		Log.d("TAG", "onReceive发现新的外拨电话"+number);
		SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		//替换掉这个号码
		String newNumber = sp.getString("ipnum", "")+number;
		//设置外拨的电话号码
		setResultData(newNumber);
	}

}
