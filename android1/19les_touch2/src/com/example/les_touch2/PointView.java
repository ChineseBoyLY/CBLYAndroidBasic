package com.example.les_touch2;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class PointView extends View {
	Context ctx;
	
	List<Point> list=new ArrayList<Point>();
	
	FlushThread thread;
	
	class FlushThread extends Thread{
		@Override
		public void run() {
			while(true){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				postInvalidate();
			}
		}
	}
	
	public void addList(Point p){
		this.list.add(p);
	}
	
	public void removeList(Point p){
		this.list.remove(p);
	}
	
	public PointView(Context ctx) {
		// TODO Auto-generated constructor stub
		super(ctx);
		thread=new FlushThread();
		thread.start();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		Paint paint=new Paint();
		for (int i = 0; i < this.list.size(); i++) {
			paint.setColor(this.list.get(i).color);
			
			canvas.drawCircle(this.list.get(i).x,this.list.get(i).y,100, paint);
		}
		
	}
	
}
