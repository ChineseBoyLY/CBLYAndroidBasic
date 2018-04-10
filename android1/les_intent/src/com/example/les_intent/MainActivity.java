package com.example.les_intent;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Parcelable;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

/**
 * servlet
 * jsp -->jsp--jsp
 * ���л� io
 * intent
 * 1����ֵ
 * 		intent application ÿ��Ӧ�ó���ֻ��һ�������Ķ���
 * 2���������
 * 	1����ʾ����
 * 	2����ʽ����
 * ��� activity service receiver provider
 * @author kulv16
 *
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void btnClick(View  view){
		Intent intent=new Intent();
		//���ݵ�������
		/*Book book=new Book();
		book.bookid=1;
		book.bookname="Ѫɫ����";
		intent.putExtra("book",book);*/
		
		//����Parcelable���Ͷ���
		//intent.put
		/*Person p=new Person();
		p.pid=1;
		p.pname="Ұԭ��֮��";
		p.psex="��";
		intent.putExtra("person",p);*/
		
		//���ݶ��󼯺� Arraylist<Parcelable>
		/*ArrayList<Person> list=new ArrayList<Person>();
		list.add(new Person(1,""));
		list.add(new Person(2,""));
		list.add(new Person(3,""));
		intent.putParcelableArrayListExtra("list",list);*/
		
		//Bundle ����  map ��ֵ�� �ڽ��̼䴫��ֵ����   ����Դ�� unix 
		//����Ĭ���ǲ��ܻ������
/*		
		Bundle bundle=new Bundle();
		intent.putExtras(bundle);*/
		
		//ֱ��ָ����Ҫ����������� ��ʾ���������ʽ
		//intent.setClass(this,SecondActivity.class);
		
		//��������Ӧ�ó���Ľ��棬����֮ǰ��Ҫ�ȱ�֤����һ��Ӧ�ò��������������
		intent.setClassName("com.example.les_intenttest", "com.example.les_intenttest.MainActivity");
		startActivity(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
