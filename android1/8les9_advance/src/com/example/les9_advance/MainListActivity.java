package com.example.les9_advance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainListActivity extends Activity {
	ListView lv;
	ArrayAdapter<String> adapter;
	List<String> list;
	
	Button btn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_list);
		lv=(ListView)findViewById(R.id.lv);
		/*btn=(Button)findViewById(R.id.btn);
		
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Toast.makeText(MainListActivity.this,"土司",Toast.LENGTH_LONG).show();
			}
		});*/
		
		/*list=new ArrayList<String>();
		list.add("蜡笔小新");
		list.add("小叮当");
		list.add("大熊");
		adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
		lv.setAdapter(adapter);*/
		
		/*List list=new ArrayList();
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("icon",R.drawable.ic_launcher);
		map.put("title","LOL");
		map.put("btn","下载");
		list.add(map);
		
		map=new HashMap<String, Object>();
		map.put("icon",R.drawable.ic_launcher);
		map.put("title","酷跑");
		map.put("btn","下载");
		list.add(map);
		
		map=new HashMap<String, Object>();
		map.put("icon",R.drawable.ic_launcher);
		map.put("title","切西瓜");
		map.put("btn","下载");
		list.add(map);
		
		//list.add(new HashMap<"icon",R.drawable.ic_launcher>());
		
		String[] from={"icon","title","btn"};
		int[] to={R.id.img,R.id.title,R.id.btn};
		//简单适配器1、上下文 不解释 2、数据集3、样式资源4、从哪来5、到哪去
		SimpleAdapter adapter=new SimpleAdapter(this, list, R.layout.simple_item, from, to);
		lv.setAdapter(adapter);*/
		
		list=new ArrayList<String>();
		list.add("大熊");
		list.add("静怡");
		list.add("胖虎");
		
		//创建自定义适配器
		MyAdapter adapter=new MyAdapter(this, list);
		lv.setAdapter(adapter);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
