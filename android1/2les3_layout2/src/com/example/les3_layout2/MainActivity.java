package com.example.les3_layout2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;

/**
 * ���񲼾� 4.0
 * 
 * ���ص�λ px		���ص�λ
 * 		 sp 	�Ŵ�����   ���������С
 * 		pt 		��
 * 		dip		ÿƽ��Ӣ���������  ���ÿؼ��ĸ߶ȿ�ȵ�λ 
 * 		gravity	���뷽ʽ	�ؼ��ڲ����ݶ��뷽ʽ
 * 		layout_gravity	���뷽ʽ	�ؼ��ڸ�����������Ķ��뷽ʽ
 * 		layout_weight  ���� Ȩ��  �ĸ��ؼ�д�˸����� �ĸ��ؼ����ű�����ȥ ��ʣ�µ�
 * 		margin	�ؼ��ⲿ����
 * 		padding �ؼ��ڲ�����
 * 
 * 		hint ��������ʾ����
 * 
 * Activity ��context�����ļ̳�
 * 
 * View ViewGroup widget�� 
 * 
 * 	���벼��  �����Ҫ���ɺܶ����ƿؼ�
 * LinearLayout ���� ViewGroup extends View
 * findViewById ǰ�᣺setContentView()
 * ������Ϣ e w i d v 
 * ��ҵ���������񲼾�
 * @author Administrator
 *
 */
public class MainActivity extends Activity {

//	������� ������� �������
	private void setSpanRowCol(GridLayout grid, Button btn, int start, int row,
			int col) {
		GridLayout.LayoutParams par = new GridLayout.LayoutParams();
		par.rowSpec = GridLayout.spec(start, col);
		par.columnSpec = GridLayout.spec(start, row);
		btn.setLayoutParams(par);
		grid.addView(btn);
	}
//   ָ�����ڵ��к���
	private void setRowCol(GridLayout grid, Button btn, int row, int col) {
		// ָ����������ڵ���
		GridLayout.Spec rowSpec = GridLayout.spec(row);
		// ָ�������������
		GridLayout.Spec columnSpec = GridLayout.spec(col);
		GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec,
				columnSpec);
		grid.addView(btn, params);
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* 
        GridLayout grid = (GridLayout) findViewById(R.id.grid);
		LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		grid.setColumnCount(3);
		grid.setRowCount(3);
      
		for (int i = 0; i < 2; i++) {
			Button btn = new Button(this);
			btn.setText(i + "");
			btn.setTextSize(60);
			btn.setLayoutParams(params);
			btn.setId(i);
			grid.addView(btn);
		}
		Button btn = (Button) findViewById(1);
		grid.removeView(btn);
		setSpanRowCol(grid,btn,1,2,2);*/
		
		
  /*      LayoutParams params=new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        
        //Context���������Ͷ���
        LinearLayout layout=new LinearLayout(this);
        //�������������Ԫ��
        Button btn=new Button(this);
        btn.setText("asdf");
        btn.setLayoutParams(params);
        layout.addView(btn);
        setContentView(layout);*/
        
        /*LayoutParams params=new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        
        //���������Բ���
        LinearLayout layout1=new LinearLayout(this);
        //��������㲼�ַ���
        layout1.setOrientation(LinearLayout.VERTICAL);
        
        //��һ��
        LinearLayout layout2=new LinearLayout(this);
        layout2.setOrientation(LinearLayout.HORIZONTAL);
        TextView tv=new TextView(this);
        //���ò��ֲ���
        tv.setLayoutParams(params);
        tv.setText("�û���");
        tv.setTextSize(30);
        //����û����ı���
        layout2.addView(tv);
        EditText edit=new EditText(this);
        edit.setLayoutParams(params);
        layout2.addView(edit);
        layout1.addView(layout2);
        
        //�ڶ���
        LinearLayout layout3=new LinearLayout(this);
        layout3.setOrientation(LinearLayout.HORIZONTAL);
        TextView tv3=new TextView(this);
        //���ò��ֲ���
        tv3.setLayoutParams(params);
        tv3.setText("����");
        tv3.setTextSize(30);
        //����û����ı���
        layout3.addView(tv3);
        EditText edit3=new EditText(this);
        edit3.setLayoutParams(params);
        layout3.addView(edit3);
        layout1.addView(layout3);
        
        
        setContentView(layout1);*/
        
        setContentView(R.layout.activity_main);
        LinearLayout layout1=(LinearLayout)findViewById(R.id.layout1);
        //TextView tv=(TextView)findViewById(R.id.tv);
       // tv.setText("�������");
        System.out.println("������Ϣ");
        Log.d("com.example.layout2","debug������Ϣ");
        Log.v("com.example.layout3","verbose������Ϣ");
        Log.w("com.example.layout4","warn������Ϣ");
        Log.e("com.example.layout5","error������Ϣ");
        Log.i("com.example.layout6","info������Ϣ");
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
