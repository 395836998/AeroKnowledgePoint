package com.zhanglian2010.ui;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.zhanglian2010.util.HttpDownloader;

public class ImageViewRotateActivity extends Activity implements OnSeekBarChangeListener {

	private static int minWidth = 80;
	
	private ImageView imageView;
	
	private TextView textView1;
	
	private TextView textView2;
	
	private Button button;
	
	private Matrix matrix = new Matrix(); 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_view_rotate);
		
		imageView = (ImageView) findViewById(R.id.imageView1);
		
		
		textView1 = (TextView) findViewById(R.id.tipsSize);
		textView2 = (TextView) findViewById(R.id.tipsRotate);
		
		SeekBar seekbar1 = (SeekBar) findViewById(R.id.seekbar1);
		SeekBar seekbar2 = (SeekBar) findViewById(R.id.seekbar2);
		
		seekbar1.setOnSeekBarChangeListener(this);
		seekbar2.setOnSeekBarChangeListener(this);
		
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		
		seekbar1.setMax(dm.widthPixels-minWidth);
		
		
		button = (Button) findViewById(R.id.getImageButton);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new Thread(new Runnable(){
					@Override
					public void run() {
						try {
							InputStream in = HttpDownloader.getInputStreamFromUrl("http://gtms04.alicdn.com/tps/i4/TB1pk3UFFXXXXXnaXXX5rDaIVXX-80-80.png");
							Bitmap bitmap = BitmapFactory.decodeStream(in);
							
							Message msg = handler.obtainMessage();
							msg.obj = bitmap;
							handler.sendMessage(msg);
							
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}).start();
			}
		});
		
	}
	
	private Handler handler = new Handler() {

		public void handleMessage(Message msg) {
			Bitmap bitmap = (Bitmap) msg.obj;
			imageView.setImageBitmap(bitmap);
		};
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.image_view_rotate, menu);
		return true;
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		if(seekBar.getId() == R.id.seekbar1){
			int newWidth = progress + minWidth;
			int newHeight = (int)(newWidth*3/4);
			
			imageView.setLayoutParams(new LinearLayout.LayoutParams(newWidth, newHeight));
			textView1.setText("图像宽" + newWidth + "，高" + newHeight);
			
		}else if(seekBar.getId() == R.id.seekbar2){
			//获取位图并设置旋转
			Bitmap bitmap = ((BitmapDrawable)(getResources().getDrawable(R.drawable.dog))).getBitmap();
			matrix.setRotate(progress);
			bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
			imageView.setImageBitmap(bitmap);
			textView2.setText(progress + "度");
		}
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

}
