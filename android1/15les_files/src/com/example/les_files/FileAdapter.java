package com.example.les_files;

import java.io.File;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FileAdapter extends BaseAdapter {

	Context ctx;
	//实例化布局工具
	LayoutInflater inflater;
	List<File> list;
	
	public FileAdapter(Context ctx,List<File> list) {
		// TODO Auto-generated constructor stub
		this.ctx=ctx;
		this.inflater=LayoutInflater.from(ctx);
		this.list=list;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Componet comp=null;
		if(convertView==null){
			convertView=this.inflater.inflate(R.layout.lv_item,null);
			comp=new Componet();
			comp.img=(ImageView)convertView.findViewById(R.id.img);
			comp.tv=(TextView)convertView.findViewById(R.id.tv);
			convertView.setTag(comp);
		}else{
			comp=(Componet)convertView.getTag();
		}
		//填充数据
		if(this.list.get(position).isDirectory()){
			//是一个目录
			comp.img.setImageResource(R.drawable.folder);
		}else{
			//其他文件不是目录
			comp.img.setImageResource(R.drawable.other);
		}
		comp.tv.setText(this.list.get(position).getName());
		return convertView;
	}
	class Componet{
		ImageView img;
		TextView tv;
	}
}
