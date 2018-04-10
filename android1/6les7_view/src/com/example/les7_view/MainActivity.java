package com.example.les7_view;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.Window;

/**
 * View ����
 * ����������Ļ�Ͽ��������������������ֱ�ӻ��߼��̳���View
 * ���� ����  ViewGroup �̳�
 * ��� TextView �̳� widget
 * ����ǴӴ��빹����ͼ���� Ӧ����д�Ĺ��췽�� View(Context)
 * ����Ǵ�xml������ͼ����Ӧ����дView(Context ctx,AttributeSet atri)
 * view��� 
 * ���ʶ��� Paint ������ɫ ��ϸ ��������canvas ������״
 * ˢ�� �������UI�߳� invalidate()
 * ���������UI�߳����� postInvalidate()
 * ��ɫ��ʾ���� 
 * 1��rgb 16λ���ɫ  1���ֽ�
 * 2��argb 255��͸��
 * 3��32λ���ɫ  �����ֽڱ�ʾͬһ����ɫ  rrggbb
 * ��ҵ�����Ч��
 * UI�߳�
 * @author Administrator
 *
 */
public class MainActivity extends Activity {
	MyView view;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//view=new MyView(this);
		//ȥ������
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		if(event.getAction()==MotionEvent.ACTION_DOWN){
			Log.d("TAG","����");
			view.setColor(Color.parseColor("#ff0000"));
			//view.invalidate();
		}else if(event.getAction()==MotionEvent.ACTION_MOVE){
			Log.d("TAG","�ƶ�"+event.getX()+"��"+event.getY());
			view.setX(event.getX());
			view.setY(event.getY());
		}else if(event.getAction()==MotionEvent.ACTION_UP){
			Log.d("TAG","̧��");
			//view.invalidate();
			view.setColor(Color.parseColor("#00ff00"));
		}
		
		return super.onTouchEvent(event);
	}
	
}
