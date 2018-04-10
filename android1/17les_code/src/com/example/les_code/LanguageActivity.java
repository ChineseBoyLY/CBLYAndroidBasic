package com.example.les_code;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class LanguageActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_language);
//		��MainActivity������ֵ
		Intent intent=getIntent();
		Log.d("TAG", intent.getStringExtra("name"));
	}
	
//	@Override
//	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//		if(requestCode==1){
//			if(resultCode==app.result_exit_ok){
//				setResult(app.result_exit_ok);
//				finish();
//			}
//		}
//	}
	
	public void btnClick(View view){
		if(view.getId()==R.id.success){
			//���óɹ�
			Intent intent=new Intent();
			intent.putExtra("id", "�������Գɹ�");
			setResult(3,intent);
			finish();
		}else if(view.getId()==R.id.failed){
			//����ʧ��
			Intent intent=new Intent();
			intent.putExtra("id", "�������Բ��ɹ�");
			setResult(3,intent);
			finish();
		}else if(view.getId()==R.id.btnCurrentExit){
			System.exit(0);//ֻ��ѵ�ǰ��������
		}else if(view.getId()==R.id.btnthird){
//			��������������
			Intent intent=new Intent();
			intent.setClass(this,ThirdActivity.class);
			startActivityForResult(intent, 2);
		}
	}
}
