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
	 * �����ں�̨���е���������
	 */
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Log.d("TAG", "���񴴽�");
		// �����û��绰״̬�ı仯������
		// �绰������ ����
		TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
		tm.listen(new MyPhoneStateListener(),
				PhoneStateListener.LISTEN_CALL_STATE);
	}

	private class MyPhoneStateListener extends PhoneStateListener {
		MediaRecorder recorder;

		@Override
		public void onCallStateChanged(int state, String incomingNumber) {

			switch (state) {
			case TelephonyManager.CALL_STATE_IDLE:// ����״̬��û��ͨ��û������
				if (recorder != null) {
					recorder.stop();
					recorder.reset(); // You can reuse the object by going back
										// to setAudioSource() step
					recorder.release();
				}
				break;
			case TelephonyManager.CALL_STATE_RINGING:// ����״̬
				Log.d("TAG", "����������룺" + incomingNumber);

				// 1`��������һ��¼����
				recorder = new MediaRecorder();
				// ����¼�Ƶ���ƵԴ�ӻ�Ͳ�����ȡ����
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
			case TelephonyManager.CALL_STATE_OFFHOOK:// ͨ��״̬
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
