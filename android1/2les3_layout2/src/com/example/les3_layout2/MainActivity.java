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
 * 网格布局 4.0
 * 
 * 像素单位 px		像素单位
 * 		 sp 	放大像素   设置字体大小
 * 		pt 		磅
 * 		dip		每平方英寸多少像素  设置控件的高度宽度单位 
 * 		gravity	对齐方式	控件内部内容对齐方式
 * 		layout_gravity	对齐方式	控件在父级容器里面的对齐方式
 * 		layout_weight  比例 权重  哪个控件写了该属性 哪个控件最后才被摆上去 吃剩下的
 * 		margin	控件外部距离
 * 		padding 控件内部距离
 * 
 * 		hint 输入框的提示内容
 * 
 * Activity 从context上下文继承
 * 
 * View ViewGroup widget包 
 * 
 * 	代码布局  如果需要生成很多类似控件
 * LinearLayout 父类 ViewGroup extends View
 * findViewById 前提：setContentView()
 * 调试信息 e w i d v 
 * 作业：代码网格布局
 * @author Administrator
 *
 */
public class MainActivity extends Activity {

//	设置组件 跨多少行 跨多少列
	private void setSpanRowCol(GridLayout grid, Button btn, int start, int row,
			int col) {
		GridLayout.LayoutParams par = new GridLayout.LayoutParams();
		par.rowSpec = GridLayout.spec(start, col);
		par.columnSpec = GridLayout.spec(start, row);
		btn.setLayoutParams(par);
		grid.addView(btn);
	}
//   指定所在的行和列
	private void setRowCol(GridLayout grid, Button btn, int row, int col) {
		// 指定该组件所在的行
		GridLayout.Spec rowSpec = GridLayout.spec(row);
		// 指定该组件所在列
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
        
        //Context上下文类型对象
        LinearLayout layout=new LinearLayout(this);
        //往布局里面添加元素
        Button btn=new Button(this);
        btn.setText("asdf");
        btn.setLayoutParams(params);
        layout.addView(btn);
        setContentView(layout);*/
        
        /*LayoutParams params=new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        
        //最外层的线性布局
        LinearLayout layout1=new LinearLayout(this);
        //设置最外层布局方向
        layout1.setOrientation(LinearLayout.VERTICAL);
        
        //第一行
        LinearLayout layout2=new LinearLayout(this);
        layout2.setOrientation(LinearLayout.HORIZONTAL);
        TextView tv=new TextView(this);
        //设置布局参数
        tv.setLayoutParams(params);
        tv.setText("用户名");
        tv.setTextSize(30);
        //添加用户名文本框
        layout2.addView(tv);
        EditText edit=new EditText(this);
        edit.setLayoutParams(params);
        layout2.addView(edit);
        layout1.addView(layout2);
        
        //第二行
        LinearLayout layout3=new LinearLayout(this);
        layout3.setOrientation(LinearLayout.HORIZONTAL);
        TextView tv3=new TextView(this);
        //设置布局参数
        tv3.setLayoutParams(params);
        tv3.setText("密码");
        tv3.setTextSize(30);
        //添加用户名文本框
        layout3.addView(tv3);
        EditText edit3=new EditText(this);
        edit3.setLayoutParams(params);
        layout3.addView(edit3);
        layout1.addView(layout3);
        
        
        setContentView(layout1);*/
        
        setContentView(R.layout.activity_main);
        LinearLayout layout1=(LinearLayout)findViewById(R.id.layout1);
        //TextView tv=(TextView)findViewById(R.id.tv);
       // tv.setText("你好世界");
        System.out.println("调试信息");
        Log.d("com.example.layout2","debug级别信息");
        Log.v("com.example.layout3","verbose级别信息");
        Log.w("com.example.layout4","warn级别信息");
        Log.e("com.example.layout5","error级别信息");
        Log.i("com.example.layout6","info级别信息");
        
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
