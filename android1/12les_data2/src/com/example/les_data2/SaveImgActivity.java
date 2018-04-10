package com.example.les_data2;

import java.io.ByteArrayOutputStream;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;

public class SaveImgActivity extends Activity {
	//显示图片框
	ImageView img1;
	//保存图片框
	ImageView img2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_save_img);
		img1=(ImageView)findViewById(R.id.showImg);
		img2=(ImageView)findViewById(R.id.img2);		
	}

	public void btnClick(View view){
		//保存图片字符串
		SharedPreferences prefers=getSharedPreferences("img",MODE_PRIVATE);
		if(view.getId()==R.id.saveBtn){
			//保存图片
			Drawable draw=img1.getDrawable();
			//强制转换中介类型
			BitmapDrawable bitDraw=(BitmapDrawable)draw;
			
			//转换成bitmap类型
			Bitmap bitmap=bitDraw.getBitmap();
			
			//内存流
			ByteArrayOutputStream bos=new ByteArrayOutputStream();
			
			//压缩1、压缩格式2、压缩质量3、压缩输出流保存地方
			bitmap.compress(Bitmap.CompressFormat.JPEG, 70, bos);
			//输出流换成字节数组
			byte[] bytes=bos.toByteArray();
			//字节数组按照base64格式拼接成字符串
			String str=Base64.encodeToString(bytes, Base64.DEFAULT);
			
			//获得编辑对象
			Editor editor=prefers.edit();
			editor.putString("img", str);
			editor.commit();
		}else if(view.getId()==R.id.getBtn){
			//读取图片
			String imgStr=prefers.getString("img","null");
			//按照base64格式把字节数组拆分成字节数组
			byte[] imgbytes=Base64.decode(imgStr.getBytes(),Base64.DEFAULT);
			Bitmap bitmap=BitmapFactory.decodeByteArray(imgbytes, 0,imgbytes.length);
			img2.setImageBitmap(bitmap);
		}
	}

}
