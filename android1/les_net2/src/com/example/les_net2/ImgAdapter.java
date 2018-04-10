package com.example.les_net2;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImgAdapter extends BaseAdapter {

	Bitmap[] bitmaps;
	Context ctx;
	LayoutInflater inflater;
	
	public ImgAdapter(Context ctx,Bitmap[] bitmaps) {
		// TODO Auto-generated constructor stub
		this.bitmaps=bitmaps;
		this.ctx=ctx;
		this.inflater=LayoutInflater.from(ctx);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return bitmaps.length;
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
		ImageView img=null;
		if(convertView==null){
			convertView=inflater.inflate(R.layout.gly_item,null);
			img=(ImageView)convertView.findViewById(R.id.itemiv);
			convertView.setTag(img);
		}else{
			img=(ImageView)convertView.getTag();
		}
		img.setImageBitmap(bitmaps[position]);
		return convertView;
	}

}
