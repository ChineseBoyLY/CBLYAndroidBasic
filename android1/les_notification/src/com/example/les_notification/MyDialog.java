package com.example.les_notification;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MyDialog extends Dialog {
	Context ctx;
	Button testBtn;
	Button cancleBtn;
	public MyDialog(Context ctx) {
		// TODO Auto-generated constructor stub
		super(ctx);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// ��ʼ�� ������ͼ
		super.onCreate(savedInstanceState);
		//ȥ������
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dialog_layout);
		testBtn=(Button)findViewById(R.id.dialogBtn);
		cancleBtn=(Button)findViewById(R.id.dialogCancleBtn);
		testBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.d("TAG","ASDF");
			}
		});
		cancleBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// ��ʧ�Ի���
				MyDialog.this.dismiss();
			}
		});
	}
	
	/*public void btnClick(View view){
		if(view.getId()==R.id.dialogBtn){
			Log.d("TAG","ȷ��");
		}
	}*/
	
}
