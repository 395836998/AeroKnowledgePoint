package com.zhanglian2010.ui;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

public class ImageSwitcherDemoActivity extends Activity implements OnClickListener, ViewFactory {

	private ImageSwitcher imageSwitcher;
	private Button button1, button2;
	private int index = 0;

	private List<Drawable> list = new ArrayList<Drawable>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_switcher_demo);

		imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher1);
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);

		imageSwitcher.setFactory(this);
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);


		list.add(getResources().getDrawable(R.drawable.p1));
		list.add(getResources().getDrawable(R.drawable.p2));
		list.add(getResources().getDrawable(R.drawable.p3));
		list.add(getResources().getDrawable(R.drawable.p4));
		list.add(getResources().getDrawable(R.drawable.p11));
		list.add(getResources().getDrawable(R.drawable.p12));
		list.add(getResources().getDrawable(R.drawable.p13));
		list.add(getResources().getDrawable(R.drawable.p14));

		if(list.size() > 0){
			imageSwitcher.setImageDrawable(list.get(0));
		}
	}


	@Override
	public View makeView() {
		System.out.println("making ImageView...");
		return new ImageView(ImageSwitcherDemoActivity.this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.button1:
				index--;
				if(index<0){
					index=list.size()-1;
				}
				break;
			case R.id.button2:
				index++;
				if(index>=list.size()){
					index=0;
				}
				
				break;
			default:
				break;
		}

		imageSwitcher.setImageDrawable(list.get(index));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.image_switcher_demo, menu);
		return true;
	}
}
