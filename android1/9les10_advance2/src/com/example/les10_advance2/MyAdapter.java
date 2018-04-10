package com.example.les10_advance2;

import java.util.List;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.AbsListView.LayoutParams;

public class MyAdapter extends BaseAdapter {
	
	List<String> list;
	Context ctx;
	//实例化布局的工具
	LayoutInflater inflater;
	public MyAdapter(Context ctx,List<String> list){
		this.list=list;
		this.ctx=ctx;
		this.inflater=LayoutInflater.from(this.ctx);
	}
	
	@Override
	public int getCount() {
		//定义行数
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
		// 定义每一行视图  参数view 控件传递给适配器 询问适配器 这一行应该怎么显示
		Log.d("TAG","view="+view);
		Componet comp=null;
		if(view==null){
			comp=new Componet();
			//实例化布局
			view=inflater.inflate(R.layout.lv_item,null);
			comp.img=(ImageView)view.findViewById(R.id.img);
			comp.tv=(TextView)view.findViewById(R.id.tv);
			//需要重复使用文本框  文本框当成试图对象附加属性
			view.setTag(comp);
			//从布局里面找出对应的控件
		}else{
			comp=(Componet)view.getTag();
			//往对应的控件里面填充数据
		}
		//填充数据
		comp.tv.setText(list.get(position));
		comp.img.setImageResource(R.drawable.qq);
		return view;
	}

	class Componet{
		ImageView img;
		TextView tv;
	}
}
