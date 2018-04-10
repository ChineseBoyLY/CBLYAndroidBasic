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
	//ʵ�������ֵĹ���
	LayoutInflater inflater;
	public MyAdapter(Context ctx,List<String> list){
		this.list=list;
		this.ctx=ctx;
		this.inflater=LayoutInflater.from(this.ctx);
	}
	
	@Override
	public int getCount() {
		//��������
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
		// ����ÿһ����ͼ  ����view �ؼ����ݸ������� ѯ�������� ��һ��Ӧ����ô��ʾ
		Log.d("TAG","view="+view);
		Componet comp=null;
		if(view==null){
			comp=new Componet();
			//ʵ��������
			view=inflater.inflate(R.layout.lv_item,null);
			comp.img=(ImageView)view.findViewById(R.id.img);
			comp.tv=(TextView)view.findViewById(R.id.tv);
			//��Ҫ�ظ�ʹ���ı���  �ı��򵱳���ͼ���󸽼�����
			view.setTag(comp);
			//�Ӳ��������ҳ���Ӧ�Ŀؼ�
		}else{
			comp=(Componet)view.getTag();
			//����Ӧ�Ŀؼ������������
		}
		//�������
		comp.tv.setText(list.get(position));
		comp.img.setImageResource(R.drawable.qq);
		return view;
	}

	class Componet{
		ImageView img;
		TextView tv;
	}
}
