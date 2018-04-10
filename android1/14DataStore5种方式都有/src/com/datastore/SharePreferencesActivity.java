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

	/* 初始化 */
	private void initControl() {
		returnhome = (Button) this.findViewById(R.id.returnhome);
		returnhome.setOnClickListener(this);

		mEditText1 = (EditText) this.findViewById(R.id.username);
		mEditText2 = (EditText) this.findViewById(R.id.password);
		mTextView = (TextView) this.findViewById(R.id.toshow);

		submit = (Button) this.findViewById(R.id.submit);
		submit.setOnClickListener(this);

		String text = "实现SharedPreferences存储的步骤如下：\n";
		text += "一、根据Context获取SharedPreferences对象。\n";
		text += "二、利用edit()方法获取Editor对象。\n";
		text += "三、通过Editor对象存储key-value键值对数据。\n";
		text += "四、通过commit()方法提交数据。\n";
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

	/* 保存数据 */
	private void toSave() {
		String name = mEditText1.getText().toString().trim();
		String pswd = mEditText2.getText().toString().trim();

		/* 获得活动的Preferences对象 */
		SharedPreferences setting = getPreferences(Activity.MODE_PRIVATE);
		/* 保存时要取得编辑对象 */
		SharedPreferences.Editor editor = setting.edit();
		/* 赋予键-值 */
		editor.putString("name", name);
		editor.putString("pswd", pswd);
		/* 别忘记提交保存 */
		editor.commit();
	}

	/* 页面显示 */
	private void toShow() {
		Map<String, String> map = getDate();
		mEditText1.setText(map.get("name"));
		mEditText2.setText(map.get("pswd"));
		String text = "用户名：" + map.get("name") + "\n";
		text += "密码：" + map.get("pswd") + "\n";
		mTextView.setText(text);
	}

	/* 获取数据 */
	private Map<String, String> getDate() {
		Map<String, String> map = new HashMap<String, String>();
		SharedPreferences setting = getPreferences(Activity.MODE_PRIVATE);
		map.put("name", setting.getString("name", ""));
		map.put("pswd", setting.getString("pswd", ""));
		return map;
	}
}
