package com.example.les_files;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * �ļ������
 * �α������� sqlite����
 * @author kulv16
 *
 */
public class MainActivity extends Activity {

	//��Ŀ¼
	File root;
	//�ļ�Ŀ¼
	ListView lv;
	
	//��Ŀ¼�ļ����󼯺�
	List<File> currentList=new ArrayList<File>();
	
	//�ļ�������
	FileAdapter adapter;
	
	//��ǰѡ���Ŀ¼
	File currentFile;
	
	//��ջ ���������ļ��򿪵�·��
	Stack<File> stack=new Stack<File>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv=(ListView)findViewById(R.id.lv);
		
		
		
		//��ø�Ŀ¼���ļ�����
		root=new File("mnt/sdcard");
		
		//ѹ���Ŀ¼
		stack.push(root);
		
		//�г���Ŀ¼���������ļ����ļ���
		File[] files=((File)stack.lastElement()).listFiles();
		//�Ѹ�Ŀ¼����������ļ��ŵ�list
		for (int i = 0; i < files.length; i++) {
			currentList.add(files[i]);
		}
		adapter=new FileAdapter(this,currentList);
		lv.setAdapter(adapter);
		
		//�б����¼�
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				
				Log.d("TAG","��ջ���ȣ�"+stack.size());
				
				//��ǰ���ڸ�Ŀ¼
				if(stack.size()==1){
					//�ӵ�ǰ�б�������ѡ���ļ�����
					currentFile=currentList.get(position);
					//�ѵ�ǰѡ���ļ�������뵽��ջ
					stack.push(currentFile);
					//�г���ǰĿ¼
					getList(currentFile,true);
				}else{
					//��ǰ������Ŀ¼ ������һ��
					if(position==0){
						//������һ�� ��ջ 
						stack.pop();
						//��ø���Ŀ¼����
						currentFile=stack.get(stack.size()-1);
						
						
						if(stack.size()==1){
							//�������Ŀ¼�Ǹ�Ŀ¼����Ҫ��ӷ�����һ��
							getList(currentFile,false);							
						}else{
							//�������Ŀ¼����Ŀ¼��Ҫ��ӷ�����һ��
							getList(currentFile, true);
						}

					}else{
						//������Ŀ¼ 
						//�ӵ�ǰ�б�������ѡ���ļ�����
						currentFile=currentList.get(position);
						//ѹջ
						stack.push(currentFile);
						//�г���ǰĿ¼
						getList(currentFile,true);
					}
				}
				//����Ǹ�Ŀ¼û�з�����һ�� �������Ŀ¼��ӷ���
				//�г���ǰѡ��Ŀ¼�������Ŀ¼
				/*if(stack.size()==1){
					//��Ŀ¼
					getList(currentFile,false);
				}else{
					//���Ǹ�Ŀ¼ ��ӷ���
					getList(currentFile,true);
				}*/
				
				//ˢ��������
				adapter.notifyDataSetChanged();
				
			}
		});
	}

	//����Ŀ¼
	public void getList(File file,boolean flag){
		File[] files=file.listFiles();
		currentList.clear();
		//flagΪtrue��ʾ����Ŀ¼
		if(flag){
			currentList.add(new File("","������һ��"));
		}
		//�Ѹ�Ŀ¼����������ļ��ŵ�list
		for (int i = 0; i < files.length; i++) {
			currentList.add(files[i]);
		}
		
	}
	
}
