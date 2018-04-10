package com.example.les_cartoon;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.view.Menu;
import android.widget.ImageView;

/**
 * 帧动画
 * @author kulv16
 *
 */
public class FrameActivity extends Activity {
	ImageView frameIv;
	//帧动画对象
	AnimationDrawable drawable;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_frame);
		frameIv=(ImageView)findViewById(R.id.frameIv);
		//把动画资源设置图片框背景
		frameIv.setBackgroundResource(R.drawable.frame_anim);
		//背景强制转换为动画类型
		drawable=(AnimationDrawable)frameIv.getBackground();
		drawable.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.frame, menu);
		return true;
	}

}
