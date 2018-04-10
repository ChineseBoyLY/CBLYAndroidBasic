package com.example.onloadpic;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity extends Activity {

	ImageView iv;
	int WindomHeight;
	int WindomWidth;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		iv=(ImageView) findViewById(R.id.iv);
		//得到手机频幕的宽高
		WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
		//下面俩个在高版本里面是被丢弃了的方法，但是为了更好的兼容性还是采用
		WindomHeight = wm.getDefaultDisplay().getHeight();
		WindomWidth = wm.getDefaultDisplay().getWidth();
	}

	public void click(View view){
//		Bitmap bitmap = BitmapFactory.decodeFile("/mnt/sdcard/Pictures/a.jpg");
//		iv.setImageBitmap(bitmap);
		//图片解析的配置
		BitmapFactory.Options opts = new Options();
		//不去真的解析图片， 只是获取图片的头部信息  宽高
		opts.inJustDecodeBounds = true;
		BitmapFactory.decodeFile("/mnt/sdcard/Pictures/a.jpg",opts);
		int imageHight = opts.outHeight;
		int imageWidth = opts.outWidth;
		
		Log.d("TAG", "width："+imageWidth);
		Log.d("TAG", "height："+imageHight);
		
		//计算缩放比例
		int scaleX = imageWidth/WindomWidth;
		int scaleY = imageHight/WindomHeight;
		
		int scale =1;
		if(scaleX>scaleY & scaleY >=1){
			scale = scaleX;
		}
		if(scaleX<scaleY & scaleX >=1){
			scale = scaleY;
		}
		
		//真的解析图片
		opts.inJustDecodeBounds = false;
		//采样率
		opts.inSampleSize = scale;
		
		Bitmap bitmap = BitmapFactory.decodeFile("/mnt/sdcard/Pictures/b.jpg",opts);
		iv.setImageBitmap(bitmap);
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
