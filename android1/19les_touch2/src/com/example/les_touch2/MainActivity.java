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
 * 多点触摸
 * event 值解析
 * （多点触摸模式）组合码
 * 105	编号为1手指头（编号从0开始）最后一位表示手指头的操作5表示多点触摸模式下面按下事件
 * 206 编号为2手指头 （实际上第三个手指） 6表示多点触摸模式下面的抬起事件
 * 编号 手指的序号 会根据屏幕上手指个数不停更改
 * 单点触摸
 * 0表示按下
 * 1表示抬起
 * 2表示移动
 * pointid 手指ID 只要触摸没有离开屏幕
 * pointindex 手指序号
 * 如果需要跟踪每个手指 应该根据手指ID跟踪
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
		//Motionevent.action_down 表示单点触摸模式下面的按下操作
		//MotionEvent.ACTION_POINTER_1_DOWN 多点触摸模式下面的第一个手指按下操作
		
	/*if(event.getAction()!=2){
//		按在屏幕上面的手指的个数
		int count=event.getPointerCount();
		for (int i = 0; i < count; i++) {
			Log.d("TAG","pointIndex="+i+"，pointId="+event.getPointerId(i));
		}
	}*/
		/*if(event.getAction()==MotionEvent.ACTION_DOWN){
			Log.d("TAG","第一个手指按下");
		}
		
		if(event.getAction()==MotionEvent.ACTION_POINTER_1_DOWN){
			//第一个手指按下
			Log.d("TAG","第一个手指按下");
		}else if(event.getAction()==MotionEvent.ACTION_POINTER_2_DOWN){
			//第2个手指按下
			Log.d("TAG","第2个手指按下");
		}else if(event.getAction()==MotionEvent.ACTION_POINTER_3_DOWN){
			//第2个手指按下
			Log.d("TAG","第3个手指按下");
		}*/
		
		Point p=null;
		
		for (int i = 0; i < event.getPointerCount(); i++) {
			//单点触摸按下0 多点触摸按下5
			if(event.getAction()==0||getPintDown(event.getAction())==5){
				p=new Point();
				p.color=Color.rgb((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
				p.x=event.getX(i);
				p.y=event.getY(i);
				view.addList(p);
			}
			
			//没有考虑手指离开再按下
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
