package com.example.les_8view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MarqueeView extends View {
	float x=0;
	String str="�߹�·����Ҫ�������������Ĵ��������ҵĴ���";
	public MarqueeView(Context ctx,AttributeSet attri) {
		super(ctx, attri);
		thread=new FlushThread();
		thread.start();
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		//����ɫ
		canvas.drawColor(Color.argb(125,0,255,0));
		//�������ʶ���
		Paint paint=new Paint();
		//������ɫ
		paint.setColor(Color.RED);
		//���������С
		paint.setTextSize(28);
		//��������
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
