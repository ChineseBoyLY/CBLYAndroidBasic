package com.example.changeUI;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements OnClickListener {

	TextView tv1;
	TextView tv2;
	TextView tv3;
	TextView tv4;
	LinearLayout content;
	FragmentManager fm;
	FragmentTransaction ft;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tv1 = (TextView) findViewById(R.id.tab1);
		tv2 = (TextView) findViewById(R.id.tab2);
		tv3 = (TextView) findViewById(R.id.tab3);
		tv4 = (TextView) findViewById(R.id.tab4);

		content = (LinearLayout) findViewById(R.id.content);

		tv1.setOnClickListener(this);
		tv2.setOnClickListener(this);
		tv3.setOnClickListener(this);
		tv4.setOnClickListener(this);
		
		tv1.setBackgroundColor(Color.CYAN);
		fm=getSupportFragmentManager();
		ft = fm.beginTransaction();
		ft.replace(R.id.content, new Fragment1());
		ft.commit();
	}

	@Override
	public void onClick(View v) {
		ft = fm.beginTransaction();
		switch (v.getId()) {
		case R.id.tab1:
			tv1.setBackgroundColor(Color.CYAN);
			tv2.setBackgroundColor(Color.WHITE);
			tv3.setBackgroundColor(Color.WHITE);
			tv4.setBackgroundColor(Color.WHITE);
			ft.replace(R.id.content, new Fragment1());
			break;
		case R.id.tab2:
			tv1.setBackgroundColor(Color.WHITE);
			tv2.setBackgroundColor(Color.CYAN);
			tv3.setBackgroundColor(Color.WHITE);
			tv4.setBackgroundColor(Color.WHITE);
			ft.replace(R.id.content, new Fragment2());
			break;
		case R.id.tab3:
			tv1.setBackgroundColor(Color.WHITE);
			tv2.setBackgroundColor(Color.WHITE);
			tv3.setBackgroundColor(Color.CYAN);
			tv4.setBackgroundColor(Color.WHITE);
			ft.replace(R.id.content, new Fragment3());
			break;
		case R.id.tab4:
			tv1.setBackgroundColor(Color.WHITE);
			tv2.setBackgroundColor(Color.WHITE);
			tv3.setBackgroundColor(Color.WHITE);
			tv4.setBackgroundColor(Color.CYAN);
			ft.replace(R.id.content, new Fragment4());
			break;
		}
		ft.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
