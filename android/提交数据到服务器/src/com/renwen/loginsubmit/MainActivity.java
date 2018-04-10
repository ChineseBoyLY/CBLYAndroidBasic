package com.renwen.loginsubmit;

import org.apache.http.Header;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.renwen.loginsubmit.service.LoginService;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 1`����������Ȩ��
 * 			<uses-permission android:name="android.permission.INTERNET"/>
 * 2�����´���
 * 
 * 3������˴��룺��ȡusername��password�����жϣ�Ȼ��������Ӧ
 * 			 response.getOutputStream().write("login success".getBytes());
 * 			 response.getOutputStream().write("login failed".getBytes());
 * 
 * 4��������Ϳ���дһ����Ʊ��������ɱ����
 * 
 * @author Administrator
 *
 */

public class MainActivity extends Activity {

	EditText username;
	EditText password;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		username=(EditText) findViewById(R.id.username);
		password=(EditText) findViewById(R.id.password);
	}

	public void click(View view){
		final String uname=username.getText().toString().trim();
		final String pwd=password.getText().toString().trim();
		
		//�ύ���ݵ�������
		//ƴװ·��(����дlocalhost)
		new Thread(){
			public void run() {
				final String result = LoginService.loginByGet(uname, pwd);
				if(result!=null){
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
						}
					});
				}else{
					//��¼ʧ��
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							Toast.makeText(MainActivity.this, "����ʧ��", Toast.LENGTH_SHORT).show();
						}
					});
				}
			};
		}.start();
	}
	
	public void click2(View view){
		final String uname=username.getText().toString().trim();
		final String pwd=password.getText().toString().trim();
		
		//�ύ���ݵ�������
		//ƴװ·��(����дlocalhost)
		new Thread(){
			public void run() {
				final String result = LoginService.loginByPost(uname, pwd);
				if(result!=null){
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
						}
					});
				}else{
					//��¼ʧ��
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							Toast.makeText(MainActivity.this, "����ʧ��", Toast.LENGTH_SHORT).show();
						}
					});
				}
			};
		}.start();
	}
	
	public void click5(View view){
		final String uname=username.getText().toString().trim();
		final String pwd=password.getText().toString().trim();
		String url = "http://192.168.1.100:8080/web/LoginServlet";
		AsyncHttpClient client = new AsyncHttpClient();
		RequestParams params = new RequestParams();
		params.put("username", uname);
		params.put("password", pwd);
		client.post(url, params, new AsyncHttpResponseHandler() {
			
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
				Toast.makeText(MainActivity.this, arg2.toString(), 0).show();
			}
			
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
				Toast.makeText(MainActivity.this, arg2.toString(), 0).show();
			}
		});
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
