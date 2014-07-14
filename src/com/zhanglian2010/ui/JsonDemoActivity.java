package com.zhanglian2010.ui;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhanglian2010.json.bean.User;

public class JsonDemoActivity extends Activity {

	private TextView view;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_json_demo);
		
		view = (TextView) findViewById(R.id.textId);
		
		String str = "[{\"passportid\":\"K9051\",\"name\":\"李平\",\"passporttype\":\"K\"}, {\"passportid\":\"K90517\",\"name\":\"袁寒梅\",\"passporttype\":\"K\"}, {\"passportid\":\"K905199\",\"name\":\"贺明\",\"passporttype\":\"K\"}]";

		Gson gson = new Gson();
		List<User> userList = gson.fromJson(str, new TypeToken<List<User>>(){}.getType() );
		System.out.println(userList.get(0).getName());
		System.out.println(userList.get(0).getPassporttype());
		
		view.setText(userList.get(0).getName() + userList.get(0).getPassporttype());
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.json_demo, menu);
		return true;
	}

}
