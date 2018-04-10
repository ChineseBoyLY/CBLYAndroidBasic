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
	
	int currentProcess=0;  //当前记录
	
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case DOWN_LOAD_ERROR:
				Toast.makeText(getApplicationContext(), "下载失败", Toast.LENGTH_LONG).show();
				break;
			case SERVER_ERROR:
				Toast.makeText(getApplicationContext(), "服务器出错了", Toast.LENGTH_LONG).show();
				break;
			case DOWN_LOAD_FINISH:
				Toast.makeText(getApplicationContext(), "下载完毕", Toast.LENGTH_LONG).show();
				break;
			case UPDATE_TXT:
				tv.setText("当前进度："+pb.getProgress()*100/pb.getMax());
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
			Toast.makeText(this, "下载路径错误", Toast.LENGTH_LONG).show();
			return;
		}
		
		new Thread(){
			public void run() {
				// 1`连接服务器，获取一个文件，获取文件的长度，在本地创建一个大小跟服务器文件一样大小的临时文件
				try {
					//String path = "http://10.100.51.162:8080/a.mp3";
					URL url = new URL(path);
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setConnectTimeout(5000);
					conn.setRequestMethod("GET");
					int code = conn.getResponseCode();
					if (code == 200) {
						// 服务器返回的数据的长度 实际上就是文件的长度
						int length = conn.getContentLength();
						pb.setMax(length);
						
						
						System.out.println("文件的长度为" + length);
						// 在客户端本地创建出来一个大小跟服务器端文件一样的临时文件
						RandomAccessFile raf = new RandomAccessFile("/sdcard/a.mp3", "rwd");
						// 指定创建文件的长度
						raf.setLength(length);
						raf.close();

						// 假设是3个线程去下载资源
						// 平均每一个线程下载文件的大小
						int blockSize = length / threadCount;
						for (int threadId = 1; threadId <= threadCount; threadId++) {
							// 第一个线程的开始位置
							int startIndex = (threadId - 1) * blockSize;
							int endIndex = threadId * blockSize - 1;

							if (threadId == threadCount) {// 最后一个线程下载的长度要长一点
								endIndex = length;
							}
							System.out.println("线程：" + threadId + "下载：---" + startIndex
									+ "----" + endIndex);
							new DownloadThread(threadId, startIndex, endIndex, path)
									.start();
						}

					} else {
						System.out.println("服务器出错了");
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
	 * 下载文件的子线程 每一个线程下载对应位置的文件
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
				// 检查是否存在记录下载长度的文件，如果存在 ，读取这个文件的数据
				//----------------替换成数据库-------------------------
				File tempFile = new File("/sdcard/"+threadId + ".txt");
				if (tempFile.exists() && tempFile.length() > 0) {
					FileInputStream fis = new FileInputStream(tempFile);
					byte[] temp = new byte[1024];
					int leng = fis.read(temp);
					String downloadLen = new String(temp, 0, leng);
					int downloadLenInt = Integer.parseInt(downloadLen);
					int alreadyDownlodInt = downloadLenInt-startIndex;
					currentProcess+=alreadyDownlodInt;//计算上一次已经下载的断电
					startIndex = downloadLenInt;// 修改下载的真实的开始位置
					fis.close();
				}
				//---------------------------------------------------

				URL url = new URL(path);
				HttpURLConnection conn = (HttpURLConnection) url
						.openConnection();
				conn.setConnectTimeout(5000);
				conn.setRequestMethod("GET");
				// 重要：请求服务器下载部分的文件指定文件的位置
				conn.setRequestProperty("Range", "bytes=" + startIndex + "-"
						+ endIndex);
				System.out.println("线程真实下载：" + threadId + "下载：***" + startIndex
						+ "***" + endIndex);
				int code = conn.getResponseCode();// 从服务器请求全部资源200 ok ；请求部分资源
													// 206ok
				System.out.println("code:" + code);
				if (code == 206) {
					InputStream is = conn.getInputStream();// 返回当前位置对应的文件的输入流
					RandomAccessFile raf = new RandomAccessFile("/sdcard/a.mp3", "rwd");
					// 随机写文件的时候是从哪里开始写
					raf.seek(startIndex);// 定位文件
					int len = 0;
					byte[] buffer = new byte[1024];
					int total = 0;// 已经下载数据的长度
					while ((len = is.read(buffer)) != -1) {
						RandomAccessFile info = new RandomAccessFile("/sdcard/"+threadId
								+ ".txt", "rwd");// 记录当前下载进度
						raf.write(buffer, 0, len);
						total += len;
						info.write((total+startIndex+"").getBytes());//记录的是下载的位置
						info.close();
						
						synchronized (MainActivity.this) {
							currentProcess+=len;
							pb.setProgress(currentProcess);
//						特殊情况progressbar 和 progressdialog进度条可以直接在子线程里面更新UI（内部代码已经处理好了）
							
							Message msg = Message.obtain();//消息池
							msg.what=UPDATE_TXT;
							handler.sendMessage(msg);
						}
						
					}
					is.close();
					raf.close();
					System.out.println("线程：" + threadId + "下载完毕了...");
				}else{
					System.out.println("线程：" + threadId + "下载失败了...");
				}
	
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				
				threadFinish();
			}
		}

		private synchronized void threadFinish() {
			runningThread--;
			if(runningThread==0){//所有线程已经执行完毕了
				for(int i=1;i<=3;i++){
					File file = new File("/sdcard/"+i+".txt");
					file.delete();
				}
				System.out.println("文件下载完毕，删除记录文件");
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
