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
		//�õ��ֻ�ƵĻ�Ŀ��
		WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
		//���������ڸ߰汾�����Ǳ������˵ķ���������Ϊ�˸��õļ����Ի��ǲ���
		WindomHeight = wm.getDefaultDisplay().getHeight();
		WindomWidth = wm.getDefaultDisplay().getWidth();
	}

	public void click(View view){
//		Bitmap bitmap = BitmapFactory.decodeFile("/mnt/sdcard/Pictures/a.jpg");
//		iv.setImageBitmap(bitmap);
		//ͼƬ����������
		BitmapFactory.Options opts = new Options();
		//��ȥ��Ľ���ͼƬ�� ֻ�ǻ�ȡͼƬ��ͷ����Ϣ  ���
		opts.inJustDecodeBounds = true;
		BitmapFactory.decodeFile("/mnt/sdcard/Pictures/a.jpg",opts);
		int imageHight = opts.outHeight;
		int imageWidth = opts.outWidth;
		
		Log.d("TAG", "width��"+imageWidth);
		Log.d("TAG", "height��"+imageHight);
		
		//�������ű���
		int scaleX = imageWidth/WindomWidth;
		int scaleY = imageHight/WindomHeight;
		
		int scale =1;
		if(scaleX>scaleY & scaleY >=1){
			scale = scaleX;
		}
		if(scaleX<scaleY & scaleX >=1){
			scale = scaleY;
		}
		
		//��Ľ���ͼƬ
		opts.inJustDecodeBounds = false;
		//������
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
