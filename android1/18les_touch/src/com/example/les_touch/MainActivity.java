package com.example.les_touch;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * requestCode  ����˭�򿪵�
 * resultCode	���ֲ������
 * �˳���ʽ 1���Զ��弯��
 * 2��resultCode
 * 
 * ����
 * �̰�����
 * 
 * ����
 * ���㴥��
 * ̧�����ƶ��¼�
 * ����ֵ����
 * ����
 * ��㴥��
 * 
 * ������
 * 
 * ����������д����¼�
 * 
 * ������Ϊ��λ����
 * @author kulv16
 *
 */
public class MainActivity extends Activity {

	LinearLayout layout;
	TextView tv;
	
	//�ٶȶ���
	VelocityTracker vt;
	
	float x;
	float y;
	
	MyView view;
	
	//���������
	GestureDetector gest=new GestureDetector(new GestureDetector.OnGestureListener() {
		
		@Override
		public boolean onSingleTapUp(MotionEvent e) {
			// TODO Auto-generated method stub
			Log.d("TAG","���ᰴ������̧��");
			return false;
		}
		
		@Override
		public void onShowPress(MotionEvent e) {
			Log.d("TAG","�̰�");
		}
		
		@Override
		public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
				float distanceY) {
			// �����Զ����ٶ�����Ļ�ϻ��� ��ֻonScroll
			//Log.d("TAG","��������");
			view.setX(e2.getX());
			view.setY(e2.getY());
			return false;
		}
		
		@Override
		public void onLongPress(MotionEvent e) {
			// TODO Auto-generated method stub
			Log.d("TAG","����");
		}
		
		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			// ��ָ���뿪��Ļ��һ˲�����ܶ�����
			//Log.d("TAG","���ٻ���");
			view.setFlag(true);
			return false;
		}
		
		@Override
		public boolean onDown(MotionEvent e) {
			// TODO Auto-generated method stub
			Log.d("TAG","����");
			return false;
		}
	});
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		view=new MyView(this);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(view);
		layout=(LinearLayout)findViewById(R.id.layout);
		tv=(TextView)findViewById(R.id.tv);
		
		layout.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				Log.d("TAG", "��������");
				return true;
			}
		});
		
		tv.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				Log.d("TAG","�����ı���");
				return false;
			}
		});
		
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		//event ֻҪ�����¼���װ��event����
		//����  ̧��  �ƶ�
		//����ֵ ����¼�������� �¼��������¼�����
		//����¼�û������� �¼���������
		//Log.d("TAG","x���꣺"+event.getX()+",y���꣺"+event.getY());
		
		//��׽���Ĵ����¼�ȫ�����������ദ��
		gest.onTouchEvent(event);
		
		/*
		if(event.getAction()==MotionEvent.ACTION_DOWN){
			//�����¼�
			//Log.d("TAG","��ָ����");
			
			//����ٶ��ж϶���
			vt=VelocityTracker.obtain();
			
		}else if(event.getAction()==MotionEvent.ACTION_MOVE){
			//Log.d("TAG","��ָ�ƶ�");
			vt.addMovement(event);
			//�������ص�λ
			vt.computeCurrentVelocity(1000);
			x=vt.getXVelocity();
			y=vt.getYVelocity();
			//Log.d("TAG", "x�ٶȣ�"+vt.getXVelocity()+",y�ٶȣ�"+vt.getYVelocity());
			
		}else if(event.getAction()==MotionEvent.ACTION_UP){
			//Log.d("TAG","��ָ̧��");
			//�ͷŶ���
			vt.recycle();
			vt.clear();
		}*/
		return false;
	}

	
	/*�жϷ���*/
	public int judgeDirection(float vX,float vY){
		int direction=-1;
		if(Math.abs(vY)>Math.abs(vX)&&vY<0){
			/*���Y������ٶȾ���ֵ���� X�����ٶȾ���ֵ
			 * ����Y������ٶ�С��0 �ж�Ϊ���� ����
			 * ����1
			 * */
			direction=1;
			return 1;
		}
		if(Math.abs(vY)>Math.abs(vX)&&vY>0){
			/*���Y����� �ٶȾ���ֵ ���� X����ľ���ֵ
			 * ����Y�����ٶ� ���� 0 �ж�Ϊ���»���
			 * ����2
			 * */
			direction=2;
			return 2;
		}
		if(Math.abs(vX)>Math.abs(vY)&&vX>0){
			/*��� X����� �ٶȾ���ֵ ���� Y�����ٶȵľ���ֵ
			 * ���� X������ٶȴ��� 0 �ж�Ϊ���� ����
			 * ����4
			 * */
			direction=4;
			return 4;
		}
		if(Math.abs(vX)>Math.abs(vY)&&vX<0){
			/*��� X����� �ٶȾ���ֵ ���� Y�����ٶȵľ���ֵ
			 * ���� X������ٶ�С�� 0 �ж�Ϊ���� ����
			 * ����3
			 * */
			direction=3;
			return 3;
		}
		return 0;
	}
	
}