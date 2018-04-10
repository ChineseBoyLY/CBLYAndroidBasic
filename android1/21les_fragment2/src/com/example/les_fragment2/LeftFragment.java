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
	//fragment�����滻fragment
	FragmentTransaction transcation;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("TAG","fragment����");
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d("TAG","FRAGMENT����");
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// ������ͼ��ָ������
		View view=inflater.inflate(R.layout.left_fragment,null);
		lv=(ListView)view.findViewById(R.id.lv);
		//����fragment����
		transcation=getActivity().getFragmentManager().beginTransaction();
		container=(FrameLayout)getActivity().findViewById(R.id.container);
		list=new ArrayList<String>();
		list.add("��һҳ");
		list.add("�ڶ�ҳ");
		list.add("����ҳ");
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,list);
		lv.setAdapter(adapter);
		
		//�б����¼�
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				Fragment fragment=null;
				transcation=getActivity().getFragmentManager().beginTransaction();
				if(position==0){
					fragment=new FirstFragment();
					//�����Ҳ�֡��������1���滻�ĵط�2��fragment
					transcation.add(R.id.container, fragment);
					//��ӵ�ǰfragment����ջ
					transcation.addToBackStack("ϰ���");
				}else if(position==1){
					fragment=new SecondFragment();
					transcation.add(R.id.container,fragment);
					transcation.addToBackStack("ϰ���");
				}else if(position==2){
					fragment=new ThirdFragment();
					transcation.add(R.id.container,fragment);
					transcation.addToBackStack("ϰ���");
				}
				transcation.commit();
			}
		});
		return view;
	}
	
	
	
}
