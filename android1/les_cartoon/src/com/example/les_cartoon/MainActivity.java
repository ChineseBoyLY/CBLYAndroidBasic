package com.example.les_cartoon;

import android.os.Bundle;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

/**
 * ����Ч��
 * ���Զ���
 * 		ͨ���޸Ķ������Զ���
 * ��ͼ���������䶯����
 * 		ָ����ʼ״̬����״̬���м���ϵͳ����
 * 		�ƶ����䣬���Ų��䣬͸���Ȳ��䣬��ת���� ��ת ��ת
 * 		
 * ֡����
 * 		ָ��ÿһ����������л�
 * @author kulv16
 *
 */
public class MainActivity extends Activity {
	Button btn;
	//��������
	Animator anim;
	Move move;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn=(Button)findViewById(R.id.btn);
		//װ�ض���
		anim=AnimatorInflater.loadAnimator(this,R.animator.property_anim);
		move=new Move();
	}

	class Move{
		int x;
		int y;
		
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
			btn.layout(btn.getLeft(),y,btn.getRight(),y+btn.getMeasuredHeight());
		}
		public void setX(int x){
			this.x=x;
			//�޸Ķ�������
			btn.layout(x,btn.getTop(),x+btn.getMeasuredWidth(),btn.getBottom());
		}
		public int getX(){
			return this.x;
		}
	}
	
	public void btnClick(View view){
		//ָ�����������ĸ�����
		anim.setTarget(move);
		anim.start();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
