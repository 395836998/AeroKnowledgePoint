package com.zhanglian2010.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProgressBarDemoActivity extends Activity implements OnClickListener {

	private ProgressBar progressBar1;
	private Button addProgress;
	private Button depProgress;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//在窗口上模拟显示进度条效果
		requestWindowFeature(Window.FEATURE_PROGRESS);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		
		setContentView(R.layout.activity_progress_bar_demo);
		
		setProgressBarIndeterminate(true);
		setProgressBarVisibility(true);
		setProgress(3000);
		
		progressBar1 = (ProgressBar) findViewById(R.id.progressBar1);
		addProgress = (Button) findViewById(R.id.addProgress);
		depProgress = (Button) findViewById(R.id.depProgress);
		
		addProgress.setOnClickListener(this);
		depProgress.setOnClickListener(this);
		
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.addProgress:
			progressBar1.setProgress( (int)(progressBar1.getProgress() * 1.2 ) );
			progressBar1.setSecondaryProgress( (int)(progressBar1.getSecondaryProgress() * 1.2 ) );
			break;
		case R.id.depProgress:
			progressBar1.setProgress( (int)(progressBar1.getProgress() * 0.8 ) );
			progressBar1.setSecondaryProgress( (int)(progressBar1.getSecondaryProgress() * 0.8 ) );
			break;
		default:
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.progress_bar_demo, menu);
		return true;
	}

}
