package com.example.les_fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class RightFragment extends Fragment {
	Button btn;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// 创建视图，指定代码
		View view=inflater.inflate(R.layout.right_fragment,null);
		return view;
	}

	public void btnClick(View view){
		Toast.makeText(getActivity(),"右侧按钮",Toast.LENGTH_LONG).show();
	}
}
