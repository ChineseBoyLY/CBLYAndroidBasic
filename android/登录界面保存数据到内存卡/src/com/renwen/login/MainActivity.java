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
		
		//����Ƿ��б�����û���������  ����
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
			Toast.makeText(this, "�û�����������Ϊ��", Toast.LENGTH_SHORT).show();
		}else{
			//�ж��Ƿ񱣴�����
			if(cb.isChecked()){
				//�����û�������
				Log.d("TAG", "��Ҫ����");
				if(LoginService.saveUserInfo(this, uName, password)){
					Toast.makeText(this, "�����û���Ϣ�ɹ�", Toast.LENGTH_SHORT).show();
				}
			}
			//��¼��Ϣ���͵�����������������֤�Ƿ���ȷ
			if("tom".equals(uName)&&"123".equals(password)){
				Toast.makeText(this, "��¼�ɹ�", Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(this, "��¼ʧ��", Toast.LENGTH_SHORT).show();
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
