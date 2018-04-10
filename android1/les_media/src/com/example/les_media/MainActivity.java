package com.example.les_media;

import java.io.IOException;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

/**
 * ����ˢ�� 
 * ��Դ
 * [a-z][0-9]
 * 
 * ��ý��
 * 	������Ƶ
 * 		������Դ��Ƶ
 * 		����SD��������Ƶ
 * 	�����ļ�
 * 	��Ч�ļ� 
 * 		
 * 	������Ƶ 
 * ������
 * GPS ��ͼ
 * @author kulv16
 *
 */
public class MainActivity extends Activity {
	MediaPlayer player;
	int position=-1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//������Դ�����ļ�
		//player=MediaPlayer.create(this,R.raw.north);
		
		//����SD��������ļ�
		player=new MediaPlayer();
	}

	public void btnClick(View view){
		if(view.getId()==R.id.btn1){
			//����
			//player.start();
			
			/*player=MediaPlayer.create(this,R.raw.north);
			if(position!=-1){
				
				//�ӽڵ㿪ʼ����
				player.seekTo(position);
			}
			
			//��ͷ��ʼ����
			player.start();*/
			
			//����SD��
			try {
				player.setDataSource("mnt/sdcard/tenyears.mp3");
				//׼��
				player.prepare();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			player.start();
			
		}else if(view.getId()==R.id.btn2){
			//��ͣ
			//���Ի�õ�ǰ����ֹͣ�ڵ�
			position=player.getCurrentPosition();
			player.stop();
			player.release();
		}else if(view.getId()==R.id.btn3){
			//ֹͣ
			player.stop();
			player.release();
			position=-1;
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
