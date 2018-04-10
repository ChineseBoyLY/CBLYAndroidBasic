package com.renwen.showimage;

import com.loopj.android.image.SmartImageView;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
//http://c.hiphotos.baidu.com/image/w%3D310/sign=f943161d17ce36d3a20485310af13a24/55e736d12f2eb93839a69035d7628535e4dd6f2a.jpg
public class MainActivity extends Activity {

	private EditText et;
	private SmartImageView siv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et=(EditText) findViewById(R.id.et);
		siv=(SmartImageView) findViewById(R.id.siv);
	}

	public void btnClick(View view){
//		String url = et.getText().toString().trim();
		String url = "http://c.hiphotos.baidu.com/image/w%3D310/sign=f943161d17ce36d3a20485310af13a24/55e736d12f2eb93839a69035d7628535e4dd6f2a.jpg";
		siv.setImageUrl(url, R.drawable.a, R.drawable.b);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
