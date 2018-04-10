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
			//读取文件流
			FileInputStream fis=openFileInput("test");
			byte[] bytes=new byte[1024];
			int size=-1;
			Book book=null;
			StringBuffer sb=new StringBuffer();
			while((size=fis.read(bytes))!=-1){
				sb.append(new String(bytes));
			}
			Log.d("TAG","结果："+sb.toString());
		}else if(view.getId()==R.id.btnSaveIo){
			//写入文件流  序列化  封装创建文件的过程 
			
			Book book=new Book();
			book.bookid=1;
			book.bookname="基督山伯爵恩仇记";
			
			try {
				FileOutputStream fos=openFileOutput("test",MODE_PRIVATE);
				fos.write((""+book.bookid).getBytes());
				fos.write(book.bookname.getBytes());
				fos.write("大仲马".getBytes());
				fos.write("电子工业出版社".getBytes());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(view.getId()==R.id.btnCheck){
			//检查外部设备是否可用
			//是否可用  可以看到 不一定摸得到
			boolean mExternalStorageAvailable = false; 
			//是否可写
			boolean mExternalStorageWriteable = false; 
			//获得外部设备状态
			String state = Environment.getExternalStorageState(); 
		
			if (Environment.MEDIA_MOUNTED.equals(state)) {     
				// We can read and write the media     
				//我们可以读取和写入外部设备
				mExternalStorageAvailable = mExternalStorageWriteable = true;
			} else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {     
				// We can only read the media 
				//只读
				mExternalStorageAvailable = true;    
				mExternalStorageWriteable = false; 
			} else {
				// Something else is wrong. It may be one of many other states, but all we need     
				//  to know is we can neither read nor write   
				//既不能读也不能写
				mExternalStorageAvailable = mExternalStorageWriteable = false; 
			}
			Log.d("TAG","外部设备状态："+state);
		}else if(view.getId()==R.id.btnWriteEx){
			File file=getExternalFilesDir(null);
			/*String[] names=file.list();
			for (int i = 0; i < names.length; i++) {
				Log.d("TAG",""+names[i]);
			}*/
			//Toast.makeText(this,""+names.length,Toast.LENGTH_LONG).show();
			
			//创建文件
			File fileSb=new File(file.getAbsolutePath()+"asdf");
			
			
			
		}
	}
}
