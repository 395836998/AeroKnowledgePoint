package com.zhanglian2010.ui;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.zhanglian2010.broadcast.SmsReceiver;

public class BroadcastDemoActivity extends Activity {

	private Button bindButton;

	private Button unbindButton;

	private SmsReceiver smsReceiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_broadcast_demo);

		bindButton = (Button) findViewById(R.id.bindBcId);
		bindButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				smsReceiver = new SmsReceiver();
				IntentFilter filter = new IntentFilter();
				filter.addAction("android.provider.Telephony.SMS_RECEIVED");

				BroadcastDemoActivity.this.registerReceiver(smsReceiver, filter);
			}
		});

		unbindButton = (Button) findViewById(R.id.unbindBcId);
		unbindButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				BroadcastDemoActivity.this.unregisterReceiver(smsReceiver);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.broadcast, menu);
		return true;
	}

}
