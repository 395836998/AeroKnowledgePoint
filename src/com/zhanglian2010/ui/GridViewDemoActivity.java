package com.zhanglian2010.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

public class GridViewDemoActivity extends Activity implements OnItemSelectedListener, OnItemClickListener {


	private ImageView imageView;

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
		setContentView(R.layout.activity_grid_view_demo);

		GridView gridView = (GridView) findViewById(R.id.gridView1);

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for(int i=0; i<resIds.length; i++){
			Map<String, Object> cell = new HashMap<String, Object>();
			cell.put("imageview", resIds[i]);
			list.add(cell);
		}

		SimpleAdapter adapter = new SimpleAdapter(GridViewDemoActivity.this, list, R.layout.grid_cell, 
				new String[]{"imageview"}, new int[]{R.id.gridImageCell1});
		gridView.setAdapter(adapter);

		imageView = (ImageView) findViewById(R.id.gridImage1);
		gridView.setOnItemClickListener(this);
		gridView.setOnItemSelectedListener(this);
		imageView.setImageResource(resIds[0]);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.grid_view_demo, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		imageView.setImageResource(resIds[position]);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		imageView.setImageResource(resIds[position]);
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {

	}

}
