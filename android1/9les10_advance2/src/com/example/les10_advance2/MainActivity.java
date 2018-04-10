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
 * Spinner 下拉列表
 * ListView 列表控件
 * Adapater
 * 1、数组适配器  字符串 单一
 * 2、简单适配器	复杂类型 
 * 3、自定义适配器	处理事件
 * 4、游标适配器 
 * 
 * listView 事件
 * 1、点击事件
 * 2、长按事件 
 * 
 * 数据集引用 和 刷新
 * 适配器的优化过程
 * Gallery 画廊
 * 作业：ViewFliper实现左右滚动
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
		book.name="七龙珠";
		book.btnName="下载七龙珠";
		list.add(book);
		
		book=new Book();
		book.imgid=R.drawable.ww;
		book.name="机器猫";
		book.btnName="下载机器猫";
		list.add(book);
		
		book=new Book();
		book.imgid=R.drawable.ic_launcher;
		book.name="阿拉蕾";
		book.btnName="下载阿拉蕾";
		list.add(book);*/
		
		for (int i = 1; i < 100; i++) {
			list.add(""+i);
		}
		
		adapter=new MyAdapter(this, list);
		lv.setAdapter(adapter);
		
		//点击事件
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				Log.d("TAG",""+position);
			}
		});
		
		//长按事件  如果返回false表示点击事件继续传播 如果返回true表示不再继续传播点击事件
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
