package com.example.viewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.Window;

public class MainActivity extends Activity{
	
	MyView mv;
	int a=255;
	float radius=0;
	float x=0;
	float y=0;
	boolean flag=false;
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if(event.getAction()==MotionEvent.ACTION_DOWN){
//			Log.d("TAG","按下");
			x=event.getX();
			y=event.getY();
			flag=true;
			mv.setCircleList(new Circle(a, x, y, radius));
		}else if(event.getAction()==MotionEvent.ACTION_MOVE){
//			Log.d("TAG","移动"+event.getX()+","+event.getY());
			mv.startThread();
			x=event.getX();
			y=event.getY();
			mv.setCircleList(new Circle(a, x, y, radius));
		}else if(event.getAction()==MotionEvent.ACTION_UP){
//			Log.d("TAG","抬起");
		}
		mv.setFlag(flag);
		return super.onTouchEvent(event);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		mv=new MyView(this);
		setContentView(mv);
		
//		TweenAnim anim = new TweenAnim(this);  
//		anim.setFocusable(true);  
//		setContentView(anim); 
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

