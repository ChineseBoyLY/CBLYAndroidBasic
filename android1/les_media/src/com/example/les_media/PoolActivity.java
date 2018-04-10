package com.example.les_media;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.provider.MediaStore.Audio;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

/**
 * ������Ч�ļ�
 * @author kulv16
 *
 */
public class PoolActivity extends Activity {
	
	//�����ض���
	SoundPool pool=null;
	
	int s1=0;
	int s2=0;
	int s3=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pool);
		//1�����������װ����Ч�ļ����� 2���������� 3����������
		pool=new SoundPool(3,AudioManager.STREAM_MUSIC, 0);
		//װ����Ч�ļ� ��С���ܳ���1M
		s1=pool.load(this,R.raw.csfire,1);
		s2=pool.load(this,R.raw.lizi,0);
		s3=pool.load(this,R.raw.star,1);
	}

	public void btnClick(View view){
		if(view.getId()==R.id.btnp1){
			pool.play(s1, 1, 1, 0, 0, 0.5f);
			
		}else if(view.getId()==R.id.btnp2){
			pool.play(s2, 1, 1, 0, 0, 1.0f);
		}else if(view.getId()==R.id.btnp3){
			pool.play(s3, 1, 1, 0, 0, 2.0f);
		}
	}
	


}
