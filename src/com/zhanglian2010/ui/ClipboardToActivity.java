package com.zhanglian2010.ui;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Base64;
import android.view.Menu;
import android.widget.TextView;

import com.zhanglian2010.bean.ClipObj;

public class ClipboardToActivity extends Activity {

	private TextView text;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_clipboard_to);
		
		text = (TextView) findViewById(R.id.clipTextId);
		
		ClipboardManager manager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
		ClipData data = manager.getPrimaryClip();
		Item item = data.getItemAt(0);
		
//		//通过文本传递过来的数据
//		text.setText( item.getText().toString() );
		
		//通过对象传递过来的数据
		String base64Str = item.getText().toString();
		byte[] buff = Base64.decode(base64Str, Base64.DEFAULT);
		ByteArrayInputStream byteArrInput = new ByteArrayInputStream(buff);
		try {
			ObjectInputStream objInput = new ObjectInputStream(byteArrInput);
			ClipObj obj = (ClipObj) objInput.readObject();
			text.setText( obj.toString() );
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.clipboard_to, menu);
		return true;
	}

}
