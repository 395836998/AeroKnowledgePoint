package com.zhanglian2010.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class GalleryDemoActivity extends Activity {

	private Gallery gallery;
	private ImageAdapter imageAdapter;
	
	private int[] resIds = {
			R.drawable.p1, R.drawable.p2, R.drawable.p3, 
			R.drawable.p4, R.drawable.p5, R.drawable.p6, 
			R.drawable.p7, R.drawable.p8, R.drawable.p9, 
			R.drawable.p10, R.drawable.p11, R.drawable.p12, 
			R.drawable.p13, R.drawable.p14, R.drawable.p15
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gallery_demo);
		
		gallery = (Gallery) findViewById(R.id.galleryId);
		
		imageAdapter = new ImageAdapter(this);
		gallery.setAdapter(imageAdapter);
	}

	private class ImageAdapter extends BaseAdapter {
		
		private Context context;
		private int mGalleryItemBackground;
		
		
		public ImageAdapter(Context context) {
			this.context = context;
			TypedArray typedArray = obtainStyledAttributes(R.styleable.Gallery);
			mGalleryItemBackground = typedArray.getResourceId(R.styleable.Gallery_android_galleryItemBackground, 0);
		}

		@Override
		public int getCount() {
			return Integer.MAX_VALUE;
		}

		@Override
		public Object getItem(int position) {
			return resIds[position];
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView = new ImageView(context);
			imageView.setImageResource(resIds[position%resIds.length]);
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			imageView.setLayoutParams(new Gallery.LayoutParams(200, 150));
			imageView.setBackgroundResource(mGalleryItemBackground);
			return imageView;
		}
		
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gallery_demo, menu);
		return true;
	}

}
