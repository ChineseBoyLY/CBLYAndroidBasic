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
 * 序列化 io
 * intent
 * 1、传值
 * 		intent application 每个应用程序只有一个这样的对象
 * 2、启动组件
 * 	1、显示启动
 * 	2、隐式启动
 * 组件 activity service receiver provider
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
		//传递单个对象
		/*Book book=new Book();
		book.bookid=1;
		book.bookname="血色浪漫";
		intent.putExtra("book",book);*/
		
		//传递Parcelable类型对象
		//intent.put
		/*Person p=new Person();
		p.pid=1;
		p.pname="野原新之助";
		p.psex="男";
		intent.putExtra("person",p);*/
		
		//传递对象集合 Arraylist<Parcelable>
		/*ArrayList<Person> list=new ArrayList<Person>();
		list.add(new Person(1,""));
		list.add(new Person(2,""));
		list.add(new Person(3,""));
		intent.putParcelableArrayListExtra("list",list);*/
		
		//Bundle 类型  map 键值对 在进程间传递值作用   ，来源于 unix 
		//进程默认是不能互相访问
/*		
		Bundle bundle=new Bundle();
		intent.putExtras(bundle);*/
		
		//直接指定需要启动组件名字 显示启动组件方式
		//intent.setClass(this,SecondActivity.class);
		
		//调用其他应用程序的界面，在这之前需要先保证另外一个应用部署在虚拟机上面
		intent.setClassName("com.example.les_intenttest", "com.example.les_intenttest.MainActivity");
		startActivity(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
