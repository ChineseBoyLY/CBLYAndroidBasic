package com.renwen.programedemo2;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.renwen.programedemo2.R;

public class MyCursorAdapter extends CursorAdapter {

	Context context;
	Cursor c;
	//实例化布局的工具
	LayoutInflater inflater;
	Componet comp;
	
	public MyCursorAdapter(Context context, Cursor c) {
		super(context, c);
		this.context=context;
		this.c=c;
		this.inflater=LayoutInflater.from(this.context);
	}
	
	/**
	 * 函数第一次回调用后，如果数据更新也会再调用，但重绘会再次调用的。
	 * 总的来说应该是在调用bindView如果发现view为空会先调用newView来生成view
	 */
	@Override
	public void bindView(View view, Context ctx, Cursor cursor) {
//		把数据设置到界面上
		Log.d("TAG", "bindView");
		comp=(Componet)view.getTag();
		String id = cursor.getString(cursor.getColumnIndex("_id"));
		String name = cursor.getString(cursor.getColumnIndex("book_name"));
		comp.tv1.setText(id);
		comp.tv2.setText(name);
	} 
	
	/**
	 * newView该函数第一次回调用后，如果数据增加后也会再调用，但是重绘是不会调用的。
	 * 数据增加后,回调用该函数来生成与新增数据相对应的view。
	 */
	@Override
	public View newView(Context ctx, Cursor cursor, ViewGroup vg) {
		//找到布局和控件
		View view=inflater.inflate(R.layout.lv_item,null);
		Log.e("TAG", "newView"+view);
		Componet comp=new Componet();
		comp.tv1=(TextView)view.findViewById(R.id.tv1);
		comp.tv2=(TextView)view.findViewById(R.id.tv2);
		view.setTag(comp);
		return view;//返回的view传给bindView。
	}
	
	class Componet{
		TextView tv1;
		TextView tv2;
	}
}
