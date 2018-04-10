package com.example.les_cartoon;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class TweenActivity extends Activity {

	Animation anim;
	Button btn;
	Animation animSub;
	Button btnSub;
	Button addSub;
	Animation addSubAnim;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tween);
		//×°ÔØ²¹¼ä¶¯»­
		anim=AnimationUtils.loadAnimation(this,R.anim.move_anim);
		animSub=AnimationUtils.loadAnimation(this,R.anim.move_anim_sub);
		addSubAnim=AnimationUtils.loadAnimation(this,R.anim.move_anim_subadd);
		btn=(Button)findViewById(R.id.tweenBtn);
		btnSub=(Button)findViewById(R.id.subBtn);
		addSub=(Button)findViewById(R.id.subAddBtn);
		btn.startAnimation(anim);
		btnSub.startAnimation(animSub);
		addSub.startAnimation(addSubAnim);
	}

	public void btnClick(View view){
		
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tween, menu);
		return true;
	}

}
