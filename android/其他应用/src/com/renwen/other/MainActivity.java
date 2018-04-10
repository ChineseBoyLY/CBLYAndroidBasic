package com.renwen.other;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void readPrivate(View view){
		File file=new File("/data/data/com.renwen.login/files/private.txt");
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			BufferedReader br=new BufferedReader(new InputStreamReader(fis));
			String result = br.readLine();
			Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(this, "读取私有文件失败", Toast.LENGTH_SHORT).show();
		}
	}
	
	public void writePrivate(View view){
		File file=new File("/data/data/com.renwen.login/files/private.txt");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			fos.write("haha".getBytes());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(this, "读取私有文件失败", Toast.LENGTH_SHORT).show();
		}
	}
	
	public void readDefault(View view){
		File file=new File("/data/data/com.renwen.login/files/write.txt");
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			BufferedReader br=new BufferedReader(new InputStreamReader(fis));
			String result = br.readLine();
			Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(this, "读取可写文件失败", Toast.LENGTH_SHORT).show();
		}
	}
	
	public void writeDefault(View view){
		File file=new File("/data/data/com.renwen.login/files/write.txt");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			fos.write("haha".getBytes());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(this, "写可写文件失败", Toast.LENGTH_SHORT).show();
		}
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
