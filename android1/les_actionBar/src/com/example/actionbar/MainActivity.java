package com.example.actionbar;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * �û����飬�����û�ѧϰ��ʱ��
 * 
 * actionBar
 * ������
 * MENU
 * Intent
 * ��ͼ����
 * @author liuyi
 *
 */

public class MainActivity extends Activity {

	ActionBar actionBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		actionBar=getActionBar();
		//����actionBar����ģʽ
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		//��ӱ�ǩҳ
		actionBar.addTab(actionBar.newTab().setText("��һҳ").setTabListener(new ActionBar.TabListener() {
			
			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
				
			}
			
			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				Log.d("TAG", "��һҳ");
				
				FirstFragment firstFragment=new FirstFragment();
				ft.add(R.id.container, firstFragment);
//				�����ύ
				//ft.commit();
			}
			
			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
				
			}
		}));
		
		actionBar.addTab(actionBar.newTab().setText("�ڶ�ҳ").setTabListener(new ActionBar.TabListener() {
			
			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
				
			}
			
			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				Log.d("TAG", "�ڶ�ҳ");
				SecondFragment secondFragment=new SecondFragment();
				ft.add(R.id.container, secondFragment);
//				ft.commit();
			}
			
			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
				
			}
		}));
	}
	
	/*public void btnClick(View view){
		if(view.getId()==R.id.hiddenBtn){
			actionBar.hide();
		}else if(view.getId()==R.id.showBtn){
			actionBar.show();
		}
	}*/
	
	/*
	 * ��ʾactionBar�ģ�û���򲻻���ʾactionBar
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//�������������actionBar
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	/*
	 * ʵ�ֲ˵���ĵ���¼�Ҫʵ��������� 
	 */
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		if(item.getItemId()==R.id.action_settings2){
			Log.d("TAG", "menu2");
		}else if(item.getItemId()==R.id.action_settings3){
			Log.d("TAG", "menu3");
		}
		return super.onMenuItemSelected(featureId, item);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
