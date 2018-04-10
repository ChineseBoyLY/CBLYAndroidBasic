package com.example.les6_ui3;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * button ����������� 
 * 1�����������ڲ���
 * 2��xml���ü�������
 * ImageView fitxy ���ᱣ֤ͼƬ��ԭʼ���� centerCorp����ͼƬ��ԭʼ����
 * EditText  ���� inputTYpe
 * TextView  �ı��� ��Ӱ shadow SpanString �����ӵ��ı��� ����HTML��ǩ
 * 
 * �������  ��ѡ�� ��ѡ�� ������
 * 1��ģ��������
 * 	ȦȦ
 * 	ˮƽ
 * 2����ȷ������
 * drawable ״̬��Դ 
 * shape �����Դ
 * --������Դ
 * ��ʽ �����Դ
 * dimens.xml �ߴ���Դ
 * styles.xml ��ʽ��Դ
 * 
 * @author Administrator
 *
 */
public class MainActivity extends Activity {
	EditText nameEt;
	EditText pwdEt;
	RadioButton maleRb;
	RadioButton femaleRb;
	CheckBox fireCb;
	CheckBox waterCb;
	CheckBox sandCb;
	ProgressBar progressBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		nameEt=(EditText)findViewById(R.id.nameEt);
		pwdEt=(EditText)findViewById(R.id.pwdEt);
		maleRb=(RadioButton)findViewById(R.id.maleRb);
		femaleRb=(RadioButton)findViewById(R.id.femaleRb);
		fireCb=(CheckBox)findViewById(R.id.fireCb);
		waterCb=(CheckBox)findViewById(R.id.waterCb);
		sandCb=(CheckBox)findViewById(R.id.sandCb);
		progressBar=(ProgressBar)findViewById(R.id.progressBar);
	
	}

	public void btnClick(View view){
		if(view.getId()==R.id.regBtn){
			StringBuilder sb=new StringBuilder();
			sb.append(nameEt.getText().toString()+pwdEt.getText().toString());
			if(maleRb.isChecked()){
				sb.append(",�Ա���");
			}else{
				sb.append("���Ա�Ů");
			}
			
			if(fireCb.isChecked()){
				sb.append("����Ӱ");
			}
			if(waterCb.isChecked()){
				sb.append("��ˮӰ");
			}
			if(sandCb.isChecked()){
				sb.append("��ɳӰ");
			}
			Toast.makeText(this,sb.toString(),Toast.LENGTH_LONG).show();
		}
	}
}
