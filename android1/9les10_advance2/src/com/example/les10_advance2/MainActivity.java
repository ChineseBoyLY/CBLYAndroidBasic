package com.example.les10_advance2;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Spinner �����б�
 * ListView �б�ؼ�
 * Adapater
 * 1������������  �ַ��� ��һ
 * 2����������	�������� 
 * 3���Զ���������	�����¼�
 * 4���α������� 
 * 
 * listView �¼�
 * 1������¼�
 * 2�������¼� 
 * 
 * ���ݼ����� �� ˢ��
 * ���������Ż�����
 * Gallery ����
 * ��ҵ��ViewFliperʵ�����ҹ���
 * @author Administrator
 *
 */
public class MainActivity extends Activity {
	ListView lv;
	List<String> list=new ArrayList<String>();
	MyAdapter adapter;
	View view;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv=(ListView)findViewById(R.id.lv);
		
		/*Book book=new Book();
		book.imgid=R.drawable.qq;
		book.name="������";
		book.btnName="����������";
		list.add(book);
		
		book=new Book();
		book.imgid=R.drawable.ww;
		book.name="����è";
		book.btnName="���ػ���è";
		list.add(book);
		
		book=new Book();
		book.imgid=R.drawable.ic_launcher;
		book.name="������";
		book.btnName="���ذ�����";
		list.add(book);*/
		
		for (int i = 1; i < 100; i++) {
			list.add(""+i);
		}
		
		adapter=new MyAdapter(this, list);
		lv.setAdapter(adapter);
		
		//����¼�
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				Log.d("TAG",""+position);
			}
		});
		
		//�����¼�  �������false��ʾ����¼��������� �������true��ʾ���ټ�����������¼�
		lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				Dao dao=new Dao(list);
				list.clear();
				dao.getAll();
				adapter.notifyDataSetChanged();
				return true;
			}
		});

	}
}
