package com.zhanglian2010.ui;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class SaveDataActivity extends Activity {

	private int defaultValue = 100;
	private TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_save_data);
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		System.out.println("on start...");
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		System.out.println("on resume...");
		
		
		SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
		long highScore = sharedPref.getInt(getString(R.string.saved_high_score), defaultValue);
		
		tv = (TextView) findViewById(R.id.highId);
		tv.setText(highScore + "");
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		System.out.println("on stop...");
		
		Random r = new Random();
		
		SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPref.edit();
		editor.putInt(getString(R.string.saved_high_score), r.nextInt(100));
		editor.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.save_data, menu);
		return true;
	}

}
