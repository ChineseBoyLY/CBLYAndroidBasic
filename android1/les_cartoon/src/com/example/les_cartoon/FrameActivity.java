package com.example.les_cartoon;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.view.Menu;
import android.widget.ImageView;

/**
 * ֡����
 * @author kulv16
 *
 */
public class FrameActivity extends Activity {
	ImageView frameIv;
	//֡��������
	AnimationDrawable drawable;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_frame);
		frameIv=(ImageView)findViewById(R.id.frameIv);
		//�Ѷ�����Դ����ͼƬ�򱳾�
		frameIv.setBackgroundResource(R.drawable.frame_anim);
		//����ǿ��ת��Ϊ��������
		drawable=(AnimationDrawable)frameIv.getBackground();
		drawable.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.frame, menu);
		return true;
	}

}
