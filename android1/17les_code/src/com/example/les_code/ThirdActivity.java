package com.example.les_code;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class ThirdActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);

	}

	public void btnClick(View view){
		//�˳�Ӧ�� ���ٶ�ջ�������н���
		app.exit();
		//finishActivity(app.result_exit_ok);
//		setResult(app.result_exit_ok);
//		finish();
	}
}
