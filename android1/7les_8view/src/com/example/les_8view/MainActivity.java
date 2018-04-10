package com.example.les_8view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.Window;


/**
 * View  能够在屏幕上看到的视图组件 继承View
 * ViewGroup  容器类 布局类
 * TextView		组件
 * View构造方法 
 * 1、View(Context ctx) 如果需要从代码构建视图
 * 2、View(Context ctx,AttributeSet attri) 如果需要从xml里面构建视图
 * onDraw方法 画笔 Paint 决定绘制东西颜色粗细 
 * 画布canvas	决定形状
 * 颜色的方案
 * 1、16位
 * 2、32位
 * 
 * List 有序 Set 无序  Map  数组
 * 键值对方式
 * 作业 实现无缝滚动
 * @author Administrator
 *
 */
public class MainActivity extends Activity {
	MyView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        view=(MyView)findViewById(R.id.myview);
        
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
    	Log.d("TAG","X="+event.getX()+"，y="+event.getY());
    	Rain r=new Rain();
    	r.x=event.getX();
    	r.y=event.getY();
    	//添加水滴对象到集合
    	view.addRain(r);
    	//刷新视图
    	view.invalidate();
    	return super.onTouchEvent(event);
    }
}
