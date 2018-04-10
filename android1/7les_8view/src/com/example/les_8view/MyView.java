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
	
	//��Ӽ���
	public void addRain(Rain r){
		this.list.add(r);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		//�������ʶ���
		Paint paint=new Paint();
		//���û��ʵ���ɫ
		paint.setColor(Color.BLUE);
		//����ԲȦ����
		paint.setStyle(Style.STROKE);
		//���ÿ��ı߿���
		paint.setStrokeWidth(5);
		//���ÿ����
		paint.setAntiAlias(true);
		
		for (int i = 0; i < this.list.size(); i++) {
			paint.setAlpha(this.list.get(i).alpha);
			canvas.drawCircle(this.list.get(i).x, this.list.get(i).y, this.list.get(i).r, paint);
			this.list.get(i).r+=5;
			this.list.get(i).alpha-=10;
			if(this.list.get(i).alpha<=10){
				//�Ӽ��������Ƴ�
				this.list.remove(this.list.get(i));
			}
		}
	}
	
	class FlushThread extends Thread{
		@Override
		public void run() {
			// ˢ����ͼ
			while(true){
				MyView.this.postInvalidate();
				//�ӳٺ���ˢ��
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
