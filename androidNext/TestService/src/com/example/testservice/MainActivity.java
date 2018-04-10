package com.example.testservice;

import com.example.testservice.MyService.MyBinder;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	MyService.MyBinder myBinder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view){
    	if(view.getId()==R.id.btn1){
    		//��������
    		//�������񣬾���activity�˳��ˣ������ǻ᳤���ں�̨����
    		Intent intent = new Intent(this,MyService.class);
    		startService(intent);
    	}else if(view.getId()==R.id.btn2){
    		//ֹͣ ����
    		Intent intent = new Intent(this,MyService.class);
    		stopService(intent);
    	}else if(view.getId()==R.id.btn3){
    		//���÷�������ķ���
    		myBinder.callSing("����֮��");
    	}else if(view.getId()==R.id.btn4){
    		//��
    		//���ַ�ʽ��activityһ�����٣�����Ҳ����������
    		Intent intent = new Intent(this,MyService.class);
    		//�м����Ϊ������  �м��˶���  ��������������ϵ   ����Ϊ��
    		bindService(intent, conn, BIND_AUTO_CREATE);
    	}else if(view.getId()==R.id.btn5){
    		//������
    		//���ܱ���ν�󣬻ᱨ��
    		//��û�н�������£��˳���Ӧ�ó���ᱨ��һ����onDestory��������������
    		unbindService(conn);
    	}
    }
    
    protected void onDestroy() {
    	//������Է�ֹӦ�ó����˳���ʱ�򱨴�
    	try {
			unbindService(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
    };
    
    ServiceConnection conn = new ServiceConnection(){
    	//���񱻳ɹ��󶨵�ʱ����õķ���
		@Override
		public void onServiceConnected(ComponentName name,
				IBinder service) {
			Log.d("TAG", "����Ѵ����˷��ػ�����");
			myBinder = (MyBinder) service;
		}

		//���񱻽���󶨵ĵ�ʱ����õķ������쳣�˳�������kill���ģ���
		@Override
		public void onServiceDisconnected(ComponentName name) {
			Log.d("TAG", "onServiceDisconnected");
		}
	};
	
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
