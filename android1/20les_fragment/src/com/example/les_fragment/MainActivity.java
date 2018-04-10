package com.example.les_fragment;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

/**
 * fragment 给屏幕分区分功能
 * 碎片
 * 现在手机平板屏幕很大 分区
 * 1、减少工程开发周期
 * 2、减少单个开发人员任务
 * 3、提高界面之间耦合程度
 * 4、本地化
 * sw-600dp由屏幕最小的边决定
 * 5、整体移动,替换局部组件
 * 	fragment堆栈
 * 
 * 6、fragment生命周期 跟activity的生命周期方法 交替执行 先创建fragment 先销毁fragment
 * 3.0以后才有  在android3.0之后才有平板
 * 步骤
 * 1、确定屏幕分区状况
 * 2、根据屏幕分区指定fragment标签
 * 3、指定fragment显示代码（显示内容）
 * 4、fragment标签跟类对应
 * 
 * 如果是在fragment里面调用getActivity（）方法
 * 表示获得这个fragment所在activity对象
 * @author kulv16
 *
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
}
