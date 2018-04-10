package com.example.les_cartoon;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class BallActivity extends Activity {
	ImageView ballImg;
	Animation animFall;
	Animation animUp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ball);
		ballImg=(ImageView)findViewById(R.id.ballIv);
		animFall=AnimationUtils.loadAnimation(this,R.anim.ball_fall);
		animUp=AnimationUtils.loadAnimation(this,R.anim.ball_up);
		ballImg.startAnimation(animFall);
		
		//设置动画播放完成监听器
		animFall.setAnimationListener(new Animation.AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				//当动画播放完成回调方法
				ballImg.startAnimation(animUp);
				//Log.d("TAG","ASDF");
			}
		});
		
		animUp.setAnimationListener(new Animation.AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				ballImg.startAnimation(animFall);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ball, menu);
		return true;
	}

}
