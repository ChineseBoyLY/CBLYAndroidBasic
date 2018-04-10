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
			//�򵥶Ի���
			Dialog dialog=new AlertDialog.Builder(this)
			.setTitle("����")
			.setIcon(R.drawable.ic_launcher)
			.setMessage("��Ϣ").show();
			
		}else if(view.getId()==R.id.btndialog2){
			//��ť�Ի���
			Dialog dialog=new AlertDialog.Builder(this)
			.setIcon(R.drawable.ic_launcher)
			.setTitle("��ť")
			.setMessage("�Ƿ�")
			.setNegativeButton("��",new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Log.d("TAG", "no");
				}
			})
			.setPositiveButton("��", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Log.d("TAG","yes");
				}
			})
			.setNeutralButton("�м�", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Log.d("TAG","�м�");
				}
			})
			.show();
		}else if(view.getId()==R.id.btndialog3){
			//��ѡ�б�
			Dialog dialog=new AlertDialog.Builder(this)
			.setIcon(R.drawable.ic_launcher)
			.setTitle("��ѡ")//1������ 2��Ĭ��ѡ��3���������
			.setSingleChoiceItems(new String[]{"��ɳ","��̶","����"}, 0, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Log.d("TAG",""+which);
				}
			})
			.setNegativeButton("ȷ��",new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Log.d("TAG","ȷ��");
				}
			})
			.setPositiveButton("ȡ��",new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Log.d("TAG","ȡ��");
				}
			})
			.show();
		}else if(view.getId()==R.id.btndialog4){
			//��ѡ
			Dialog dialog=new AlertDialog.Builder(this)
			.setIcon(R.drawable.ic_launcher)
			.setTitle("��ѡ")//1����ѡ����2����ѡĬ��ѡ����3��ѡ�������
			.setMultiChoiceItems(new String[]{"����","����è","����"}, new boolean[]{true,true,false}, new DialogInterface.OnMultiChoiceClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which, boolean isChecked) {
					// TODO Auto-generated method stub
					Log.d("TAG","which="+which+",isChecked="+isChecked);
				}
			})
			.show();
		}else if(view.getId()==R.id.btndialog5){
			//�Զ���Ի���
			/*Dialog dialog=new AlertDialog.Builder(this)
			.setMessage("�Զ���").show();*/
			MyDialog dialog=new MyDialog(this);
		
			dialog.show();
		}/*else if(view.getId()==R.id.dialogBtn){
			//
			Log.d("TAG","�Ի���ȷ��");
		}*/
	}
	


}
