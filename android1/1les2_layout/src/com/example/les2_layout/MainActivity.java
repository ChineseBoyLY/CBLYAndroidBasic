package com.example.les2_layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
/**
 * src	源代码目录
 * gen	R文件映射资源ID（自动生成）
 * assets	资源目录 不会被编译
 * res		资源目录 会被编译
 * 	drawable 图片
 * 	layout	布局文件
 * 	menu	菜单布局
 * 	values	
 * 		string.xml 字符串
 * 		style.xml	样式文件
 * 		dimens.xml	定义尺寸资源
 * 布局 控制元素出现在屏幕上位置
 * 
 * 单位 sp dip  
 * 
 * 1、线性布局
 * 	以直线的方向确定元素排列位置 
 * 	默认方向，水平
 * android:orientation 指定线性布局的排布方向	vertical horizontal
 * 视图里面可以包含视图 布局里面可以嵌套布局 （任意布局）
 * 
 * 2、相对布局
 * 		里面所有元素位置都是相对于其他控件的位置
 * 		如果没有给元素指定任何位置信息，默认会出现在屏幕的左上顶点
 * 		android:layout_above=""
 * 		android:layout_below=""
 * 		android:layout_toRightOf=""
 * 		android:layout_toLeftOf=""
 * 3、绝对布局
 * 		根据屏幕的坐标系确定元素位置
 * 4、帧布局
 * 		每个元素都是单独的一帧,通过控制离父级容器边界距离
 * 		marginBottom 子控件的边框离父级容器距离（底部
 * 		layout_marg 一次指定上下左右四个距离
 * 5、表格布局
 * 		通过表格的行列控制元素位置
 * 		行数列数确定
 * 		确定行数：有多少个子标签就有多少行，根据子标签个数确定行数
 * 		确定列数：每个<TableRow>里面有几个元素，有几列
 * 6、网格布局 4.0 以后
 * 作业：计算器界面1-9按钮
 * 代码布局
 * @author kulv16
 *
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.absolte_layout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
