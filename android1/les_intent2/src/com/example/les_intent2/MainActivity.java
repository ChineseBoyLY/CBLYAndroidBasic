package com.example.les_intent2;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

/**
 * Intent  传值 启动组件
 * 	意图
 * IntentFilter
 * 	意图过滤器
 * activity service
 *反编译配置文件
 * 1、显示启动方式
 * 	指定组件名字
 * 2、隐式启动组件
 * 	指定需求规格由系统负责实现
 * 如果某个组件标签里面没有配置过滤器
 * 这个组件不支持隐式启动
 * <category android:name="android.intent.category.DEFAULT"/>
 * uri http://www.baidu.com
 * http
 * https
 * ftp
 * setType方法
 * setData方法 冲突
 * 谁写在后面 哪个设置才有作用
 * action 匹配规则(intentFilter中必须要有action标签，否则任何intent都不能通过action验证)
 * 		如果IntentFilter中配置action属性，那么intent中也必须
 * 		设置对应action属性
 * 		如果有多个action属性，那么至少应该匹配一个
 * 		如果intentFilter中没有配置action标签，intent中也没有
 * 		设置action，则action匹配失败
 * data匹配规则
 * 		如果只指定数据，那么intent也必须指定数据
 * 		如果intentFilter中指定了协议，主机名。。。指定几个
 * 		intent中也必须指定几个，必须一样的，否则不能通过
 * 		匹配
 * 		如果只指定类型，那么intent也必须指定类
 * 		setType和setData
 * 		如果intentFilter中同时指定了数据和类型，那么intent中
 * 		也必须同时指定数据和类型，否则不能通过匹配
 * 		如果不设置data或者不设置type，那么intent中也不能
 * 		设置data或者type
 * category匹配规则
 * 		category采用子集验证方式，intent对象指定了N个category，
 * 		在某一个intentFilter中，设置了M个category，并且M>=N,
 * 		那么种类匹配成功，其他情况匹配失败
 * 
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
		Intent intent=null;
		if(view.getId()==R.id.btn1){
			intent=new Intent();
			//指定intent行为
			intent.setAction("com.example.road");
			startActivity(intent);
		}else if(view.getId()==R.id.btn2){
			//数据
			intent=new Intent();
			intent.setAction("com.example.film");
			
			/*intent.setData(Uri.parse("http://180.97.33.107"));
			intent.setType("video/rmvb");*/
			intent.setDataAndType(Uri.parse("http://asdf"),"video/avi");
			startActivity(intent);
		}else if(view.getId()==R.id.btn3){
			//种类
			intent=new Intent();
			intent.setAction("com.example.shopping");
			intent.addCategory("com.example.feifei");
			startActivity(intent);
		}else if(view.getId()==R.id.btn4){
			//系统浏览器界面
			intent=new Intent();
			intent.setAction("android.intent.action.VIEW");
			intent.addCategory("android.intent.category.BROWSABLE");
			intent.setData(Uri.parse("about://asdhfa"));
			startActivity(intent);
		}else if(view.getId()==R.id.btn5){
			//系统计算器
			intent=new Intent();
			intent.setAction("android.intent.action.MAIN");
			intent.addCategory("android.intent.category.LAUNCHER");
			intent.addCategory("android.intent.category.APP_CALCULATOR");
			startActivity(intent);
		}else if(view.getId()==R.id.btn6){
			//未知界面
			intent=new Intent();
			intent.setAction("android.intent.action.MAIN");
			intent.addCategory("com.android.internal.category.PLATLOGO");
			startActivity(intent);
		}else if(view.getId()==R.id.btn7){
			//未知界面2
			intent=new Intent();
			intent.setAction("android.intent.action.MAIN");
			intent.addCategory("android.intent.category.DESK_DOCK");
			startActivity(intent);
		}else if(view.getId()==R.id.btn8){
			//启动其他应用
			intent=new Intent();
			intent.setAction("android.intent.action.MAIN");

			
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
