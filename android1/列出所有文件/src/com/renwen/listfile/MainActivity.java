package com.renwen.listfile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	ListView lv;
	List<File> list = new ArrayList<File>();
	File[] files;
	MyAdapter adapter;
	View view;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv = (ListView) findViewById(R.id.lv);

		File file = new File("/mnt");
		files = file.listFiles();
		for (File f : files) {
			list.add(f);
		}
		adapter = new MyAdapter(this, list);
		lv.setAdapter(adapter);

		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				if (list.get(position) != null) {
					if (list.get(position).isDirectory()) {
						files = list.get(position).listFiles();
						list.clear();
						if (files != null) {
							for (File f : files) {
								list.add(f);
							}
							Log.d("TAG", list.size() + "aa");
						} else {
							// 空文件夹的处理
							Log.d("TAG", "这是一个空文件夹");
							list.add(null);
						}
					} else {
						// 这是一个文件
						Toast.makeText(MainActivity.this, "这是一个文件",
								Toast.LENGTH_SHORT);
					}
				}else{
					//返回上一级目录
					for (File f : files) {
						list.add(f);
					}
				}
				adapter.notifyDataSetInvalidated();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
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
