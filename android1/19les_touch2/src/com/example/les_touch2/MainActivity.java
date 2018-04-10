package com.example.les_touch2;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;

/**
 * 6 1
 * ��㴥��
 * event ֵ����
 * ����㴥��ģʽ�������
 * 105	���Ϊ1��ָͷ����Ŵ�0��ʼ�����һλ��ʾ��ָͷ�Ĳ���5��ʾ��㴥��ģʽ���水���¼�
 * 206 ���Ϊ2��ָͷ ��ʵ���ϵ�������ָ�� 6��ʾ��㴥��ģʽ�����̧���¼�
 * ��� ��ָ����� �������Ļ����ָ������ͣ����
 * ���㴥��
 * 0��ʾ����
 * 1��ʾ̧��
 * 2��ʾ�ƶ�
 * pointid ��ָID ֻҪ����û���뿪��Ļ
 * pointindex ��ָ���
 * �����Ҫ����ÿ����ָ Ӧ�ø�����ָID����
 * 
 * @author kulv16
 *
 */
public class MainActivity extends Activity {
	PointView view;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		view=new PointView(this);
		setContentView(view);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		//Motionevent.action_down ��ʾ���㴥��ģʽ����İ��²���
		//MotionEvent.ACTION_POINTER_1_DOWN ��㴥��ģʽ����ĵ�һ����ָ���²���
		
	/*if(event.getAction()!=2){
//		������Ļ�������ָ�ĸ���
		int count=event.getPointerCount();
		for (int i = 0; i < count; i++) {
			Log.d("TAG","pointIndex="+i+"��pointId="+event.getPointerId(i));
		}
	}*/
		/*if(event.getAction()==MotionEvent.ACTION_DOWN){
			Log.d("TAG","��һ����ָ����");
		}
		
		if(event.getAction()==MotionEvent.ACTION_POINTER_1_DOWN){
			//��һ����ָ����
			Log.d("TAG","��һ����ָ����");
		}else if(event.getAction()==MotionEvent.ACTION_POINTER_2_DOWN){
			//��2����ָ����
			Log.d("TAG","��2����ָ����");
		}else if(event.getAction()==MotionEvent.ACTION_POINTER_3_DOWN){
			//��2����ָ����
			Log.d("TAG","��3����ָ����");
		}*/
		
		Point p=null;
		
		for (int i = 0; i < event.getPointerCount(); i++) {
			//���㴥������0 ��㴥������5
			if(event.getAction()==0||getPintDown(event.getAction())==5){
				p=new Point();
				p.color=Color.rgb((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
				p.x=event.getX(i);
				p.y=event.getY(i);
				view.addList(p);
			}
			
			//û�п�����ָ�뿪�ٰ���
			if(event.getAction()==2){
				view.list.get(i).x=event.getX(i);
				view.list.get(i).y=event.getY(i);
			}
		}
		return false;
	}

	public int getPintDown(int actionCode){
		String str=Integer.toHexString(actionCode);
		str=str.substring(str.length()-1, str.length());
		return Integer.parseInt(str);
	}
	
	public int getPointCount(int actionCode){
		String temp=Integer.toHexString(actionCode);
		String reuslt=temp.substring(0,1);
		int i=Integer.parseInt(reuslt);
		return i;
	}
	
}
