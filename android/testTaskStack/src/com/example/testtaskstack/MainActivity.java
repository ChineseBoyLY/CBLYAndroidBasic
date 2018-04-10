package com.example.testtaskstack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * 1·standard：每次都会加入到任务回退栈（taskstack）里面去
 * 
 * 2·singleTop：如果栈顶已经存在，就不会继续加入，但是如果不是在栈顶，还是会继续加入的
 * 应用场景：浏览器的书签
 * 
 * 3·singleTask：在整个任务栈里面都只能有一个相同的activity；
 * 				在开启activity的时候，先去检查任务栈，如果存在，则将它前面的activity全部出栈，使其置为栈顶
 * 应用：节约资源（耗资源的应用程序可以使用）
 * 
 * 4·singleInstance：开启一个新的任务栈，只有一个activity的实例存在；
 * 					如果这个activity被开启，就把这个新的任务栈放到原来的那个的前面；
 * 					如果别的activity开启，就把原来的那个任务栈放到这个新的任务栈的前面。
 * 	应用：当同时有很多人打电话来的时候，只会有一个来电显示界面；
 * 		紧急呼叫
 * 		有道词典的快速取词
 *
 * @author Administrator
 *
 */

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void click(View view){
		if(view.getId()==R.id.btn1){
			Intent intent = new Intent(this, SecondActivity.class);
			startActivity(intent);
		}else if(view.getId()==R.id.btn2){
			Intent intent = new Intent(this, ThirdActivity.class);
			startActivity(intent);
		}
	}
}
