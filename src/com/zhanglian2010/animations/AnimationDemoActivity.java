package com.zhanglian2010.animations;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.zhanglian2010.R;

public class AnimationDemoActivity extends Activity {

	private Button alphaButton;
	private Button rotateButton;
	private Button scaleButton;
	private Button translateButton;
	
	private ImageView iv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animation_demo);
		
		alphaButton = (Button) findViewById(R.id.alphaId);
		alphaButton.setOnClickListener(new AlphaButtonListener());
		
		rotateButton = (Button) findViewById(R.id.rotateId);
		rotateButton.setOnClickListener(new RotateButtonListener());
		
		scaleButton = (Button) findViewById(R.id.scaleId);
		scaleButton.setOnClickListener(new ScaleButtonListener());
		
		translateButton = (Button) findViewById(R.id.translateId);
		translateButton.setText("this is a test text...");
		translateButton.setOnClickListener(new TranslateButtonListener());
		
		iv = (ImageView) findViewById(R.id.imageViewId);
	}

	class AlphaButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
//			//动画集
//			AnimationSet set = new AnimationSet(true);
//			
//			//alpha动画（1渐变到0）
//			AlphaAnimation alpha = new AlphaAnimation(1, 0);
//			//动画执行时间
//			alpha.setDuration(1000);
//			
//			//添加到动画集
//			set.addAnimation(alpha);
//
//			//ImageView开始动画
//			iv.startAnimation(set);
			
			
			
//			//通过xml实现动画
//			Animation animation = AnimationUtils.loadAnimation(AnimationDemoActivity.this, R.anim.alpha);
//			iv.startAnimation(animation);
			
			
			
			//通过AnimationSet统一多个动画（AnimationSet是Animation的子类）
			AnimationSet set = new AnimationSet(true);
			
			//设置Interpolator
			set.setInterpolator(new AccelerateInterpolator());
			
			AlphaAnimation alpha = new AlphaAnimation(1.0f, 0.0f);
			RotateAnimation rotate = new RotateAnimation(0, 360, 
					Animation.RELATIVE_TO_SELF, 0.5f,
					Animation.RELATIVE_TO_SELF, 0.5f);
			
			set.addAnimation(rotate);
			set.addAnimation(alpha);
			
			//set统一设置参数，作用于所有set中的动画
			set.setDuration(1000);
			set.setStartOffset(500);
			
			iv.startAnimation(set);
		}
		
	}
	
	class RotateButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			//动画集
//			AnimationSet set = new AnimationSet(true);
//			
//			//rotate动画
//			RotateAnimation rotate = new RotateAnimation(0, 360, 
//					Animation.RELATIVE_TO_PARENT, 1f,
//					Animation.RELATIVE_TO_PARENT, 0f);
//			//动画执行时间
//			rotate.setDuration(1000);
//			
//			//添加到动画集
//			set.addAnimation(rotate);
//
//			//ImageView开始动画
//			iv.startAnimation(set);
			
			
			
			Animation anim = AnimationUtils.loadAnimation(AnimationDemoActivity.this, R.anim.rotate);
			iv.startAnimation(anim);
			
			
		}
		
	}
	
	class ScaleButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			//动画集
//			AnimationSet set = new AnimationSet(true);
//			
//			//scale动画
//			ScaleAnimation rotate = new ScaleAnimation(1, 0.1f, 
//					1, 0.1f, 
//					Animation.RELATIVE_TO_SELF, 0.5f,
//					Animation.RELATIVE_TO_SELF, 0.5f );
//			//动画执行时间
//			rotate.setDuration(2000);
//			
//			//添加到动画集
//			set.addAnimation(rotate);
//
//			//ImageView开始动画
//			iv.startAnimation(set);
			
			Animation anim = AnimationUtils.loadAnimation(AnimationDemoActivity.this, R.anim.scale);
			iv.startAnimation(anim);
		}
		
	}
	
	class TranslateButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			//动画集
//			AnimationSet set = new AnimationSet(true);
//			
//			//translate动画
//			TranslateAnimation rotate = new TranslateAnimation(
//					Animation.RELATIVE_TO_SELF, 0f,
//					Animation.RELATIVE_TO_SELF, 0.5f,
//					Animation.RELATIVE_TO_SELF, 0f,
//					Animation.RELATIVE_TO_SELF, 1.0f);
//			//动画执行时间
//			rotate.setDuration(1000);
//			
//			//添加到动画集
//			set.addAnimation(rotate);
//
//			//ImageView开始动画
//			iv.startAnimation(set);
			
			
			Animation anim = AnimationUtils.loadAnimation(AnimationDemoActivity.this, R.anim.translate);
			iv.startAnimation(anim);
			
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.animation, menu);
		return true;
	}

}
