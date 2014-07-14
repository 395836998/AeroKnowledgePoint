package com.zhanglian2010.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.zhanglian2010.service.TestService;

public class ServiceDemoActivity extends Activity {

	private Button startButton;

	private Button stopButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service_demo);
		
		startButton = (Button) findViewById(R.id.startServiceId);
		stopButton = (Button) findViewById(R.id.stopServiceId);
		
		startButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(ServiceDemoActivity.this, TestService.class);
				intent.putExtra("aaa", "a1");
				startService(intent);
				
			}
		});
		
		stopButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(ServiceDemoActivity.this, TestService.class);
				stopService(intent);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.service_demo, menu);
		return true;
	}

}
