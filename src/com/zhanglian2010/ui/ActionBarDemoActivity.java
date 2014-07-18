package com.zhanglian2010.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ActionBarDemoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_action_bar_demo);
		
		//延迟3秒隐藏ActionBar
		new Handler().postDelayed(new Runnable(){   
		    public void run() {
		    	// Make sure we're running on Honeycomb or higher to use ActionBar APIs
		    	//动态获得SDK版本
		        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
		        	getActionBar().hide();
		        }
		    }   
		 }, 3000);   
		
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
