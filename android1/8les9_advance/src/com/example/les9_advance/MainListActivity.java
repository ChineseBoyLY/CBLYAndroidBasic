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
				Toast.makeText(MainListActivity.this,"��˾",Toast.LENGTH_LONG).show();
			}
		});*/
		
		/*list=new ArrayList<String>();
		list.add("����С��");
		list.add("С����");
		list.add("����");
		adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
		lv.setAdapter(adapter);*/
		
		/*List list=new ArrayList();
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("icon",R.drawable.ic_launcher);
		map.put("title","LOL");
		map.put("btn","����");
		list.add(map);
		
		map=new HashMap<String, Object>();
		map.put("icon",R.drawable.ic_launcher);
		map.put("title","����");
		map.put("btn","����");
		list.add(map);
		
		map=new HashMap<String, Object>();
		map.put("icon",R.drawable.ic_launcher);
		map.put("title","������");
		map.put("btn","����");
		list.add(map);
		
		//list.add(new HashMap<"icon",R.drawable.ic_launcher>());
		
		String[] from={"icon","title","btn"};
		int[] to={R.id.img,R.id.title,R.id.btn};
		//��������1�������� ������ 2�����ݼ�3����ʽ��Դ4��������5������ȥ
		SimpleAdapter adapter=new SimpleAdapter(this, list, R.layout.simple_item, from, to);
		lv.setAdapter(adapter);*/
		
		list=new ArrayList<String>();
		list.add("����");
		list.add("����");
		list.add("�ֻ�");
		
		//�����Զ���������
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
