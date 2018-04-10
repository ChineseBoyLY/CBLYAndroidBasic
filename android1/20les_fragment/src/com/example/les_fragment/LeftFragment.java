package com.example.les_fragment;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class LeftFragment extends Fragment {
	ListView lv;
	List<String> list;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// ������ͼ��ָ������
		View view=inflater.inflate(R.layout.left_fragment,null);
		lv=(ListView)view.findViewById(R.id.lv);
		
		list=new ArrayList<String>();
		list.add("asdf");
		list.add("qwer");
		list.add("zxcv");
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,list);
		lv.setAdapter(adapter);
		
		//�б����¼�
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				TextView tv=(TextView)getActivity().findViewById(R.id.detailTvac);
				if(tv==null){
					//��ǰ��ʾ���ֻ�����
					Intent intent=new Intent();
					intent.setClass(getActivity(), DetailActivity.class);
					intent.putExtra("name",list.get(position));
					getActivity().startActivity(intent);
				}else{
					//��ƽ������
					tv.setText(list.get(position));
				}
			}
		});
		return view;
	}
	
	
	
}
