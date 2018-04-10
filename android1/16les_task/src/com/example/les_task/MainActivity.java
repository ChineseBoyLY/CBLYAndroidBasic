package com.example.les_task;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

/**
 * orm  oa 
 * 任务回退栈  管理已经打开过的这些activity（管理界面，回退到指定哪个界面 或者指定打开哪个界面）
 * 任务 ：已经打开的activity的集合 
 * 堆栈：所有已经打开过的activity都被保存在一个堆栈里面，按照打开的顺序保存的集合
 * 每个android应用程序都有自己的任务和堆栈
 * 如果有某个activity从堆栈里面弹出来 这个activity已经被销毁
 * 加载模式
 * standard 标准加载模式 同一个任务栈可有同一个窗口的多个实例
 * 同一个窗口的多个实例也可以存在于不同的任务栈里面
 * singleTop 当窗口处于栈顶的时候，不会再实例化窗口
 * 如果窗口不处于栈顶，加载模式跟standard一样
 * singleTask 同一个窗口的实例只能存在于一个回退栈里面
 * singleInstance 整个任务栈里面有只能有一个窗口
 * 作业：使用Intent标签实现
 * @author kulv16
 *
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void btnClick(View view){
		if(view.getId()==R.id.btn1){
			Intent intent=new Intent();
			//1、当前界面对象2、需要跳转界面对象
			intent.setClass(this,SecondActivity.class);
			//启动界面
			startActivity(intent);
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
