package com.zhanglian2010.ui;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.zhanglian2010.bean.ClipObj;

public class ClipboardFromActivity extends Activity {

	private EditText editText;
	
	private Button button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_clipboard_from);
		
		editText = (EditText) findViewById(R.id.clipDataId);
		
		button = (Button) findViewById(R.id.clipButtonId);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				ClipboardManager manager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
				
//				//传递文本数据
//				ClipData data = ClipData.newPlainText(null, editText.getText().toString());
//				manager.setPrimaryClip(data);
				
				
				//传递对象数据
				ClipObj obj = new ClipObj(editText.getText().toString(), 17);
				ByteArrayOutputStream byteArrOutput = new ByteArrayOutputStream();
				try {
					ObjectOutputStream objectOutput = new ObjectOutputStream(byteArrOutput);
					objectOutput.writeObject(obj);
					
					String base64Str = Base64.encodeToString(byteArrOutput.toByteArray(), Base64.DEFAULT);
					ClipData data2 = ClipData.newPlainText(null, base64Str);
					manager.setPrimaryClip(data2);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				Intent intent = new Intent();
				intent.setClass(ClipboardFromActivity.this, ClipboardToActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.clipboard_from, menu);
		return true;
	}

}
