package com.example.multidownloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	protected static final int DOWN_LOAD_ERROR = 1;
	protected static final int SERVER_ERROR = 2;
	protected static final int DOWN_LOAD_FINISH = 3;
	protected static final int UPDATE_TXT = 4;
	private EditText et;
	private ProgressBar pb;
	private TextView tv;
	public static int threadCount = 3;
	public static int runningThread = 3;
	
	int currentProcess=0;  //��ǰ��¼
	
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case DOWN_LOAD_ERROR:
				Toast.makeText(getApplicationContext(), "����ʧ��", Toast.LENGTH_LONG).show();
				break;
			case SERVER_ERROR:
				Toast.makeText(getApplicationContext(), "������������", Toast.LENGTH_LONG).show();
				break;
			case DOWN_LOAD_FINISH:
				Toast.makeText(getApplicationContext(), "�������", Toast.LENGTH_LONG).show();
				break;
			case UPDATE_TXT:
				tv.setText("��ǰ���ȣ�"+pb.getProgress()*100/pb.getMax());
				break;
			default:
				break;
			}
		};
	};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et=(EditText) findViewById(R.id.et);
		pb=(ProgressBar) findViewById(R.id.progressBar1);
		tv=(TextView) findViewById(R.id.tv);
	}

	public void download(View view){
		final String path = et.getText().toString().trim();
		if(TextUtils.isEmpty(path)){
			Toast.makeText(this, "����·������", Toast.LENGTH_LONG).show();
			return;
		}
		
		new Thread(){
			public void run() {
				// 1`���ӷ���������ȡһ���ļ�����ȡ�ļ��ĳ��ȣ��ڱ��ش���һ����С���������ļ�һ����С����ʱ�ļ�
				try {
					//String path = "http://10.100.51.162:8080/a.mp3";
					URL url = new URL(path);
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setConnectTimeout(5000);
					conn.setRequestMethod("GET");
					int code = conn.getResponseCode();
					if (code == 200) {
						// ���������ص����ݵĳ��� ʵ���Ͼ����ļ��ĳ���
						int length = conn.getContentLength();
						pb.setMax(length);
						
						
						System.out.println("�ļ��ĳ���Ϊ" + length);
						// �ڿͻ��˱��ش�������һ����С�����������ļ�һ������ʱ�ļ�
						RandomAccessFile raf = new RandomAccessFile("/sdcard/a.mp3", "rwd");
						// ָ�������ļ��ĳ���
						raf.setLength(length);
						raf.close();

						// ������3���߳�ȥ������Դ
						// ƽ��ÿһ���߳������ļ��Ĵ�С
						int blockSize = length / threadCount;
						for (int threadId = 1; threadId <= threadCount; threadId++) {
							// ��һ���̵߳Ŀ�ʼλ��
							int startIndex = (threadId - 1) * blockSize;
							int endIndex = threadId * blockSize - 1;

							if (threadId == threadCount) {// ���һ���߳����صĳ���Ҫ��һ��
								endIndex = length;
							}
							System.out.println("�̣߳�" + threadId + "���أ�---" + startIndex
									+ "----" + endIndex);
							new DownloadThread(threadId, startIndex, endIndex, path)
									.start();
						}

					} else {
						System.out.println("������������");
						Message msg = new Message();
						msg.what=SERVER_ERROR;
						handler.sendMessage(msg);
					}
				} catch (Exception e) {
					e.printStackTrace();
					Message msg = new Message();
					msg.what=DOWN_LOAD_ERROR;
					handler.sendMessage(msg);
				}
			};
		}.start();
	}
	
	/**
	 * �����ļ������߳� ÿһ���߳����ض�Ӧλ�õ��ļ�
	 * 
	 * @author Administrator
	 * 
	 */
	public class DownloadThread extends Thread {
		
		
		private int threadId;
		private int startIndex;
		private int endIndex;
		private String path;

		public DownloadThread(int threadId, int startIndex, int endIndex,
				String path) {
			super();
			this.threadId = threadId;
			this.startIndex = startIndex;
			this.endIndex = endIndex;
			this.path = path;
		}

		@Override
		public void run() {
			try {
				// ����Ƿ���ڼ�¼���س��ȵ��ļ���������� ����ȡ����ļ�������
				//----------------�滻�����ݿ�-------------------------
				File tempFile = new File("/sdcard/"+threadId + ".txt");
				if (tempFile.exists() && tempFile.length() > 0) {
					FileInputStream fis = new FileInputStream(tempFile);
					byte[] temp = new byte[1024];
					int leng = fis.read(temp);
					String downloadLen = new String(temp, 0, leng);
					int downloadLenInt = Integer.parseInt(downloadLen);
					int alreadyDownlodInt = downloadLenInt-startIndex;
					currentProcess+=alreadyDownlodInt;//������һ���Ѿ����صĶϵ�
					startIndex = downloadLenInt;// �޸����ص���ʵ�Ŀ�ʼλ��
					fis.close();
				}
				//---------------------------------------------------

				URL url = new URL(path);
				HttpURLConnection conn = (HttpURLConnection) url
						.openConnection();
				conn.setConnectTimeout(5000);
				conn.setRequestMethod("GET");
				// ��Ҫ��������������ز��ֵ��ļ�ָ���ļ���λ��
				conn.setRequestProperty("Range", "bytes=" + startIndex + "-"
						+ endIndex);
				System.out.println("�߳���ʵ���أ�" + threadId + "���أ�***" + startIndex
						+ "***" + endIndex);
				int code = conn.getResponseCode();// �ӷ���������ȫ����Դ200 ok �����󲿷���Դ
													// 206ok
				System.out.println("code:" + code);
				if (code == 206) {
					InputStream is = conn.getInputStream();// ���ص�ǰλ�ö�Ӧ���ļ���������
					RandomAccessFile raf = new RandomAccessFile("/sdcard/a.mp3", "rwd");
					// ���д�ļ���ʱ���Ǵ����￪ʼд
					raf.seek(startIndex);// ��λ�ļ�
					int len = 0;
					byte[] buffer = new byte[1024];
					int total = 0;// �Ѿ��������ݵĳ���
					while ((len = is.read(buffer)) != -1) {
						RandomAccessFile info = new RandomAccessFile("/sdcard/"+threadId
								+ ".txt", "rwd");// ��¼��ǰ���ؽ���
						raf.write(buffer, 0, len);
						total += len;
						info.write((total+startIndex+"").getBytes());//��¼�������ص�λ��
						info.close();
						
						synchronized (MainActivity.this) {
							currentProcess+=len;
							pb.setProgress(currentProcess);
//						�������progressbar �� progressdialog����������ֱ�������߳��������UI���ڲ������Ѿ�������ˣ�
							
							Message msg = Message.obtain();//��Ϣ��
							msg.what=UPDATE_TXT;
							handler.sendMessage(msg);
						}
						
					}
					is.close();
					raf.close();
					System.out.println("�̣߳�" + threadId + "���������...");
				}else{
					System.out.println("�̣߳�" + threadId + "����ʧ����...");
				}
	
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				
				threadFinish();
			}
		}

		private synchronized void threadFinish() {
			runningThread--;
			if(runningThread==0){//�����߳��Ѿ�ִ�������
				for(int i=1;i<=3;i++){
					File file = new File("/sdcard/"+i+".txt");
					file.delete();
				}
				System.out.println("�ļ�������ϣ�ɾ����¼�ļ�");
				Message msg = new Message();
				msg.what=DOWN_LOAD_FINISH;
				handler.sendMessage(msg);
			}
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
