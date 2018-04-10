package com.example.les7_view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


public class MyView extends View {

	int color=Color.parseColor("#ff0000");
	
	Bitmap bitmap;
	
	FlushThread thread;
	
	float x;
	float y;
	
	public void setX(float x){
		this.x=x;
	}
	
	public void setY(float y){
		this.y=y;
	}
	
	public void setColor(int color){
		this.color=color;
	}
	
	public MyView(Context ctx){
		super(ctx);
		bitmap=BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		thread=new FlushThread();
		thread.start();
		Log.d("TAG","从代码构建视图");
	}
	
	public MyView(Context ctx,AttributeSet attri){
		super(ctx, attri);
		Log.d("TAG","从xml构建视图");
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// draw 绘制 画  画笔 决定颜色 和 粗细   纸 决定形状
		Paint paint=new Paint();
		paint.setARGB(90,255,0,0);
		//Log.d("TAG","color="+this.color);
		
		//设置画笔颜色
		//paint.setColor(color);
		//颜色取值范围 0-255
		//canvas.drawARGB(125, 0,0,0);
		//绘制矩形  左 上 右 下
		//canvas.drawRect(100,100,300,300, paint);
		
		//图片左上顶点坐标 
		canvas.drawBitmap(bitmap, x, y, paint);
		
		//设置抗锯齿
		paint.setAntiAlias(true);
		//设置空心
		paint.setStyle(Style.STROKE);
		
		//设置空心圆边框宽度
		paint.setStrokeWidth(5);
		
		//1、圆心横坐标 2、圆心纵坐标 3、圆圈半径 4、圆圈画笔
		canvas.drawCircle(100,100,50, paint);
		
	}

	class FlushThread extends Thread{
		@Override
		public void run() {
			while(true){
				MyView.this.postInvalidate();
			}
		}
	}
	
}
