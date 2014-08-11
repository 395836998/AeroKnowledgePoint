package com.zhanglian2010.ui;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class CheckboxDemoActivity extends Activity implements OnClickListener {

	private Button button;
	private List<CheckBox> checkBoxList;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		checkBoxList = new ArrayList<CheckBox>();
		
		//动态加载布局
		LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_checkbox_demo, null);
		String[] checkboxStrs = {"你快乐吗？" , "你幸福吗？", "你今天吃午饭了吗？", "你喜欢Android开发吗？"};
		
		//如下演示如何将checkbox按照指定的xml文件加载，并将其动态添加到上面的布局中
		for(String str : checkboxStrs){
			CheckBox checkbox = (CheckBox) getLayoutInflater().inflate(R.layout.checkbox_item, null);
			checkbox.setText(str);
			
			layout.addView(checkbox);
			checkBoxList.add(checkbox);
		}
		
		//设置当前的布局
		setContentView(layout);
		
		button = (Button) findViewById(R.id.checkButton);
		button.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.checkbox_demo, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		String tips = "";
		for(CheckBox box : checkBoxList){
			if(box.isChecked()){
				tips += box.getText() + "\n";
			}
		}
		
		if(TextUtils.isEmpty(tips)){
			tips = "您没有选择任何选项";
		}
		
		new AlertDialog.Builder(this).setMessage(tips).setPositiveButton("确定额", null).show();
	}

}
