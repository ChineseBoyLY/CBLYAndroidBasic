package com.example.sendMsg;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private EditText numberText;
	private EditText contentText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		numberText = (EditText) this.findViewById(R.id.number);
		contentText = (EditText) this.findViewById(R.id.content);
		Button button = (Button) this.findViewById(R.id.button);
		button.setOnClickListener(this);
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
		String number = numberText.getText().toString().trim();
		String content = contentText.getText().toString().trim();
		if (TextUtils.isEmpty(number) || TextUtils.isEmpty(content)) {
			Toast.makeText(this, "号码或者短信内容不能为空", Toast.LENGTH_SHORT).show();
			return;
		} else {   
			SmsManager manager = SmsManager.getDefault();
			ArrayList<String> texts = manager.divideMessage(content);
			for (String string : texts) {
				manager.sendTextMessage(number, null, string, null, null);// 后面俩个为短信的发送状态和短信的接收状态
			}
			Toast.makeText(getApplicationContext(), R.string.success, Toast.LENGTH_LONG).show();
		}
	}
}
