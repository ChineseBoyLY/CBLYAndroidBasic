package com.example.les_notification;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class DialogActivity extends Activity {
	ListView lv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dialog);
		/*LvItemClick click=new LvItemClick();
		lv.setOnItemClickListener(click);*/
	}

	public void btnClick(View view){
		if(view.getId()==R.id.btndialog1){
			//简单对话框
			Dialog dialog=new AlertDialog.Builder(this)
			.setTitle("标题")
			.setIcon(R.drawable.ic_launcher)
			.setMessage("消息").show();
			
		}else if(view.getId()==R.id.btndialog2){
			//按钮对话框
			Dialog dialog=new AlertDialog.Builder(this)
			.setIcon(R.drawable.ic_launcher)
			.setTitle("按钮")
			.setMessage("是否")
			.setNegativeButton("否",new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Log.d("TAG", "no");
				}
			})
			.setPositiveButton("是", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Log.d("TAG","yes");
				}
			})
			.setNeutralButton("中间", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Log.d("TAG","中间");
				}
			})
			.show();
		}else if(view.getId()==R.id.btndialog3){
			//单选列表
			Dialog dialog=new AlertDialog.Builder(this)
			.setIcon(R.drawable.ic_launcher)
			.setTitle("单选")//1、内容 2、默认选择3、点击监听
			.setSingleChoiceItems(new String[]{"长沙","湘潭","株洲"}, 0, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Log.d("TAG",""+which);
				}
			})
			.setNegativeButton("确定",new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Log.d("TAG","确定");
				}
			})
			.setPositiveButton("取消",new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Log.d("TAG","取消");
				}
			})
			.show();
		}else if(view.getId()==R.id.btndialog4){
			//多选
			Dialog dialog=new AlertDialog.Builder(this)
			.setIcon(R.drawable.ic_launcher)
			.setTitle("多选")//1、多选内容2、多选默认选择项3、选择监听器
			.setMultiChoiceItems(new String[]{"大雄","机器猫","鸣人"}, new boolean[]{true,true,false}, new DialogInterface.OnMultiChoiceClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which, boolean isChecked) {
					// TODO Auto-generated method stub
					Log.d("TAG","which="+which+",isChecked="+isChecked);
				}
			})
			.show();
		}else if(view.getId()==R.id.btndialog5){
			//自定义对话框
			/*Dialog dialog=new AlertDialog.Builder(this)
			.setMessage("自定义").show();*/
			MyDialog dialog=new MyDialog(this);
		
			dialog.show();
		}/*else if(view.getId()==R.id.dialogBtn){
			//
			Log.d("TAG","对话框确定");
		}*/
	}
	


}
