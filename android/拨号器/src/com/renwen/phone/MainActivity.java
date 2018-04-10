package com.renwen.phone;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private EditText mobileText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mobileText = (EditText) findViewById(R.id.mobile);
		Button button = (Button) this.findViewById(R.id.button);
//		方法二：implements OnClickListener
		button.setOnClickListener(this);
		
//		方法一：内部类
		/*button.setOnClickListener(new ButtonClickListen());
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				callPhone();
			}
		});*/
	}
	
//	方法三：在xml中定义
	public void btnClick(View view){
		callPhone();
	}
	
	/*
	 * 方法四：
	 *
	 *为什么不另外建立一个类文件呢？
	 *		在加载到虚拟机的时候速度回快些！ 
	 */
	/*public final class ButtonClickListen implements View.OnClickListener {
		public void onClick(View v) {
			callPhone();
		}
	}*/

	private void callPhone() {
		String number = mobileText.getText().toString();
		if(TextUtils.isEmpty(number)){
			Toast.makeText(MainActivity.this, "号码不能为空", Toast.LENGTH_SHORT).show();
			return ;
		}
		//意图
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_CALL);
		//uri统一资源定位符
		intent.setData(Uri.parse("tel:"+ number));
		startActivity(intent);//方法内部会自动为Intent添加类别：android.intent.category.DEFAULT
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
			case R.id.button:
				callPhone();break;
		}
	}
}
