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
	//��ʾͼƬ��
	ImageView img1;
	//����ͼƬ��
	ImageView img2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_save_img);
		img1=(ImageView)findViewById(R.id.showImg);
		img2=(ImageView)findViewById(R.id.img2);		
	}

	public void btnClick(View view){
		//����ͼƬ�ַ���
		SharedPreferences prefers=getSharedPreferences("img",MODE_PRIVATE);
		if(view.getId()==R.id.saveBtn){
			//����ͼƬ
			Drawable draw=img1.getDrawable();
			//ǿ��ת���н�����
			BitmapDrawable bitDraw=(BitmapDrawable)draw;
			
			//ת����bitmap����
			Bitmap bitmap=bitDraw.getBitmap();
			
			//�ڴ���
			ByteArrayOutputStream bos=new ByteArrayOutputStream();
			
			//ѹ��1��ѹ����ʽ2��ѹ������3��ѹ�����������ط�
			bitmap.compress(Bitmap.CompressFormat.JPEG, 70, bos);
			//����������ֽ�����
			byte[] bytes=bos.toByteArray();
			//�ֽ����鰴��base64��ʽƴ�ӳ��ַ���
			String str=Base64.encodeToString(bytes, Base64.DEFAULT);
			
			//��ñ༭����
			Editor editor=prefers.edit();
			editor.putString("img", str);
			editor.commit();
		}else if(view.getId()==R.id.getBtn){
			//��ȡͼƬ
			String imgStr=prefers.getString("img","null");
			//����base64��ʽ���ֽ������ֳ��ֽ�����
			byte[] imgbytes=Base64.decode(imgStr.getBytes(),Base64.DEFAULT);
			Bitmap bitmap=BitmapFactory.decodeByteArray(imgbytes, 0,imgbytes.length);
			img2.setImageBitmap(bitmap);
		}
	}

}
