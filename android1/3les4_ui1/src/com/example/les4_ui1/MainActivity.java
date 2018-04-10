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
 * ���񲼾� rowCount ָ������ columnCount ָ������ rowSpan ���� columnSpan ���� gravity ���뷽ʽ
 * �ؼ��ڲ������ݶ��뷽ʽ layout_gravity ���뷽ʽ �ؼ��ڸ�����������Ķ��뷽ʽ weight ���� Ȩ�� ��ʣ�µĿռ� padding
 * �ڱ߾�
 * 
 * UI���� �ؼ� ��ť ����¼����� 1��ֱ�����������ڲ�������� 2�������Զ�������� 3��xml���ü����� Button ��ť TextView �ı���
 * EditText ����� ��ɫ�ı�ʾ���� ʮ������ ff ff ff �༭�򡣡��� ��ҵ���ı���������� �����Ч��
 * 
 * ����html��ǩ <a> <img> <br>
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
	String str1 = "������ҳ��http://www.baidu.com���˵绰13987654321����������wvcylinder16@gmail.com";
	String strColor = "��һ�������Ǻ�ɫ����һ������ɫ����һ�������ǻ�ɫ��������ɫ";
	String strHtml = "<img src='face1.PNG'>����1<img src='face2.PNG'>����2";

	/*
	 * public void btnClick(View view) {
	 * 
	 * if (view.getId() == R.id.btn1) { Log.d("TAG", "xml����1"); } else if
	 * (view.getId() == R.id.btn2) { Log.d("TAG", "xml����2"); }
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

		// ���ö������
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
		// 1����ʲô2���ӵڼ�����ʼ3�����ڼ�������4���Ƿ񼤻�
		ss.setSpan(new ClickableSpan() {

			@Override
			public void onClick(View arg0) {
				// �򿪽���
				 /*Intent intent=new Intent(Intent.ACTION_VIEW);
				 intent.setData(Uri.parse("http://www.baidu.com/"));
				 MainActivity.this.startActivity(intent);*/
				 
				// �򿪷����������
				Intent intent = new Intent(Intent.ACTION_SEND);
				intent.setData(Uri.parse("mailto:wvcylinder16@gmail.com"));
				MainActivity.this.startActivity(intent);
			}
		}, 5, 25, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

		ss.setSpan(new ClickableSpan() {
			@Override
			public void onClick(View arg0) {
				// �򿪲��Ž���
				Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:13850734494")); 
			    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
			    MainActivity.this.startActivity(intent);
			}
		}, 30, 40, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

		tv1.setText(ss);

		tv1.setTextColor(Color.parseColor("#ff0000"));

		// �����ı�������
		tv1.setAutoLinkMask(Linkify.ALL);
		// �����ı��򼤻�
		tv1.setMovementMethod(LinkMovementMethod.getInstance());

		// �����ı���ͬ��ɫ
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

		// ������ֱ���
		ssColor.setSpan(new CharacterStyle() {

			@Override
			public void updateDrawState(TextPaint paint) {
				// TODO Auto-generated method stub
				paint.setColor(Color.YELLOW);
				paint.bgColor = Color.GREEN;
			}
		}, 17, strColor.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
		tv.setText(ssColor);

		// ��ҳ��ǩ
		Spanned span = Html.fromHtml(strHtml, new Html.ImageGetter() {

			@Override
			public Drawable getDrawable(String str) {
				// TODO Auto-generated method stub
				Drawable draw = null;
				if ("face1.PNG".equals(str)) {
					// ��ȡ��һ�ű���
					draw = getResources().getDrawable(R.drawable.face1);
					// ����ͼƬ�ߴ�
					draw.setBounds(0, 0, draw.getIntrinsicWidth(),
							draw.getIntrinsicHeight());
				} else if ("face2.PNG".equals(str)) {
					draw = getResources().getDrawable(R.drawable.face2);
					// ����ͼƬ�ߴ�
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
