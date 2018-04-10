package com.example.les_cartoon;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Ëõ·Å²¹¼ä
 * @author kulv16
 *
 */
public class ScaleActivity extends Activity {
	ImageView scaleIv;
	Animation scaleAim;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scale);
		scaleIv=(ImageView)findViewById(R.id.scaleIv);
		scaleAim=AnimationUtils.loadAnimation(this,R.anim.scale_anim);
		scaleIv.startAnimation(scaleAim);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.scale, menu);
		return true;
	}

}
