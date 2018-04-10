package com.renwen.login;

import java.util.Map;

import com.renwen.login.service.LoginService;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText userName;
	private EditText pwd;
	private CheckBox cb;
	private RadioGroup rg_mode;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		userName=(EditText)findViewById(R.id.userName);
		pwd=(EditText)findViewById(R.id.pwd);
		cb=(CheckBox)findViewById(R.id.cb);
		rg_mode=(RadioGroup)findViewById(R.id.rg_mode);
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
				boolean result=false;
				Log.d("TAG", "��Ҫ����");
				int id = rg_mode.getCheckedRadioButtonId();
				
				switch(id){
				case R.id.rd_private:
					result=LoginService.saveUserInfo(this, uName, password, 1);
					break;
				case R.id.rd_read:
					result=LoginService.saveUserInfo(this, uName, password, 2);
					break;
				case R.id.rd_write:
					result=LoginService.saveUserInfo(this, uName, password, 3);
					break;
				case R.id.rd_public:
					result=LoginService.saveUserInfo(this, uName, password, 4);
					break;
				}
				
				if(result){
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
