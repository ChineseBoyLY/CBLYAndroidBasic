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
		// ���س��� ���ض�����ʾ������
		return this.list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// ����
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// ����
		return 0;
	}
	
	@Override
	public View getView(int position, View arg1, ViewGroup arg2) {
		// ÿ����һ�ж���Ҫ����������� ����Żط���ֵ ��ͼ����
		
		Log.d("TAG", "getView");

		// �������ֲ���
		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);

		// ����ֵ����ÿһ�г���
		LinearLayout layout = new LinearLayout(this.ctx);
		// ָ��ˮƽ����
		layout.setOrientation(LinearLayout.HORIZONTAL);

		layout.setLayoutParams(params);

		// ���ͼƬ��
		ImageView img = new ImageView(this.ctx);
		params = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		img.setLayoutParams(params);
		img.setImageResource(R.drawable.ic_launcher);
		layout.addView(img);

		// ����ı���
		TextView tv = new TextView(this.ctx);
		params = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		tv.setLayoutParams(params);
		tv.setText(this.list.get(position));
		layout.addView(tv);

		Button btn = new Button(this.ctx);
		btn.setLayoutParams(params);
		btn.setText("����");
		layout.addView(btn);

		final int index=position;
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Toast.makeText(ctx, "��ť"+list.get(index), Toast.LENGTH_SHORT).show();
			}
		});
		return layout;
	}

}
