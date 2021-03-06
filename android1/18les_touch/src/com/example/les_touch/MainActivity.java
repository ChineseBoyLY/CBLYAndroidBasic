package com.example.les_touch;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * requestCode  区分谁打开的
 * resultCode	区分操作结果
 * 退出方式 1、自定义集合
 * 2、resultCode
 * 
 * 方向
 * 短按长按
 * 
 * 触摸
 * 单点触摸
 * 抬起按下移动事件
 * 返回值作用
 * 方向
 * 多点触摸
 * 
 * 手势类
 * 
 * 所有组件都有触摸事件
 * 
 * 以像素为单位计算
 * @author kulv16
 *
 */
public class MainActivity extends Activity {

	LinearLayout layout;
	TextView tv;
	
	//速度对象
	VelocityTracker vt;
	
	float x;
	float y;
	
	MyView view;
	
	//手势类对象
	GestureDetector gest=new GestureDetector(new GestureDetector.OnGestureListener() {
		
		@Override
		public boolean onSingleTapUp(MotionEvent e) {
			// TODO Auto-generated method stub
			Log.d("TAG","轻轻按下马上抬起");
			return false;
		}
		
		@Override
		public void onShowPress(MotionEvent e) {
			Log.d("TAG","短按");
		}
		
		@Override
		public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
				float distanceY) {
			// 不管以多快的速度在屏幕上滑动 都只onScroll
			//Log.d("TAG","慢慢滑动");
			view.setX(e2.getX());
			view.setY(e2.getY());
			return false;
		}
		
		@Override
		public void onLongPress(MotionEvent e) {
			// TODO Auto-generated method stub
			Log.d("TAG","长按");
		}
		
		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			// 手指在离开屏幕的一瞬间跨过很多像素
			//Log.d("TAG","快速滑动");
			view.setFlag(true);
			return false;
		}
		
		@Override
		public boolean onDown(MotionEvent e) {
			// TODO Auto-generated method stub
			Log.d("TAG","按下");
			return false;
		}
	});
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		view=new MyView(this);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(view);
		layout=(LinearLayout)findViewById(R.id.layout);
		tv=(TextView)findViewById(R.id.tv);
		
		layout.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				Log.d("TAG", "摸到布局");
				return true;
			}
		});
		
		tv.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				Log.d("TAG","摸到文本框");
				return false;
			}
		});
		
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		//event 只要触摸事件封装在event里面
		//按下  抬起  移动
		//返回值 如果事件处理完毕 事件不会往下级传播
		//如果事件没处理完成 事件继续传播
		//Log.d("TAG","x坐标："+event.getX()+",y坐标："+event.getY());
		
		//捕捉到的触摸事件全部交给手势类处理
		gest.onTouchEvent(event);
		
		/*
		if(event.getAction()==MotionEvent.ACTION_DOWN){
			//按下事件
			//Log.d("TAG","手指按下");
			
			//获得速度判断对象
			vt=VelocityTracker.obtain();
			
		}else if(event.getAction()==MotionEvent.ACTION_MOVE){
			//Log.d("TAG","手指移动");
			vt.addMovement(event);
			//计算像素单位
			vt.computeCurrentVelocity(1000);
			x=vt.getXVelocity();
			y=vt.getYVelocity();
			//Log.d("TAG", "x速度："+vt.getXVelocity()+",y速度："+vt.getYVelocity());
			
		}else if(event.getAction()==MotionEvent.ACTION_UP){
			//Log.d("TAG","手指抬起");
			//释放对象
			vt.recycle();
			vt.clear();
		}*/
		return false;
	}

	
	/*判断方向*/
	public int judgeDirection(float vX,float vY){
		int direction=-1;
		if(Math.abs(vY)>Math.abs(vX)&&vY<0){
			/*如果Y方向的速度绝对值大于 X方向速度绝对值
			 * 并且Y方向的速度小于0 判断为向上 滑动
			 * 返回1
			 * */
			direction=1;
			return 1;
		}
		if(Math.abs(vY)>Math.abs(vX)&&vY>0){
			/*如果Y方向的 速度绝对值 大于 X方向的绝对值
			 * 并且Y方向速度 大于 0 判断为向下滑动
			 * 返回2
			 * */
			direction=2;
			return 2;
		}
		if(Math.abs(vX)>Math.abs(vY)&&vX>0){
			/*如果 X方向的 速度绝对值 大于 Y方向速度的绝对值
			 * 并且 X方向的速度大于 0 判断为向右 滑动
			 * 返回4
			 * */
			direction=4;
			return 4;
		}
		if(Math.abs(vX)>Math.abs(vY)&&vX<0){
			/*如果 X方向的 速度绝对值 大于 Y方向速度的绝对值
			 * 并且 X方向的速度小于 0 判断为向左 滑动
			 * 返回3
			 * */
			direction=3;
			return 3;
		}
		return 0;
	}
	
}
