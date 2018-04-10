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
 * View 对象
 * 所有能在屏幕上看到的组件或者容器都是直接或者简介继承自View
 * 布局 容器  ViewGroup 继承
 * 组件 TextView 继承 widget
 * 如果是从代码构建视图对象 应该重写的构造方法 View(Context)
 * 如果是从xml构建视图对象，应该重写View(Context ctx,AttributeSet atri)
 * view组件 
 * 画笔对象 Paint 控制颜色 粗细 画布对象canvas 控制形状
 * 刷新 如果是在UI线程 invalidate()
 * 如果不是在UI线程里面 postInvalidate()
 * 颜色表示方案 
 * 1、rgb 16位真彩色  1个字节
 * 2、argb 255不透明
 * 3、32位真彩色  两个字节表示同一种颜色  rrggbb
 * 作业：雨滴效果
 * UI线程
 * @author Administrator
 *
 */
public class MainActivity extends Activity {
	MyView view;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//view=new MyView(this);
		//去掉标题
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		if(event.getAction()==MotionEvent.ACTION_DOWN){
			Log.d("TAG","按下");
			view.setColor(Color.parseColor("#ff0000"));
			//view.invalidate();
		}else if(event.getAction()==MotionEvent.ACTION_MOVE){
			Log.d("TAG","移动"+event.getX()+"，"+event.getY());
			view.setX(event.getX());
			view.setY(event.getY());
		}else if(event.getAction()==MotionEvent.ACTION_UP){
			Log.d("TAG","抬起");
			//view.invalidate();
			view.setColor(Color.parseColor("#00ff00"));
		}
		
		return super.onTouchEvent(event);
	}
	
}
