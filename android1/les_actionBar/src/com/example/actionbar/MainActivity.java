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
 * 用户体验，减少用户学习的时间
 * 
 * actionBar
 * 标题栏
 * MENU
 * Intent
 * 意图对象
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
		//设置actionBar导航模式
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		//添加标签页
		actionBar.addTab(actionBar.newTab().setText("第一页").setTabListener(new ActionBar.TabListener() {
			
			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
				
			}
			
			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				Log.d("TAG", "第一页");
				
				FirstFragment firstFragment=new FirstFragment();
				ft.add(R.id.container, firstFragment);
//				不用提交
				//ft.commit();
			}
			
			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
				
			}
		}));
		
		actionBar.addTab(actionBar.newTab().setText("第二页").setTabListener(new ActionBar.TabListener() {
			
			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
				
			}
			
			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				Log.d("TAG", "第二页");
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
	 * 显示actionBar的，没有则不会显示actionBar
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//用这个方法创建actionBar
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	/*
	 * 实现菜单项的点击事件要实现这个方法 
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
