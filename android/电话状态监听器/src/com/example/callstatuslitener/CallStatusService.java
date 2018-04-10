package com.example.callstatuslitener;

import java.io.IOException;

import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Environment;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

public class CallStatusService extends Service {

	/**
	 * 长期在后台运行的组件，如果
	 */
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Log.d("TAG", "服务创建");
		// 监视用户电话状态的变化。。。
		// 电话管理器 服务
		TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
		tm.listen(new MyPhoneStateListener(),
				PhoneStateListener.LISTEN_CALL_STATE);
	}

	private class MyPhoneStateListener extends PhoneStateListener {
		MediaRecorder recorder;

		@Override
		public void onCallStateChanged(int state, String incomingNumber) {

			switch (state) {
			case TelephonyManager.CALL_STATE_IDLE:// 空闲状态，没有通话没有响铃
				if (recorder != null) {
					recorder.stop();
					recorder.reset(); // You can reuse the object by going back
										// to setAudioSource() step
					recorder.release();
				}
				break;
			case TelephonyManager.CALL_STATE_RINGING:// 响铃状态
				Log.d("TAG", "发现来电号码：" + incomingNumber);

				// 1`创建出来一个录音机
				recorder = new MediaRecorder();
				// 设置录制的音频源从话筒里面获取声音
				recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
				recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
				recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
				recorder.setOutputFile("/sdcard/"+System.currentTimeMillis()+".3gp");
				try {
					recorder.prepare();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case TelephonyManager.CALL_STATE_OFFHOOK:// 通话状态
				if (recorder != null) {
					recorder.start(); // Recording is now started
				}
				break;

			default:
				break;
			}

			super.onCallStateChanged(state, incomingNumber);
		}

	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

}
