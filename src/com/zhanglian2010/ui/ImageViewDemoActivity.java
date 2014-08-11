package com.zhanglian2010.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ImageViewDemoActivity extends Activity {

	private ImageView imageView1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_view_demo);
		
		imageView1 = (ImageView) findViewById(R.id.imageView1);
		//设置第一张图片的比例大小
		imageView1.setLayoutParams(new LinearLayout.LayoutParams(150, 50));
		
		setTitle("width:" + imageView1.getLayoutParams().width + ";height:" + imageView1.getLayoutParams().height);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.image_view_demo, menu);
		return true;
	}

}
