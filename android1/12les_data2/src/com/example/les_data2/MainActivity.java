package com.example.les_data2;

import java.util.HashSet;
import java.util.Set;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * 数据储存
 * sqlite 数据库   文件  输入流输出流
 * SqliteDatabase data/data/包名/databases
 * 
 * 每一个SharedPreferences 对象对应一个文件
 * data/data/包名/shared_prefs
 * 只能存储基本类型 
 * 1、Shared Preferences  以键值对的形式存储数据
	2、Internal Storage		手机内存 io
		外挂  游戏角色，坐标 ，动作
		读取过程固定  交易所老板 鸭子   卖出  数据作用都是单一
		长度也是固定，方便读取
	3、External Storage		外部存储目录
	4、SQLite Databases		数据库
	
		Cursor sqlite.query delete ...  读取SD卡文件
	5、Network Connection	云服务

作业，文件浏览器 
 * @author Administrator
 *
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void btnClick(View view){
		//只能用来查询
		SharedPreferences prefers=getSharedPreferences("test", MODE_PRIVATE);
		if(view.getId()==R.id.btn1){
			//增加一条数据  1、指定文件名2、指定打开模式  
			
			//编辑对象
			Editor editor=prefers.edit();
			editor.putString("name","kakaxi");
			Set set=new HashSet();
			set.add(12);
			set.add("卡卡西");
			editor.putStringSet("set", set);
			//提交
			editor.commit();
		}else if(view.getId()==R.id.btnDel){
			//删除
			Editor editor=prefers.edit();
			editor.remove("name");
			//提交
			editor.commit();
		}else if(view.getId()==R.id.btnUpdate){
			//修改
			Editor editor=prefers.edit();
			editor.putString("name","大和");
			editor.commit();
		}else if(view.getId()==R.id.btnQuery){
			//查询 1、键名 2、默认值 （如果在xml里面找不到对应的键返回的值）
			String name=prefers.getString("name", "大蛇丸");
			Toast.makeText(this, name,Toast.LENGTH_LONG).show();
		}
	}
}
