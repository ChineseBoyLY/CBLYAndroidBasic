package com.example.viewflipperdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

public class ViewFlipperView extends FrameLayout implements IAdImages {

	 private Context context;                           // ���÷���������  
	    private int currentAdImgIndex;                     // ��ǰ���ͼƬ����  
	    private Animation left2RightInAnimation;           // ���ͼƬ�����ҽ�����Ļ����  
	    private Animation left2RightOutAnimation;          // ���ͼƬ�����ҳ�ȥ��Ļ����  
	    private Animation right2LeftInAnimation;           // ���ͼƬ���ҵ��������Ļ����  
	    private Animation right2LeftOutAnimation;          // ���ͼƬ���ҵ����ȥ��Ļ����  
	    private int animationDuration = 500;               // ��������ʱ��500����  
	    private ViewFlipper mViewFlipper;                  // ����ҳ��ؼ�  
	    private LinearLayout mTipLinearLayout;             // �·����ؼ�  
	    private float startX = 0;                          // touch action down ʱ��x����  
	    private float endX = 0;                            // touch action up ʱ��x����  
	      
	      
	    public ViewFlipperView(Context context, AttributeSet attrs, int defStyle) {  
	        super(context, attrs, defStyle);  
	        this.context = context;  
	        setView();  
	    }  
	  
	    public ViewFlipperView(Context context, AttributeSet attrs) {  
	        super(context, attrs);  
	        this.context = context;  
	        setView();  
	    }  
	  
	    public ViewFlipperView(Context context) {  
	        super(context);  
	        this.context = context;  
	        setView();  
	    }  
	  
	    /** 
	     * ��ʾView 
	     */  
	    private void setView(){  
	          
	        // ��ʼ��  
	        int screenWidth = getResources().getDisplayMetrics().widthPixels;  
	        mViewFlipper = new ViewFlipper(context);  
	        mTipLinearLayout = new LinearLayout(context);  
	        // ��ʼ������  
	        left2RightInAnimation = new TranslateAnimation(-screenWidth, 0, 0, 0);  
	        left2RightInAnimation.setDuration(animationDuration);  
	        left2RightOutAnimation = new TranslateAnimation(0, screenWidth, 0, 0);  
	        left2RightOutAnimation.setDuration(animationDuration);  
	        right2LeftInAnimation = new TranslateAnimation(screenWidth, 0, 0, 0);  
	        right2LeftInAnimation.setDuration(animationDuration);  
	        right2LeftOutAnimation = new TranslateAnimation(0, -screenWidth, 0, 0);  
	        right2LeftOutAnimation.setDuration(animationDuration);  
	  
	          
	        // �����ͼƬ����ViewFlipper  
	        for(int i=0; i<adImages.length; i++){  
	            ImageView image = new ImageView(context);  
	            image.setImageResource(adImages[i]);  
	            mViewFlipper.addView(image);  
	        }  
	        addView(mViewFlipper);  
	          
	        // ��ͼƬ�����㶯̬����  
	        for(int i=0; i<adImages.length; i++){  
	            ImageView image = new ImageView(context);  
	            if(i == 0){  
	                image.setImageResource(R.drawable.ic_launcher);  
	            }else{  
	                image.setImageResource(R.drawable.ic_launcher);  
	            }  
	            image.setPadding(5, 0, 5, 20);  
	            mTipLinearLayout.addView(image);  
	        }  
	        // ����������Ļ�·�  
	        mTipLinearLayout.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);  
	        addView(mTipLinearLayout);  
	    }  
	      
	    @Override  
	    public boolean onTouchEvent(MotionEvent event) {  
	          
	        switch (event.getAction()) {  
	        case MotionEvent.ACTION_DOWN:  
	              
	            startX = event.getX();  
	              
	            break;  
	        case MotionEvent.ACTION_UP:  
	              
	            endX = event.getX();  
	            // �ȱ�����һ����  
	            ImageView lastTipImageView = (ImageView) mTipLinearLayout.getChildAt(currentAdImgIndex);  
	              
	            if(currentAdImgIndex > 0 && endX > startX){// �鿴ǰһҳ�Ĺ��  
	  
	                mViewFlipper.setInAnimation(left2RightInAnimation);  
	                mViewFlipper.setOutAnimation(left2RightOutAnimation);  
	                mViewFlipper.showPrevious();  
	                currentAdImgIndex--;  
	                if(currentAdImgIndex < 0){  
	                    currentAdImgIndex = 0;  
	                }  
	            }  
	              
	            if(currentAdImgIndex < adImages.length-1 && endX < startX){// �鿴��һҳ�Ĺ��  
	  
	                mViewFlipper.setInAnimation(right2LeftInAnimation);  
	                mViewFlipper.setOutAnimation(right2LeftOutAnimation);  
	                mViewFlipper.showNext();  
	                currentAdImgIndex++;  
	                if(currentAdImgIndex > adImages.length-1){  
	                    currentAdImgIndex = adImages.length-1;  
	                }  
	            }  
	              
	            // ����currentAdImgIndex�ı�ײ����״̬  
	            ImageView currTipImageView = (ImageView) mTipLinearLayout.getChildAt(currentAdImgIndex);  
//	            lastTipImageView.setImageResource(R.drawable.point_normal);  
//	            currTipImageView.setImageResource(R.drawable.point_selected);  
	            lastTipImageView.setImageResource(R.drawable.ic_launcher);  
	            currTipImageView.setImageResource(R.drawable.ic_launcher);  
	              
	            break;        
	        }     
	        return true;  
	    }  
	}  