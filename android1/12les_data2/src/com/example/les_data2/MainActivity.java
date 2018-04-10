package com.example.les_data2;

import java.util.HashSet;
import java.util.Set;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * ���ݴ���
 * sqlite ���ݿ�   �ļ�  �����������
 * SqliteDatabase data/data/����/databases
 * 
 * ÿһ��SharedPreferences �����Ӧһ���ļ�
 * data/data/����/shared_prefs
 * ֻ�ܴ洢�������� 
 * 1��Shared Preferences  �Լ�ֵ�Ե���ʽ�洢����
	2��Internal Storage		�ֻ��ڴ� io
		���  ��Ϸ��ɫ������ ������
		��ȡ���̶̹�  �������ϰ� Ѽ��   ����  �������ö��ǵ�һ
		����Ҳ�ǹ̶��������ȡ
	3��External Storage		�ⲿ�洢Ŀ¼
	4��SQLite Databases		���ݿ�
	
		Cursor sqlite.query delete ...  ��ȡSD���ļ�
	5��Network Connection	�Ʒ���

��ҵ���ļ������ 
 * @author Administrator
 *
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void btnClick(View view){
		//ֻ��������ѯ
		SharedPreferences prefers=getSharedPreferences("test", MODE_PRIVATE);
		if(view.getId()==R.id.btn1){
			//����һ������  1��ָ���ļ���2��ָ����ģʽ  
			
			//�༭����
			Editor editor=prefers.edit();
			editor.putString("name","kakaxi");
			Set set=new HashSet();
			set.add(12);
			set.add("������");
			editor.putStringSet("set", set);
			//�ύ
			editor.commit();
		}else if(view.getId()==R.id.btnDel){
			//ɾ��
			Editor editor=prefers.edit();
			editor.remove("name");
			//�ύ
			editor.commit();
		}else if(view.getId()==R.id.btnUpdate){
			//�޸�
			Editor editor=prefers.edit();
			editor.putString("name","���");
			editor.commit();
		}else if(view.getId()==R.id.btnQuery){
			//��ѯ 1������ 2��Ĭ��ֵ �������xml�����Ҳ�����Ӧ�ļ����ص�ֵ��
			String name=prefers.getString("name", "������");
			Toast.makeText(this, name,Toast.LENGTH_LONG).show();
		}
	}
}
