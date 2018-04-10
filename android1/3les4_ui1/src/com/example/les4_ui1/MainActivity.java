package com.example.les4_ui1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.util.Linkify;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * 网格布局 rowCount 指定行数 columnCount 指定列数 rowSpan 跨行 columnSpan 跨列 gravity 对齐方式
 * 控件内部的内容对齐方式 layout_gravity 对齐方式 控件在父级容器里面的对齐方式 weight 比例 权重 吃剩下的空间 padding
 * 内边距
 * 
 * UI界面 控件 按钮 点击事件监听 1、直接设置匿名内部类监听器 2、设置自定义监听器 3、xml设置监听器 Button 按钮 TextView 文本框
 * EditText 输入框 颜色的表示方案 十六进制 ff ff ff 编辑框。。。 作业：文本框滚动文字 跑马灯效果
 * 
 * 解析html标签 <a> <img> <br>
 * <p>
 * <div> ...
 * 
 * @author Administrator
 * 
 */
public class MainActivity extends Activity {
	TextView tv;
	TextView tv1;
	TextView tvhtml;
	String str1 = "个人主页：http://www.baidu.com个人电话13987654321本人邮箱是wvcylinder16@gmail.com";
	String strColor = "这一段文字是红色，这一段是蓝色，这一段文字是黄色背景是绿色";
	String strHtml = "<img src='face1.PNG'>表情1<img src='face2.PNG'>表情2";

	/*
	 * public void btnClick(View view) {
	 * 
	 * if (view.getId() == R.id.btn1) { Log.d("TAG", "xml监听1"); } else if
	 * (view.getId() == R.id.btn2) { Log.d("TAG", "xml监听2"); }
	 * 
	 * }
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		 Button btn = (Button) findViewById(R.id.btn);
		// Button btn2 = (Button) findViewById(R.id.btn2);
		// Button btn2 = (Button) findViewById(R.id.btn2);
		// EditText eidt = (EditText) findViewById(R.id.edit);

		// 设置对象监听
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:13850734494")); 
			    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
			    startActivity(intent);

			}
		});

//		MyListener listen = new MyListener();
//		btn1.setOnClickListener(listen);
//		btn2.setOnClickListener(listen);

		tv = (TextView) findViewById(R.id.tv);
		tv1 = (TextView) findViewById(R.id.tv1);
		tvhtml = (TextView) findViewById(R.id.tvhtml);

		SpannableString ss = new SpannableString(str1);
		// 1、做什么2、从第几个开始3、到第几个结束4、是否激活
		ss.setSpan(new ClickableSpan() {

			@Override
			public void onClick(View arg0) {
				// 打开界面
				 /*Intent intent=new Intent(Intent.ACTION_VIEW);
				 intent.setData(Uri.parse("http://www.baidu.com/"));
				 MainActivity.this.startActivity(intent);*/
				 
				// 打开发送邮箱界面
				Intent intent = new Intent(Intent.ACTION_SEND);
				intent.setData(Uri.parse("mailto:wvcylinder16@gmail.com"));
				MainActivity.this.startActivity(intent);
			}
		}, 5, 25, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

		ss.setSpan(new ClickableSpan() {
			@Override
			public void onClick(View arg0) {
				// 打开拨号界面
				Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:13850734494")); 
			    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
			    MainActivity.this.startActivity(intent);
			}
		}, 30, 40, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

		tv1.setText(ss);

		tv1.setTextColor(Color.parseColor("#ff0000"));

		// 设置文本框超链接
		tv1.setAutoLinkMask(Linkify.ALL);
		// 设置文本框激活
		tv1.setMovementMethod(LinkMovementMethod.getInstance());

		// 设置文本框不同颜色
		SpannableString ssColor = new SpannableString(strColor);

		ssColor.setSpan(new CharacterStyle() {

			@Override
			public void updateDrawState(TextPaint paint) {
				paint.setColor(Color.RED);
			}
		}, 0, 7, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

		ssColor.setSpan(new CharacterStyle() {

			@Override
			public void updateDrawState(TextPaint paint) {
				// TODO Auto-generated method stub
				paint.setColor(Color.BLUE);
			}
		}, 9, 15, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

		// 添加文字背景
		ssColor.setSpan(new CharacterStyle() {

			@Override
			public void updateDrawState(TextPaint paint) {
				// TODO Auto-generated method stub
				paint.setColor(Color.YELLOW);
				paint.bgColor = Color.GREEN;
			}
		}, 17, strColor.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
		tv.setText(ssColor);

		// 网页标签
		Spanned span = Html.fromHtml(strHtml, new Html.ImageGetter() {

			@Override
			public Drawable getDrawable(String str) {
				// TODO Auto-generated method stub
				Drawable draw = null;
				if ("face1.PNG".equals(str)) {
					// 读取第一张表情
					draw = getResources().getDrawable(R.drawable.face1);
					// 设置图片尺寸
					draw.setBounds(0, 0, draw.getIntrinsicWidth(),
							draw.getIntrinsicHeight());
				} else if ("face2.PNG".equals(str)) {
					draw = getResources().getDrawable(R.drawable.face2);
					// 设置图片尺寸
					draw.setBounds(0, 0, draw.getIntrinsicWidth(),
							draw.getIntrinsicHeight());
				}
				return draw;
			}
		}, null);
		tvhtml.setText(span);
		tvhtml.setMovementMethod(LinkMovementMethod.getInstance());
	}
}
