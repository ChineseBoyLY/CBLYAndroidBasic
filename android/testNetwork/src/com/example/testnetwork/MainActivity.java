package com.example.testnetwork;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = cm.getActiveNetworkInfo();
		if(info!=null&&info.isConnected()){
			Toast.makeText(this, "网络可用", 1).show();
		}else{
			//cmp=com.android.settings/.SubSettings(10-05 13:59:58.254: D/SubSettings(2340): Launching fragment com.android.settings.WirelessSettings)

			Toast.makeText(this, "网络不可用", 1).show();
			Intent intent = new Intent();
			//只在2.3里面可以用
			intent.setClassName("com.android.settings", "com.android.settings.WirelessSettings");
			startActivity(intent);
		}
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
