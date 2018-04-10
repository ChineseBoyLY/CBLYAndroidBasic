package com.example.viewdemo2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MarqueeView extends View implements Runnable {

	String str= "走过路过不要错过,错过是你的错。。";
	int length=800-str.length()*30;
	int a=0;
	int r=0;
	int g=0;
	int b=0;
	float x = 0;
	float x2=-800;
	
	public MarqueeView(Context context, AttributeSet attrs) {
		super(context, attrs);
		new Thread(this).start();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(Color.argb(a, r, g, b));
		Paint paint = new Paint();
		paint.setColor(Color.RED);
		paint.setTextSize(30);
		
		canvas.drawText(str, x, 100, paint);
		canvas.drawText(str, x2, 100, paint);
		
		if(x2>length){
			x =  x2;
			x2 = -str.length()*30;
		}
		a+=5;
		r+=1;
		g+=7;
		b+=3;
//		a=(int)Math.random()*255;
//		r=(int)Math.random()*255;
//		g=(int)Math.random()*255;
//		b=(int)Math.random()*255;
		x2 += 10;
		x += 10;
	}

	@Override
	public void run() {
		while (true) {
			this.postInvalidate();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
