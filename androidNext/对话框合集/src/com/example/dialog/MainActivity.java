package com.example.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void click(View view){
		if(view.getId()==R.id.btn1){
			AlertDialog.Builder dialog = new Builder(this);
			dialog.setTitle("标题");
			dialog.setIcon(R.drawable.ic_launcher);
			dialog.setMessage("消息。。。");
			dialog.setPositiveButton("确认", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(MainActivity.this, "Textpositive", 0).show();
				}
			});
			dialog.setNegativeButton("取消", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(MainActivity.this, "Textnegative", 0).show();
				}
			});
			dialog.show();
		}else if(view.getId()==R.id.btn2){
			new Builder(this)
				.setTitle("单选对话框")
				.setIcon(R.drawable.ic_launcher)
				.setSingleChoiceItems(new String[]{"a","b","c"}, 1, new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Log.d("TAG", "which"+which);
						//关闭对话框
						dialog.dismiss();
					}
				}).show();
		}else if(view.getId()==R.id.btn3){
			String[] items = new String[]{"a","b","c","d","e"};
			boolean[] checkedItems = new boolean[]{true,true,false,false,false};
			new Builder(this)
			.setTitle("多选选对话框")
			.setMultiChoiceItems(items,checkedItems,new OnMultiChoiceClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which, boolean isChecked) {
					Log.d("TAG", "which"+which+";isChecked:"+isChecked);
				}
			}).show();
		}else if(view.getId()==R.id.btn4){
			ProgressDialog pd = new ProgressDialog(this);
			pd.setTitle("提醒");
			pd.setMessage("正在加载中...");
			pd.show();
		}else if(view.getId()==R.id.btn5){
			final ProgressDialog pd = new ProgressDialog(this);
			pd.setTitle("正在加载...");
			pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			pd.setMax(100);
			pd.show();
			new Thread(){
				public void run() {
					for (int i = 0; i < 100; i++) {
						pd.setProgress(i);
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					pd.dismiss();
				}
			}.start();
		}
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
