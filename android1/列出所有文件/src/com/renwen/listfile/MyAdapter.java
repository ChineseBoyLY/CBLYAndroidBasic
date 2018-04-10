package com.renwen.listfile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

	List<File> list;
	Context ctx;
	// 实例化布局的工具
	LayoutInflater inflater;

	public MyAdapter(Context ctx, List<File> list) {
		this.list = list;
		this.ctx = ctx;
		this.inflater = LayoutInflater.from(this.ctx);
	}

	@Override
	public int getCount() {
		// 定义行数
		return this.list.size();
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int position, View view, ViewGroup arg2) {
		Componet comp = null;
		if (view == null) {
			comp = new Componet();
			view = inflater.inflate(R.layout.lv_item, null);
			comp.img = (ImageView) view.findViewById(R.id.img);
			comp.tv = (TextView) view.findViewById(R.id.tv);
			view.setTag(comp);
		} else {
			comp = (Componet) view.getTag();
		}
		if (list.get(position) != null) {
			if (list.get(position).isDirectory()) {
				comp.img.setImageResource(R.drawable.in);
			} else if (list.get(position).isFile()) {
				comp.img.setImageResource(R.drawable.file);
			}
			comp.tv.setText(list.get(position).getName());
		}else{
			//Log.d("TAG", "这是一个空文件夹MyAdapter");
			comp.img.setImageResource(R.drawable.out);
			comp.tv.setText("返回上一级目录..");
		}
		return view;
	}
}
