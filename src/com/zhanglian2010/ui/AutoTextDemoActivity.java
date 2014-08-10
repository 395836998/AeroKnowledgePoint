package com.zhanglian2010.ui;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class AutoTextDemoActivity extends Activity {

	private AutoCompleteTextView auto;
	
	private MultiAutoCompleteTextView multi;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_auto_text_demo);
		
		//构建一个Adapter，提供智能提示的内容
		String[] autoStrs = {"Google", "Google Maps", "Zhang", "Zhang Lian", "Zhang san"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(AutoTextDemoActivity.this, 
				android.R.layout.simple_dropdown_item_1line, autoStrs);
		
		//设置Adapter
		auto = (AutoCompleteTextView) findViewById(R.id.autoTextId);
		auto.setAdapter(adapter);
		
		//多选项智能提示
		multi = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoId);
		multi.setAdapter(adapter);
		//设置多个选项之间的间隔符号
		multi.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.auto_text_demo, menu);
		return true;
	}

}
