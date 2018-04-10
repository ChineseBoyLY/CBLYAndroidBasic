package com.example.les_8view;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {
	
	List<Rain> list=new ArrayList<Rain>();
	FlushThread thread;
	public MyView(Context ctx,AttributeSet attri){
		super(ctx, attri);
		thread=new FlushThread();
		thread.start();
	}
	
	//添加集合
	public void addRain(Rain r){
		this.list.add(r);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		//创建画笔对象
		Paint paint=new Paint();
		//设置画笔的颜色
		paint.setColor(Color.BLUE);
		//设置圆圈空心
		paint.setStyle(Style.STROKE);
		//设置空心边框宽度
		paint.setStrokeWidth(5);
		//设置抗锯齿
		paint.setAntiAlias(true);
		
		for (int i = 0; i < this.list.size(); i++) {
			paint.setAlpha(this.list.get(i).alpha);
			canvas.drawCircle(this.list.get(i).x, this.list.get(i).y, this.list.get(i).r, paint);
			this.list.get(i).r+=5;
			this.list.get(i).alpha-=10;
			if(this.list.get(i).alpha<=10){
				//从集合里面移除
				this.list.remove(this.list.get(i));
			}
		}
	}
	
	class FlushThread extends Thread{
		@Override
		public void run() {
			// 刷新视图
			while(true){
				MyView.this.postInvalidate();
				//延迟毫秒刷新
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
