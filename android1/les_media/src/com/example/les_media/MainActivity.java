package com.example.les_media;

import java.io.IOException;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

/**
 * 下拉刷新 
 * 资源
 * [a-z][0-9]
 * 
 * 多媒体
 * 	播放音频
 * 		播放资源音频
 * 		播放SD卡里面音频
 * 	声音文件
 * 	音效文件 
 * 		
 * 	播放视频 
 * 传感器
 * GPS 地图
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
		//播放资源声音文件
		//player=MediaPlayer.create(this,R.raw.north);
		
		//播放SD卡里面的文件
		player=new MediaPlayer();
	}

	public void btnClick(View view){
		if(view.getId()==R.id.btn1){
			//播放
			//player.start();
			
			/*player=MediaPlayer.create(this,R.raw.north);
			if(position!=-1){
				
				//从节点开始播放
				player.seekTo(position);
			}
			
			//从头开始播放
			player.start();*/
			
			//播放SD卡
			try {
				player.setDataSource("mnt/sdcard/tenyears.mp3");
				//准备
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
			//暂停
			//可以获得当前播放停止节点
			position=player.getCurrentPosition();
			player.stop();
			player.release();
		}else if(view.getId()==R.id.btn3){
			//停止
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
