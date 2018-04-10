package com.example.les_cartoon;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Í¸Ã÷¶È²¹¼ä
 * @author kulv16
 *
 */
public class AlphaActivity extends Activity {
	ImageView alphaIv;
	Animation scaleAim;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alpha);
		alphaIv=(ImageView)findViewById(R.id.alphaIv);
		scaleAim=AnimationUtils.loadAnimation(this,R.anim.alpha_anim);
		alphaIv.startAnimation(scaleAim);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.scale, menu);
		return true;
	}

}
