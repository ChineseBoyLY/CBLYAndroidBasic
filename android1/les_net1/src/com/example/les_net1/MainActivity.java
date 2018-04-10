package com.example.les_net1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

/**
 * ���� 1��socket 2��httpClient jsp �ͻ��˶��� ���������� get post 3��httpUrlConnection
 * 4�����ݽ�����ʽ json xml
 * 
 * ��·���Ӵ��벻�ܷŵ����߳����棬�����������Ĭ��Ϊһ�ֺ�ʱ������� service ���ܿ������߳�
 * 
 * ����һ���߳� �����һ���߳�
 * 
 * ��ҵ��ʵ�� ������ �ͻ�������
 * 
 * 
 * @author kulv16
 * 
 */
public class MainActivity extends Activity {

	SocketThread socketThread;
	HttpClientThread clientThread;
	PostThread postThread;
	HttpUrlThread urlThread;
	DownloadThread dthread;
	ImageView img;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		img = (ImageView) findViewById(R.id.img);
		dthread = new DownloadThread();
		dthread.start();
	}

	class DownloadThread extends Thread {
		@Override
		public void run() {
			URL url = null;
			HttpURLConnection conn = null;
			try {
				url = new URL("http://19.0.0.108:8080/dataServer/s3.jpg");
				conn = (HttpURLConnection) url.openConnection();
				// �������ӳ�ʱ
				conn.setConnectTimeout(6000);
				InputStream is = conn.getInputStream();
				Bitmap bitmap = BitmapFactory.decodeStream(is);
				img.setImageBitmap(bitmap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Log.d("TAG", "���ӳ�ʱ");
			}
		}
	}

	public void btnClick(View view) {
		if (view.getId() == R.id.btn1) {
			socketThread = new SocketThread();
			socketThread.start();
		} else if (view.getId() == R.id.btn2) {
			clientThread = new HttpClientThread();
			clientThread.start();
		} else if (view.getId() == R.id.btn3) {
			postThread = new PostThread();
			postThread.start();
		} else if (view.getId() == R.id.btn4) {
			urlThread = new HttpUrlThread();
			urlThread.start();
		}
	}

	class HttpUrlThread extends Thread {
		@Override
		public void run() {
			URL url = null;
			HttpURLConnection conn = null;
			try {
				url = new URL(
						"http://19.0.0.108:8080/myservlet/servlet/MyServlet?");
				// �����Ӳ������ӷ�����
				conn = (HttpURLConnection) url.openConnection();
				// ���ֵĬ��false������ӿͻ��˷��Ͳ�����������
				conn.setDoOutput(true);

				// �������ӷ�ʽ
				conn.setRequestMethod("POST");
				// ���������
				InputStream is = conn.getInputStream();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	class PostThread extends Thread {
		@Override
		public void run() {
			// �ͻ��˶���
			HttpClient client = new DefaultHttpClient();
			// ��������
			HttpPost post = new HttpPost(
					"http://19.0.0.108:8080/myservlet/servlet/MyServlet");
			// ����post����
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			list.add(new BasicNameValuePair("name", "kakaxi"));
			list.add(new BasicNameValuePair("pwd", "123"));

			try {
				post.setEntity(new UrlEncodedFormEntity(list, HTTP.UTF_8));
				HttpResponse response = client.execute(post);
				InputStream is = response.getEntity().getContent();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	class HttpClientThread extends Thread {
		@Override
		public void run() {
			// �ͻ��˶���
			HttpClient client = new DefaultHttpClient();
			// ��������
			HttpGet get = new HttpGet(
					"http://19.0.0.108:8080/myservlet/servlet/MyServlet?name=kakaxi&pwd=123");
			InputStream is = null;
			try {
				// ִ������
				HttpResponse response = client.execute(get);
				// ������������Ӧ���� 400 500 300 200
				if (response.getStatusLine().getStatusCode() == 200) {
					// ������Ӧ
					is = response.getEntity().getContent();
					InputStreamReader isr = new InputStreamReader(is);
					char[] buf = new char[1024];
					int size = -1;
					StringBuffer sb = new StringBuffer();
					while ((size = isr.read(buf)) != -1) {
						sb.append(buf, 0, size);
					}
					Log.d("TAG", "httpClient������Ӧ�����" + sb.toString());
				}

			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	class SocketThread extends Thread {
		BufferedReader reader;
		@Override
		public void run() {
			try {
				Socket socket = new Socket("10.100.51.99", 8888);
				// ����
				OutputStream out = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");
				PrintWriter pw = new PrintWriter(osw);
				pw.write("�������Կͻ��˵�huiying");

//				pw.close();
//				osw.close();
//				out.close();

				// ����
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "utf-8");
				reader = new BufferedReader(isr);
				new Thread(new Runnable() {
					@Override
					public void run() {
						while (true) {
							try {
								Log.d("TAG", "" + reader.readLine());
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}).start();

//				reader.close();
//				isr.close();
//				is.close();
//				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
