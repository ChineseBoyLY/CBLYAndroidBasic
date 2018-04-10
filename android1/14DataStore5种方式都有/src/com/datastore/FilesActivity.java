package com.datastore;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FilesActivity extends Activity implements OnClickListener {

	private EditText mEditText1, mEditText2;
	private Button returnhome, submit;
	private TextView mTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.share_preferences);
		initControl();
		toShow();
	}

	/* ��ʼ�� */
	private void initControl() {
		returnhome = (Button) this.findViewById(R.id.returnhome);
		returnhome.setOnClickListener(this);

		mEditText1 = (EditText) this.findViewById(R.id.username);
		mEditText2 = (EditText) this.findViewById(R.id.password);
		mTextView = (TextView) this.findViewById(R.id.toshow);

		submit = (Button) this.findViewById(R.id.submit);
		submit.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.returnhome:
			super.finish();
			break;
		case R.id.submit:
			toSave();
			toShow();
			break;
		}
	}

	/* �������� */
	private void toSave() {
		String name = mEditText1.getText().toString().trim();
		String pswd = mEditText2.getText().toString().trim();
		Properties properties = new Properties();
		properties.put("name", name);
		properties.put("pswd", pswd);
		try {
			/* д���ļ� */
			FileOutputStream stream = this.openFileOutput("info.cfg",
					Context.MODE_WORLD_WRITEABLE);
			properties.store(stream, "");
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}

	/* ҳ����ʾ */
	private void toShow() {
		Map<String, String> map = getDate();
		mEditText1.setText(map.get("name"));
		mEditText2.setText(map.get("pswd"));
		String text = "�û�����" + map.get("name") + "\n";
		text += "���룺" + map.get("pswd") + "\n";
		mTextView.setText(text);
	}

	/* ��ȡ���� */
	private Map<String, String> getDate() {
		Map<String, String> map = new HashMap<String, String>();
		String name = "";
		String pswd = "";
		Properties properties = new Properties();
		try {
			/* ���ļ� */
			FileInputStream stream = this.openFileInput("info.cfg");
			/* ��ȡ�ļ����� */
			properties.load(stream);
			name = properties.get("name").toString();
			pswd = properties.get("pswd").toString();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		map.put("name", name);
		map.put("pswd", pswd);
		return map;
	}

}
