package com.example.les9_advance;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * 高级控件  
 * 组合一些基本控件 Button TextView ImageView 
 * Spinner 下拉列表 ListView 列表框
 * entries 添加静态数据
 * android:entries 添加静态数据
 * 
 * 适配器  Adapter  只能创建一次 每个高级控件只能跟一个适配器绑定  适配器刷新   内存合理分配  读取照片 OOM  
 * out of memery内存溢出
 * 1、数组适配器 ArrayAdapter 只能显示字符串 
 * 2、简单适配器 SimpleAdapter
 * 3、游标适配器 CursorAdapter 数据库
 * 继承
 * 4、自定义适配器 BaseAdapter
 * 
 * 高级控件 --》适配器--》数据集 
 * ListView 
 * 作业：自定义适配器里面设置按钮监听
 * Gallery 画廊 废弃
 * @author Administrator
 *
 */
public class MainActivity extends Activity {
	Spinner sp;
	Spinner spcity;
	ArrayAdapter<String> adapterCity;
	List<String> city;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sp=(Spinner)findViewById(R.id.sp);
		spcity=(Spinner)findViewById(R.id.spcity);
		List<String> list=new ArrayList<String>();
		list.add("山东省");
		list.add("湖南省");
		list.add("江西省");
		//创建数组适配器 1、上下文类型对象2、每一行显示样子3、数据集
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.item, list);
		//指定一个高级控件绑定适配器
		sp.setAdapter(adapter);
		
		city=new ArrayList<String>();
		adapterCity=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item, city);
		spcity.setAdapter(adapterCity);
		
		//下拉列表选择选项事件
		sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long id) {
				// 选择其中一个
				if(position==0){
					city.clear();
					city.add("济南");
					city.add("青岛");
					city.add("威海");
					
				}else if(position==1){
					city.clear();
					city.add("长沙");
					city.add("娄底");
					city.add("湘潭");
					
				}else if(position==2){
					city.clear();
					city.add("南昌");
					city.add("赣州");
					city.add("平江");
					
				}
				//刷新适配器
				adapterCity.notifyDataSetChanged();
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// 什么都没有选择 
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
