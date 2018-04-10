package com.example.apkpackage;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText et;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		et=(EditText) findViewById(R.id.et_path);
	}

	public void click(View view){
		String path  = et.getText().toString().trim();
		
		Intent intent = new Intent();
		intent.setAction("android.intent.action.VIEW");
		intent.addCategory("android.intent.category.DEFAULT");
		
		intent.setDataAndType(Uri.fromFile(new File(path)), "application/vnd.android.package-archive");
		startActivity(intent);
	}
}
