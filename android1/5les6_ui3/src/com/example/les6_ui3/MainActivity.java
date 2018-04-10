package com.example.les6_ui3;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * button 点击方案监听 
 * 1、创建匿名内部类
 * 2、xml设置监听方法
 * ImageView fitxy 不会保证图片最原始比例 centerCorp都会图片最原始比例
 * EditText  密码 inputTYpe
 * TextView  文本框 阴影 shadow SpanString 超链接的文本框 解析HTML标签
 * 
 * 基本组件  单选框 多选框 进度条
 * 1、模糊进度条
 * 	圈圈
 * 	水平
 * 2、精确进度条
 * drawable 状态资源 
 * shape 外观资源
 * --动画资源
 * 样式 外观资源
 * dimens.xml 尺寸资源
 * styles.xml 样式资源
 * 
 * @author Administrator
 *
 */
public class MainActivity extends Activity {
	EditText nameEt;
	EditText pwdEt;
	RadioButton maleRb;
	RadioButton femaleRb;
	CheckBox fireCb;
	CheckBox waterCb;
	CheckBox sandCb;
	ProgressBar progressBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		nameEt=(EditText)findViewById(R.id.nameEt);
		pwdEt=(EditText)findViewById(R.id.pwdEt);
		maleRb=(RadioButton)findViewById(R.id.maleRb);
		femaleRb=(RadioButton)findViewById(R.id.femaleRb);
		fireCb=(CheckBox)findViewById(R.id.fireCb);
		waterCb=(CheckBox)findViewById(R.id.waterCb);
		sandCb=(CheckBox)findViewById(R.id.sandCb);
		progressBar=(ProgressBar)findViewById(R.id.progressBar);
	
	}

	public void btnClick(View view){
		if(view.getId()==R.id.regBtn){
			StringBuilder sb=new StringBuilder();
			sb.append(nameEt.getText().toString()+pwdEt.getText().toString());
			if(maleRb.isChecked()){
				sb.append(",性别：男");
			}else{
				sb.append("，性别：女");
			}
			
			if(fireCb.isChecked()){
				sb.append("，火影");
			}
			if(waterCb.isChecked()){
				sb.append("，水影");
			}
			if(sandCb.isChecked()){
				sb.append("，沙影");
			}
			Toast.makeText(this,sb.toString(),Toast.LENGTH_LONG).show();
		}
	}
}
