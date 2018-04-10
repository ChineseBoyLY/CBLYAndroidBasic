package com.example.les_8view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MarqueeView extends View {
	float x=0;
	String str="走过路过不要错过，不买是你的错，不看是我的错。。";
	public MarqueeView(Context ctx,AttributeSet attri) {
		super(ctx, attri);
		thread=new FlushThread();
		thread.start();
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		//背景色
		canvas.drawColor(Color.argb(125,0,255,0));
		//创建画笔对象
		Paint paint=new Paint();
		//设置颜色
		paint.setColor(Color.RED);
		//设置字体大小
		paint.setTextSize(28);
		//绘制文字
		canvas.drawText(str, x, 100, paint);
		if(x>=768){
			x=-str.length()*28;
		}
		x+=10;
	}
	
	FlushThread thread;
	class FlushThread extends Thread{
		@Override
		public void run() {
			while(true){
				MarqueeView.this.postInvalidate();
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
