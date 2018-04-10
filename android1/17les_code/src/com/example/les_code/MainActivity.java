package com.example.les_code;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * 四个加载模式 standard 默认加载模式，同一个窗口可以在不同的堆栈里面实例化多次 singleTop 只有窗口处于栈顶的时候 singleTask
 * 在同一个回退栈只能有这个窗口的一个实例 singleInstance 回退栈里面只能有一个窗口实例并且只能有一个窗口 
 * requestCode  判断打开哪个界面关闭 请求码 
 * resultCode  子界面有没有传递参数回主界面
 *  	判断Intent里面的附加参数是否为空 或者子界面是否正常关闭 结果码
 *  
 * 退出应用程序方式 1、自定义集合方式退出activity, 保存所有集合的地方application 2、resultCode 只要是activity
 * 肯定是由一个intent负责启动
 * 
 * 作业 继承自定义activity 窗口对象加入到集合里面
 * 
 * 生命周期
 * 
 * ContextWrapper
 * 
 * context
 * 
 * object
 * 
 * @author kulv16
 * 
 */
public class MainActivity extends BaseActivity {
	TextView resultTv;
	/*
	 * 退出应用 
	 * 		方案1：，在每个界面都要加一个退出应用的按钮，写一个BaseActivity(onCreate()和onDestory()方法实现)
	 * 				利用application全局对面,存一个List<activity>
	 * 				然后，在AndroidManifest.xml配置文件属性里面加上 android:name="com.example.les_code.MyApplication" >
	 * 				然后，extends Application
	 */			
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		resultTv = (TextView) findViewById(R.id.resultTv);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 1) {
			if (resultCode == 3) {
				// 操作成功
				resultTv.setText(data.getStringExtra("id"));
			} 
//			else if (resultCode == app.result_exit_ok) {
//				finish();
//			}
		else if(resultCode == 4){
				// 操作失败
				resultTv.setText(data.getStringExtra("id"));
			}
		} else if (requestCode == 2) {
			resultTv.setText("设置wifi");
		}
	}

	public void btnClick(View view) {
		Intent intent = null;
		if (view.getId() == R.id.btn1) {
			// 语言
			intent = new Intent();
			// 设置附加参数
			intent.putExtra("name", "zz");
			intent.setClass(this, LanguageActivity.class);
			startActivityForResult(intent, 1);
		} else if (view.getId() == R.id.btn2) {
			// wifi
			intent=new Intent(); intent.setClass(this,WifiActivity.class);
			//startActivity(intent);
			startActivityForResult(intent, 2);
		}
	}

}
