package com.zhanglian2010.ui;

import java.lang.reflect.Field;
import java.util.Random;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class EditTextDemoActivity extends Activity {

	private EditText editText;
	
	private Button button;

	private EditText editTextDigits;

	private Button confirmButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_text_demo);
		
		editText = (EditText) findViewById(R.id.editTextId);
		button = (Button) findViewById(R.id.qqButtonId);
		
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				inputImage();
			}
		});
		
		editTextDigits = (EditText) findViewById(R.id.editDigitsId);
		confirmButton = (Button) findViewById(R.id.confirmButtonId);
		confirmButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				confirmEditText();
			}
		});
		
	}
	
	private void confirmEditText(){
		String digits = editTextDigits.getText().toString();
		if(digits == null || TextUtils.isEmpty(digits)){
			editTextDigits.setError("请输入内容！");
		}
	}
	
	private void inputImage(){
		//生成随机数
		int randomInt = new Random().nextInt(9) + 1;
		
		try {
			//读取到随机图片资源
			Field field = R.drawable.class.getDeclaredField("qq_00" + randomInt);
			int resourceId = Integer.parseInt(field.get(null).toString());
			
			//需要借助Bitmap来读取
			Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resourceId);
			
			
			ImageSpan imageSpan = new ImageSpan(EditTextDemoActivity.this, bitmap);
			SpannableString str = new SpannableString("qq_00");
			str.setSpan(imageSpan, 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
			
			editText.append(str);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_text_demo, menu);
		return true;
	}

}
