package com.datastore;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharePreferencesActivity extends Activity implements
		OnClickListener {

	private EditText mEditText1, mEditText2;
	private Button returnhome, submit;
	private TextView mTextView, explain;

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

		String text = "ʵ��SharedPreferences�洢�Ĳ������£�\n";
		text += "һ������Context��ȡSharedPreferences����\n";
		text += "��������edit()������ȡEditor����\n";
		text += "����ͨ��Editor����洢key-value��ֵ�����ݡ�\n";
		text += "�ġ�ͨ��commit()�����ύ���ݡ�\n";
		explain = (TextView) this.findViewById(R.id.explain);
		explain.setText(text);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
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

		/* ��û��Preferences���� */
		SharedPreferences setting = getPreferences(Activity.MODE_PRIVATE);
		/* ����ʱҪȡ�ñ༭���� */
		SharedPreferences.Editor editor = setting.edit();
		/* �����-ֵ */
		editor.putString("name", name);
		editor.putString("pswd", pswd);
		/* �������ύ���� */
		editor.commit();
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
		SharedPreferences setting = getPreferences(Activity.MODE_PRIVATE);
		map.put("name", setting.getString("name", ""));
		map.put("pswd", setting.getString("pswd", ""));
		return map;
	}
}
