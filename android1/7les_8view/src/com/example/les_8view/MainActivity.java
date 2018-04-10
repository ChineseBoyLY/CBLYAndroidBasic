package com.example.les_8view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.Window;


/**
 * View  �ܹ�����Ļ�Ͽ�������ͼ��� �̳�View
 * ViewGroup  ������ ������
 * TextView		���
 * View���췽�� 
 * 1��View(Context ctx) �����Ҫ�Ӵ��빹����ͼ
 * 2��View(Context ctx,AttributeSet attri) �����Ҫ��xml���湹����ͼ
 * onDraw���� ���� Paint �������ƶ�����ɫ��ϸ 
 * ����canvas	������״
 * ��ɫ�ķ���
 * 1��16λ
 * 2��32λ
 * 
 * List ���� Set ����  Map  ����
 * ��ֵ�Է�ʽ
 * ��ҵ ʵ���޷����
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
    	Log.d("TAG","X="+event.getX()+"��y="+event.getY());
    	Rain r=new Rain();
    	r.x=event.getX();
    	r.y=event.getY();
    	//���ˮ�ζ��󵽼���
    	view.addRain(r);
    	//ˢ����ͼ
    	view.invalidate();
    	return super.onTouchEvent(event);
    }
}
