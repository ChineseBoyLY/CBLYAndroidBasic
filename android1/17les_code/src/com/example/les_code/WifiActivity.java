package com.example.les_code;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class WifiActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wifi);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.wifi, menu);
		return true;
	}

}
