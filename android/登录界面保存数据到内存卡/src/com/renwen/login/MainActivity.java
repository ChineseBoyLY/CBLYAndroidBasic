package com.renwen.login;

import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.renwen.login.service.LoginService;
import com.renwen.logincdcard.R;

public class MainActivity extends Activity {

	private EditText userName;
	private EditText pwd;
	private CheckBox cb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		userName=(EditText)findViewById(R.id.userName);
		pwd=(EditText)findViewById(R.id.pwd);
		cb=(CheckBox)findViewById(R.id.cb);
		
		//检查是否有保存的用户名和密码  回显
		Map<String,String> map=LoginService.getSaveUserInfo(this);
		if(map!=null){
			userName.setText(map.get("uName"));
			pwd.setText(map.get("pwd"));
		}
	}

	public void login(View view){
		String uName=userName.getText().toString().trim();
		String password=pwd.getText().toString().trim();
		
		if(TextUtils.isEmpty(uName)||TextUtils.isEmpty(password)){
			Toast.makeText(this, "用户名或者密码为空", Toast.LENGTH_SHORT).show();
		}else{
			//判断是否保存密码
			if(cb.isChecked()){
				//保存用户名密码
				Log.d("TAG", "需要保存");
				if(LoginService.saveUserInfo(this, uName, password)){
					Toast.makeText(this, "保存用户信息成功", Toast.LENGTH_SHORT).show();
				}
			}
			//登录消息发送到服务器，服务器验证是否正确
			if("tom".equals(uName)&&"123".equals(password)){
				Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
			}
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
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
