package com.example.les10_advance2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GlyAdapter extends BaseAdapter {

	int[] resids;
	Context ctx;
	LayoutInflater inflater;
	public GlyAdapter(Context ctx,int[] resids) {
		
		this.resids=resids;
		this.ctx=ctx;
		inflater=LayoutInflater.from(ctx);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return resids.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View view, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ImageView img;
		if(view==null){
			view=inflater.inflate(R.layout.gly_item,null);
			img=(ImageView)view.findViewById(R.id.glyiv);
			view.setTag(img);
		}else{
			img=(ImageView)view.getTag();
		}
		img.setImageResource(resids[position]);
		return view;
	}

}
