package com.example.les_media;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.PopupWindow;
import android.widget.VideoView;

/**
 * ��������
 * SD��
 * ����ѹ����Ƶ�ļ�  rmvb rm  
 * ֧�֣�mp4 avi 3pg
 * @author kulv16
 *
 */
public class VideoActivity extends Activity {
	VideoView video;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video);
		video=(VideoView)findViewById(R.id.video);
		//��λ��Ƶ�ļ�
		video.setVideoPath("mnt/sdcard/Download/pirate.mp4");
		video.start();
		
		//PopupWindow �Ի���
		
	}



}
