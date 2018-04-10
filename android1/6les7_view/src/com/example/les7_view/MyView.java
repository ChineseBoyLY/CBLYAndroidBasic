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
		Log.d("TAG","�Ӵ��빹����ͼ");
	}
	
	public MyView(Context ctx,AttributeSet attri){
		super(ctx, attri);
		Log.d("TAG","��xml������ͼ");
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// draw ���� ��  ���� ������ɫ �� ��ϸ   ֽ ������״
		Paint paint=new Paint();
		paint.setARGB(90,255,0,0);
		//Log.d("TAG","color="+this.color);
		
		//���û�����ɫ
		//paint.setColor(color);
		//��ɫȡֵ��Χ 0-255
		//canvas.drawARGB(125, 0,0,0);
		//���ƾ���  �� �� �� ��
		//canvas.drawRect(100,100,300,300, paint);
		
		//ͼƬ���϶������� 
		canvas.drawBitmap(bitmap, x, y, paint);
		
		//���ÿ����
		paint.setAntiAlias(true);
		//���ÿ���
		paint.setStyle(Style.STROKE);
		
		//���ÿ���Բ�߿���
		paint.setStrokeWidth(5);
		
		//1��Բ�ĺ����� 2��Բ�������� 3��ԲȦ�뾶 4��ԲȦ����
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
