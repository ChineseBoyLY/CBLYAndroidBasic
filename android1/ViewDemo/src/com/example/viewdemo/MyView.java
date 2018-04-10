package com.example.viewdemo;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View;


public class MyView extends View implements Runnable{
	
	boolean flag=false;
	ArrayList<Circle> circleList=new ArrayList<Circle>();
	
	public void setCircleList(ArrayList<Circle> circleList){
		this.circleList=circleList;
	}
	
	public void setCircleList(Circle c){
		circleList.add(c);
	}
	
	public void setFlag(boolean flag){
		this.flag=flag;
	}
	
	public void startThread(){
		new Thread(this).start();
	}
	
	public MyView(Context ctx){
		super(ctx);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		if(circleList!=null){
			Paint paint=new Paint();
			paint.setAntiAlias(true);
			paint.setStyle(Style.STROKE);
			paint.setStrokeWidth(5);
			for (Circle circle: circleList) {
				paint.setARGB(circle.changeA(),129,55,97);
				canvas.drawCircle(circle.x,circle.y,circle.changeR(), paint);
			}
		}
	}

	@Override
	public void run() {
		while(flag){
			this.postInvalidate();
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
