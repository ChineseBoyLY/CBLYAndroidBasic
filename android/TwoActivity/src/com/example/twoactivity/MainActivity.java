package com.example.twoactivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void click(View view){
		if(view.getId()==R.id.btn1){
			Intent intent = new Intent();
			intent.setClass(this, SecondActivity.class);
			startActivity(intent);
		}else if(view.getId()==R.id.btn2){
			//com.android.gallery/com.android.camera.GalleryPicker（当启动应用 的时候看LogCat得到）
			Intent intent = new Intent();
			intent.setClassName("com.android.gallery", "com.android.camera.GalleryPicker");
			startActivity(intent);
		}else if(view.getId()==R.id.btn3){
			Intent intent = new Intent();
			intent.setAction("com.renwen.yinshi");
			//提供一些的执行的环境参数
			intent.addCategory(Intent.CATEGORY_DEFAULT);
			/*//指定数据格式
			intent.setData(Uri.parse("scheme:gfd"));
			//指定数据类型
			intent.setType("mp3");*/
			intent.setDataAndType(Uri.parse("scheme:gfd"), "vnd.android.cursor.item/andy");
			
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
