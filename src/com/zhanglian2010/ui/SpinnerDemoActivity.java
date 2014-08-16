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
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

public class SpinnerDemoActivity extends Activity {

	private Spinner spinner;
	private Spinner spinner2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spinner_demo);

		spinner = (Spinner) findViewById(R.id.spinnerId);
		ArrayAdapter<String> adapter 
			= new ArrayAdapter<String>(SpinnerDemoActivity.this, android.R.layout.simple_spinner_item, getData());
		spinner.setAdapter(adapter);


		spinner2 = (Spinner) findViewById(R.id.spinnerId2);
		SimpleAdapter simpleAdapter 
			= new SimpleAdapter(SpinnerDemoActivity.this, getData2(), R.layout.item_spinner, new String[]{"ivLogo", "ivName"}, new int[]{R.id.spinnerImage, R.id.spinnerText});
		spinner2.setAdapter(simpleAdapter);
		spinner2.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				
				Map<String, Object> map = (Map<String, Object>) spinner2.getItemAtPosition(position);
				setTitle(map.get("ivName").toString());
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				
			}
			
		});
	}

	private static List<String> getData(){
		List<String> list = new ArrayList<String>();
		list.add("重庆");
		list.add("合川");
		list.add("深圳");
		list.add("北京");
		return list;
	}

	private static List<Map<String, Object>> getData2(){
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ivLogo", R.drawable.button1);
		map.put("ivName", "重庆");
		data.add(map);

		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("ivLogo", R.drawable.qq_002);
		map2.put("ivName", "QQ表情");
		data.add(map2);

		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("ivLogo", R.drawable.button3);
		map3.put("ivName", "五星");
		data.add(map3);
		return data;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.spinner_demo, menu);
		return true;
	}

}
