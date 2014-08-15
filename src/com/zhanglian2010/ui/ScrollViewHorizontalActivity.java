package com.zhanglian2010.ui;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ScrollViewHorizontalActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scroll_view_horizontal);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.scroll_view_horizontal, menu);
		return true;
	}

}
