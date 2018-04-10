package com.example.les_fragment2;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class LeftFragment extends Fragment {
	ListView lv;
	List<String> list;
	FrameLayout container;
	//fragment事务替换fragment
	FragmentTransaction transcation;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("TAG","fragment创建");
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d("TAG","FRAGMENT销毁");
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// 创建视图，指定代码
		View view=inflater.inflate(R.layout.left_fragment,null);
		lv=(ListView)view.findViewById(R.id.lv);
		//开启fragment事务
		transcation=getActivity().getFragmentManager().beginTransaction();
		container=(FrameLayout)getActivity().findViewById(R.id.container);
		list=new ArrayList<String>();
		list.add("第一页");
		list.add("第二页");
		list.add("第三页");
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,list);
		lv.setAdapter(adapter);
		
		//列表点击事件
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				Fragment fragment=null;
				transcation=getActivity().getFragmentManager().beginTransaction();
				if(position==0){
					fragment=new FirstFragment();
					//贴到右侧帧布局里面1、替换的地方2、fragment
					transcation.add(R.id.container, fragment);
					//添加当前fragment到堆栈
					transcation.addToBackStack("习大大");
				}else if(position==1){
					fragment=new SecondFragment();
					transcation.add(R.id.container,fragment);
					transcation.addToBackStack("习大大");
				}else if(position==2){
					fragment=new ThirdFragment();
					transcation.add(R.id.container,fragment);
					transcation.addToBackStack("习大大");
				}
				transcation.commit();
			}
		});
		return view;
	}
	
	
	
}
