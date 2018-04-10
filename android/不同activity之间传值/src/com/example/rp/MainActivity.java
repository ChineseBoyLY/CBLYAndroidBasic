package com.example.rp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText et_name;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et_name=(EditText) findViewById(R.id.uname);
	}
	
	public void click(View view){
		String uname=et_name.getText().toString().trim();
		if(TextUtils.isEmpty(uname)){
			Toast.makeText(this, "姓名不能为空", Toast.LENGTH_SHORT).show();
			return;
		}
		Intent intent= new Intent();
		intent.putExtra("uname", uname);
		intent.setClass(this, ResultActivity.class);
		startActivity(intent);
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
