package com.example.les9_advance;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MyAdapter extends BaseAdapter {

	List<String> list;
	Context ctx;

	public MyAdapter(Context ctx, List<String> list) {
		this.list = list;
		this.ctx = ctx;
	}

	@Override
	public int getCount() {
		// 返回长度 返回多少显示多少行
		return this.list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// 酱油
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// 酱油
		return 0;
	}
	
	@Override
	public View getView(int position, View arg1, ViewGroup arg2) {
		// 每创建一行都需要调用这个方法 这个放回返回值 视图对象
		
		Log.d("TAG", "getView");

		// 创建布局参数
		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);

		// 返回值决定每一行长相
		LinearLayout layout = new LinearLayout(this.ctx);
		// 指定水平方向
		layout.setOrientation(LinearLayout.HORIZONTAL);

		layout.setLayoutParams(params);

		// 添加图片框
		ImageView img = new ImageView(this.ctx);
		params = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		img.setLayoutParams(params);
		img.setImageResource(R.drawable.ic_launcher);
		layout.addView(img);

		// 添加文本框
		TextView tv = new TextView(this.ctx);
		params = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		tv.setLayoutParams(params);
		tv.setText(this.list.get(position));
		layout.addView(tv);

		Button btn = new Button(this.ctx);
		btn.setLayoutParams(params);
		btn.setText("下载");
		layout.addView(btn);

		final int index=position;
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Toast.makeText(ctx, "按钮"+list.get(index), Toast.LENGTH_SHORT).show();
			}
		});
		return layout;
	}

}
