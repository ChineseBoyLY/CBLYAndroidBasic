package com.example.les_data2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

public class IoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_io);
	}

	public void btnClick(View view) throws IOException{
		if(view.getId()==R.id.btnReadIo){
			//��ȡ�ļ���
			FileInputStream fis=openFileInput("test");
			byte[] bytes=new byte[1024];
			int size=-1;
			Book book=null;
			StringBuffer sb=new StringBuffer();
			while((size=fis.read(bytes))!=-1){
				sb.append(new String(bytes));
			}
			Log.d("TAG","�����"+sb.toString());
		}else if(view.getId()==R.id.btnSaveIo){
			//д���ļ���  ���л�  ��װ�����ļ��Ĺ��� 
			
			Book book=new Book();
			book.bookid=1;
			book.bookname="����ɽ���������";
			
			try {
				FileOutputStream fos=openFileOutput("test",MODE_PRIVATE);
				fos.write((""+book.bookid).getBytes());
				fos.write(book.bookname.getBytes());
				fos.write("������".getBytes());
				fos.write("���ӹ�ҵ������".getBytes());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(view.getId()==R.id.btnCheck){
			//����ⲿ�豸�Ƿ����
			//�Ƿ����  ���Կ��� ��һ�����õ�
			boolean mExternalStorageAvailable = false; 
			//�Ƿ��д
			boolean mExternalStorageWriteable = false; 
			//����ⲿ�豸״̬
			String state = Environment.getExternalStorageState(); 
		
			if (Environment.MEDIA_MOUNTED.equals(state)) {     
				// We can read and write the media     
				//���ǿ��Զ�ȡ��д���ⲿ�豸
				mExternalStorageAvailable = mExternalStorageWriteable = true;
			} else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {     
				// We can only read the media 
				//ֻ��
				mExternalStorageAvailable = true;    
				mExternalStorageWriteable = false; 
			} else {
				// Something else is wrong. It may be one of many other states, but all we need     
				//  to know is we can neither read nor write   
				//�Ȳ��ܶ�Ҳ����д
				mExternalStorageAvailable = mExternalStorageWriteable = false; 
			}
			Log.d("TAG","�ⲿ�豸״̬��"+state);
		}else if(view.getId()==R.id.btnWriteEx){
			File file=getExternalFilesDir(null);
			/*String[] names=file.list();
			for (int i = 0; i < names.length; i++) {
				Log.d("TAG",""+names[i]);
			}*/
			//Toast.makeText(this,""+names.length,Toast.LENGTH_LONG).show();
			
			//�����ļ�
			File fileSb=new File(file.getAbsolutePath()+"asdf");
			
			
			
		}
	}
}
