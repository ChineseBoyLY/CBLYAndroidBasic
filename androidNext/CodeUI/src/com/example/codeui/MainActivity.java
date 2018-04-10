package com.example.codeui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
		
		LinearLayout ll = new LinearLayout(this);
		ll.setGravity(Gravity.CENTER);
		
		TextView tv = new TextView(this);
		tv.setText("haha");
		
		ll.addView(tv);
		setContentView(ll);
	}

}
