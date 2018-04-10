package com.supermario.filemanager;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
//�ı��༭��
public class EditTxtActivity extends Activity implements OnClickListener{
	//��ʾ�򿪵��ı�����
	private EditText txtEditText;
	//��ʾ�򿪵��ļ���
	private TextView txtTextTitle;
	//���水ť
	private Button txtSaveButton;
	//ȡ����ť
	private Button txtCancleButton;
	private String txtTitle;
	private String txtData;
	private String txtPath;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_txt);
		//��ʼ������
		initContentView();
		//����ļ�·��
		txtPath = getIntent().getStringExtra("path");
		//����ļ���
		txtTitle = getIntent().getStringExtra("title");
		//����ı�����
		txtData = getIntent().getStringExtra("data");
		try {
			txtData = new String(txtData.getBytes("ISO-8859-1"),"UTF-8");//ת��
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		txtTextTitle.setText(txtTitle);
		txtEditText.setText(txtData);
	}
	/**�����ʼ��*/
	private void initContentView(){
		txtEditText = (EditText)findViewById(R.id.EditTextDetail);
		txtTextTitle = (TextView)findViewById(R.id.TextViewTitle);
		txtSaveButton = (Button)findViewById(R.id.ButtonRefer);
		txtCancleButton = (Button)findViewById(R.id.ButtonBack);
		//���ñ��水ť������
		txtSaveButton.setOnClickListener(this);
		//����ȡ����ť������
		txtCancleButton.setOnClickListener(this);
	}
	/**����¼�����*/
	public void onClick(View view) {
		if(view.getId() == txtSaveButton.getId()){
			//����
			saveTxt();
		}else if(view.getId() == txtCancleButton.getId()){
			EditTxtActivity.this.finish();
		}
	}
	/**����༭����ı���Ϣ*/
	private void saveTxt(){
		try {
			//ȡ�ñ༭������
			String newData = txtEditText.getText().toString();
			BufferedWriter mBW = new BufferedWriter(new FileWriter(new File(txtPath)));
			//д���ļ�
			mBW.write(newData,0,newData.length());
			mBW.newLine();
			mBW.close();
			//��ʾ
			Toast.makeText(EditTxtActivity.this, "�ɹ�����!", Toast.LENGTH_SHORT).show();
		} catch (IOException e) {
			Toast.makeText(EditTxtActivity.this, "�洢�ļ�ʱ�������쳣!", Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		}
		this.finish();
	}
}
