package com.example.les9_advance;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * �߼��ؼ�  
 * ���һЩ�����ؼ� Button TextView ImageView 
 * Spinner �����б� ListView �б��
 * entries ��Ӿ�̬����
 * android:entries ��Ӿ�̬����
 * 
 * ������  Adapter  ֻ�ܴ���һ�� ÿ���߼��ؼ�ֻ�ܸ�һ����������  ������ˢ��   �ڴ�������  ��ȡ��Ƭ OOM  
 * out of memery�ڴ����
 * 1������������ ArrayAdapter ֻ����ʾ�ַ��� 
 * 2���������� SimpleAdapter
 * 3���α������� CursorAdapter ���ݿ�
 * �̳�
 * 4���Զ��������� BaseAdapter
 * 
 * �߼��ؼ� --��������--�����ݼ� 
 * ListView 
 * ��ҵ���Զ����������������ð�ť����
 * Gallery ���� ����
 * @author Administrator
 *
 */
public class MainActivity extends Activity {
	Spinner sp;
	Spinner spcity;
	ArrayAdapter<String> adapterCity;
	List<String> city;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sp=(Spinner)findViewById(R.id.sp);
		spcity=(Spinner)findViewById(R.id.spcity);
		List<String> list=new ArrayList<String>();
		list.add("ɽ��ʡ");
		list.add("����ʡ");
		list.add("����ʡ");
		//�������������� 1�����������Ͷ���2��ÿһ����ʾ����3�����ݼ�
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.item, list);
		//ָ��һ���߼��ؼ���������
		sp.setAdapter(adapter);
		
		city=new ArrayList<String>();
		adapterCity=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item, city);
		spcity.setAdapter(adapterCity);
		
		//�����б�ѡ��ѡ���¼�
		sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long id) {
				// ѡ������һ��
				if(position==0){
					city.clear();
					city.add("����");
					city.add("�ൺ");
					city.add("����");
					
				}else if(position==1){
					city.clear();
					city.add("��ɳ");
					city.add("¦��");
					city.add("��̶");
					
				}else if(position==2){
					city.clear();
					city.add("�ϲ�");
					city.add("����");
					city.add("ƽ��");
					
				}
				//ˢ��������
				adapterCity.notifyDataSetChanged();
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// ʲô��û��ѡ�� 
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
