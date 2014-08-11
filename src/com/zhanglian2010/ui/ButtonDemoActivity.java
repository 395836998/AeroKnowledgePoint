package com.zhanglian2010.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

public class ButtonDemoActivity extends Activity implements OnClickListener, OnFocusChangeListener, 
		OnKeyListener, OnTouchListener {
	
	private Button commonButton;
	
	private Button imageButton;
	
	private ToggleButton toggle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_button_demo);
		
		commonButton = (Button) findViewById(R.id.commonButton);
		imageButton = (Button) findViewById(R.id.imageButton);
		
		commonButton.setOnClickListener(this);
		imageButton.setOnClickListener(this);
		
		imageButton.setOnKeyListener(this);
		imageButton.setOnTouchListener(this);
		imageButton.setOnFocusChangeListener(this);
		
		
		final LinearLayout layout = (LinearLayout) findViewById(R.id.myToggleLayout);
		
		toggle = (ToggleButton) findViewById(R.id.toggleButton);
		toggle.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked){
					//设置布局的排列方式
					layout.setOrientation(LinearLayout.VERTICAL);
				}else{
					layout.setOrientation(LinearLayout.HORIZONTAL);
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.button_demo, menu);
		return true;
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		System.out.println("touch...");
		if(event.getAction() == MotionEvent.ACTION_UP){
			v.setBackgroundResource(R.drawable.button1);
		}else if(event.getAction() == MotionEvent.ACTION_DOWN){
			v.setBackgroundResource(R.drawable.button3);
		}
		return false;
	}

	@Override
	public boolean onKey(View v, int keyCode, KeyEvent event) {
		System.out.println("key...");
		if(KeyEvent.ACTION_DOWN == event.getAction()){
			v.setBackgroundResource(R.drawable.button3);
		}else if(KeyEvent.ACTION_UP == event.getAction()){
			v.setBackgroundResource(R.drawable.button2);
		}
		
		return false;
	}

	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		System.out.println("focus...");
		if(hasFocus){
			v.setBackgroundResource(R.drawable.button2);
		}else{
			v.setBackgroundResource(R.drawable.button1);
		}
	}

	@Override
	public void onClick(View v) {
		Button button = (Button) v;
		
		if(button.getWidth() < getWindowManager().getDefaultDisplay().getWidth()){
			button.setWidth( (int) (button.getWidth() * 1.1 ) );
			button.setHeight((int) (button.getHeight() * 1.1 ));
		}
		
	}

}
