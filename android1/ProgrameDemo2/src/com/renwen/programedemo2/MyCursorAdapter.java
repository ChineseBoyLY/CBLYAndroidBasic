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
	//ʵ�������ֵĹ���
	LayoutInflater inflater;
	Componet comp;
	
	public MyCursorAdapter(Context context, Cursor c) {
		super(context, c);
		this.context=context;
		this.c=c;
		this.inflater=LayoutInflater.from(this.context);
	}
	
	/**
	 * ������һ�λص��ú�������ݸ���Ҳ���ٵ��ã����ػ���ٴε��õġ�
	 * �ܵ���˵Ӧ�����ڵ���bindView�������viewΪ�ջ��ȵ���newView������view
	 */
	@Override
	public void bindView(View view, Context ctx, Cursor cursor) {
//		���������õ�������
		Log.d("TAG", "bindView");
		comp=(Componet)view.getTag();
		String id = cursor.getString(cursor.getColumnIndex("_id"));
		String name = cursor.getString(cursor.getColumnIndex("book_name"));
		comp.tv1.setText(id);
		comp.tv2.setText(name);
	} 
	
	/**
	 * newView�ú�����һ�λص��ú�����������Ӻ�Ҳ���ٵ��ã������ػ��ǲ�����õġ�
	 * �������Ӻ�,�ص��øú����������������������Ӧ��view��
	 */
	@Override
	public View newView(Context ctx, Cursor cursor, ViewGroup vg) {
		//�ҵ����ֺͿؼ�
		View view=inflater.inflate(R.layout.lv_item,null);
		Log.e("TAG", "newView"+view);
		Componet comp=new Componet();
		comp.tv1=(TextView)view.findViewById(R.id.tv1);
		comp.tv2=(TextView)view.findViewById(R.id.tv2);
		view.setTag(comp);
		return view;//���ص�view����bindView��
	}
	
	class Componet{
		TextView tv1;
		TextView tv2;
	}
}
