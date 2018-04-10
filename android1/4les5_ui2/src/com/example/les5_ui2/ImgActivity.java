package com.example.les5_ui2;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class ImgActivity extends Activity {
	ImageView img1;
	int[] resids={R.drawable.net2,R.drawable.sail,R.drawable.winds};
	int index=0;
	Bitmap bitmap;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_img);
		img1=(ImageView)findViewById(R.id.img1);
		bitmap=BitmapFactory.decodeResource(getResources(), resids[0]);
		img1.setImageBitmap(bitmap);
	}

	public void btnClick(View view){
		if(view.getId()==R.id.nextBtn){
			//下一张
			index++;
			if(index>2){
				index=2;
			}
			bitmap=BitmapFactory.decodeResource(getResources(), resids[index]);
			
		}else if(view.getId()==R.id.frontBtn){
			//上一张
			index--;
			if(index<0){
				index=0;
			}
			bitmap=BitmapFactory.decodeResource(getResources(), resids[index]);
		}
		img1.setImageBitmap(bitmap);
	}
	
}
