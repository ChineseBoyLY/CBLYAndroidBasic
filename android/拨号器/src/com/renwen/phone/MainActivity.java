package com.renwen.phone;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private EditText mobileText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mobileText = (EditText) findViewById(R.id.mobile);
		Button button = (Button) this.findViewById(R.id.button);
//		��������implements OnClickListener
		button.setOnClickListener(this);
		
//		����һ���ڲ���
		/*button.setOnClickListener(new ButtonClickListen());
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				callPhone();
			}
		});*/
	}
	
//	����������xml�ж���
	public void btnClick(View view){
		callPhone();
	}
	
	/*
	 * �����ģ�
	 *
	 *Ϊʲô�����⽨��һ�����ļ��أ�
	 *		�ڼ��ص��������ʱ���ٶȻؿ�Щ�� 
	 */
	/*public final class ButtonClickListen implements View.OnClickListener {
		public void onClick(View v) {
			callPhone();
		}
	}*/

	private void callPhone() {
		String number = mobileText.getText().toString();
		if(TextUtils.isEmpty(number)){
			Toast.makeText(MainActivity.this, "���벻��Ϊ��", Toast.LENGTH_SHORT).show();
			return ;
		}
		//��ͼ
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_CALL);
		//uriͳһ��Դ��λ��
		intent.setData(Uri.parse("tel:"+ number));
		startActivity(intent);//�����ڲ����Զ�ΪIntent������android.intent.category.DEFAULT
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

	@Override
	public void onClick(View v) {
		switch(v.getId()){
			case R.id.button:
				callPhone();break;
		}
	}
}
