package com.example.les_cartoon;

import android.os.Bundle;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

/**
 * 动画效果
 * 属性动画
 * 		通过修改对象属性动画
 * 视图动画（补间动画）
 * 		指定开始状态结束状态，中间由系统补齐
 * 		移动补间，缩放补间，透明度补间，旋转补间 自转 公转
 * 		
 * 帧动画
 * 		指定每一幅画面快速切换
 * @author kulv16
 *
 */
public class MainActivity extends Activity {
	Button btn;
	//动画对象
	Animator anim;
	Move move;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn=(Button)findViewById(R.id.btn);
		//装载动画
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
			//修改对象属性
			btn.layout(x,btn.getTop(),x+btn.getMeasuredWidth(),btn.getBottom());
		}
		public int getX(){
			return this.x;
		}
	}
	
	public void btnClick(View view){
		//指定动画作用哪个对象
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
