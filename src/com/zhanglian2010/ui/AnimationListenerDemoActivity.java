package com.zhanglian2010.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageView;

public class AnimationListenerDemoActivity extends Activity {

	
	private Button addButton;
	private Button removeButton;
	
	private ImageView imageView;
	private ViewGroup viewGroup;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animation_listener_demo);
		
		addButton = (Button) findViewById(R.id.addButtonId);
		addButton.setOnClickListener(new AddButtonListener());
		
		removeButton = (Button) findViewById(R.id.removeButtonId);
		removeButton.setOnClickListener(new RemoveButtonListener());
		
		imageView = (ImageView) findViewById(R.id.imageViewId);
		viewGroup = (ViewGroup) findViewById(R.id.layoutId);
	}

	
	private class AddButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
			anim.setDuration(1000);
			anim.setStartOffset(500);
			
			ImageView imageViewAdd = new ImageView(AnimationListenerDemoActivity.this);
			imageViewAdd.setImageResource(R.drawable.ic_launcher);
			
			viewGroup.addView(imageViewAdd, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			imageViewAdd.startAnimation(anim);
		}
		
	}
	
	private class RemoveButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			AlphaAnimation anim = new AlphaAnimation(1.0f, 0.0f);
			anim.setDuration(1000);
			anim.setStartOffset(500);
			anim.setAnimationListener(new RemoveAnimationListener());
			imageView.startAnimation(anim);
		}
		
	}
	
	private class RemoveAnimationListener implements AnimationListener {

		@Override
		public void onAnimationStart(Animation animation) {
			System.out.println("start...");
		}

		@Override
		public void onAnimationEnd(Animation animation) {
			System.out.println("end...");
			viewGroup.removeView(imageView);
		}

		@Override
		public void onAnimationRepeat(Animation animation) {
			System.out.println("repeat...");
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.animation_listener_demo, menu);
		return true;
	}

}
