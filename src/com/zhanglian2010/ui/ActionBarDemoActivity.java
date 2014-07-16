package com.zhanglian2010.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ActionBarDemoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_action_bar_demo);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.action_bar_demo, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
	        case R.id.action_search:
	            openSearch();
	            return true;
	        case R.id.action_settings:
	//            openSettings();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
		}
	}
	
	private void openSearch(){
		Toast.makeText(ActionBarDemoActivity.this, "searching...", Toast.LENGTH_SHORT).show();
		
		Intent intent = new Intent();
		intent.setClass(ActionBarDemoActivity.this, JsonDemoActivity.class);
		startActivity(intent);
		
	}

}
