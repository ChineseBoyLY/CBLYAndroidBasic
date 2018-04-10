package com.example.viewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

public class TweenAnim extends View {  
    
    //Alpha���� - ����͸����  
    private Animation alphaAnimation = null;  
      
    //Sacle���� - ����ߴ�����  
    private Animation scaleAnimation = null;  
      
    //Translate���� - λ���ƶ�  
    private Animation translateAnimation = null;  
      
    //Rotate���� - ������ת  
    private Animation rotateAnimation = null;  
     
    public TweenAnim(Context context) {  
        super(context);  
    }  
    @Override  
    protected void onDraw(Canvas canvas) {  
        super.onDraw(canvas);  
        Log.e("Tween", "onDraw");  
        //����һ��ͼƬ  
        canvas.drawBitmap(((BitmapDrawable)getResources().getDrawable(R.drawable.ic_launcher)).getBitmap(), 0, 0, null);  
    }  
    @Override  
    public boolean onKeyDown(int keyCode, KeyEvent event) {  
        Log.e("Tween", "onKeyDown");  
        return true;  
    }  
    @Override  
    public boolean onKeyUp(int keyCode, KeyEvent event) {  
        Log.e("Tween", "onKeyDown");  
        switch (keyCode) {  
            case KeyEvent.KEYCODE_DPAD_UP:  
                Log.e("Tween", "onKeyDown - KEYCODE_DPAD_UP");  
                alphaAnimation = new AlphaAnimation(0.1f, 1.0f);  
                //���ö���ʱ��  
                alphaAnimation.setDuration(3000);  
                this.startAnimation(alphaAnimation);  
                break;  
            case KeyEvent.KEYCODE_DPAD_DOWN:  
                Log.e("Tween", "onKeyDown - KEYCODE_DPAD_DOWN");  
                rotateAnimation = new RotateAnimation(0f, 360f);  
                rotateAnimation.setDuration(1000);  
                this.startAnimation(rotateAnimation);  
                break;  
            case KeyEvent.KEYCODE_DPAD_LEFT:  
                Log.e("Tween", "onKeyDown - KEYCODE_DPAD_LEFT");  
                //��ʼ��  
                scaleAnimation = new ScaleAnimation(0.1f, 1.0f,0.1f,1.0f);  
                //���ö���ʱ��  
                scaleAnimation.setDuration(500);  
                this.startAnimation(scaleAnimation);  
                break;  
            case KeyEvent.KEYCODE_DPAD_RIGHT:  
                Log.e("Tween", "onKeyDown - KEYCODE_DPAD_RIGHT");  
                //��ʼ��  
                translateAnimation = new TranslateAnimation(0.1f, 100.0f,0.1f,100.0f);  
                //���ö���ʱ��  
                translateAnimation.setDuration(1000);  
                  
                this.startAnimation(translateAnimation);  
                break;  
            case KeyEvent.KEYCODE_DPAD_CENTER:  
                Log.e("Tween", "onKeyDown - KEYCODE_DPAD_CENTER");  
                //��ʼ�� Translate����  
                translateAnimation = new TranslateAnimation(0.1f, 100.0f,0.1f,100.0f);  
                //��ʼ�� Alpha����  
                alphaAnimation = new AlphaAnimation(0.1f, 1.0f);  
                  
                //������  
                AnimationSet set = new AnimationSet(true);  
                set.addAnimation(translateAnimation);  
                set.addAnimation(alphaAnimation);  
                  
                //���ö���ʱ�� (���õ�ÿ������)  
                set.setDuration(1000);  
                this.startAnimation(set);  
                break;  
            default:  
                break;  
        }  
        return true;  
    }  
      
}  
