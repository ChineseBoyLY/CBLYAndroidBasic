package com.example.ipdail;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

public class OutCallReceiver extends BroadcastReceiver{

	//���й㲥�¼�������ʱ��ͻ�ִ���������
	@Override
	public void onReceive(Context context, Intent intent) {
		//��ȡ�����Ⲧ��ĵ绰����
		String number = getResultData();
		Log.d("TAG", "onReceive�����µ��Ⲧ�绰"+number);
		SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		//�滻���������
		String newNumber = sp.getString("ipnum", "")+number;
		//�����Ⲧ�ĵ绰����
		setResultData(newNumber);
	}

}
