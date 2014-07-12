package com.zhanglian2010.sqlite;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.zhanglian2010.R;

public class SqliteDemoActivity extends Activity {

	private Button createDbButton;
	private Button updateDbButton;
	private Button insertButton;
	private Button updateButton;
	private Button queryButton;
	
	private int id=1;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sqlite_demo);
		
		createDbButton = (Button) findViewById(R.id.createDbId);
		updateDbButton = (Button) findViewById(R.id.updateDbId);
		insertButton = (Button) findViewById(R.id.insertId);
		updateButton = (Button) findViewById(R.id.updateId);
		queryButton = (Button) findViewById(R.id.queryId);
		
		createDbButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				DatabaseHelper dbHelper = new DatabaseHelper(SqliteDemoActivity.this,
						"test_user_db");
				
				SQLiteDatabase db = dbHelper.getReadableDatabase();
			}
		});
		
		updateDbButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				DatabaseHelper dbHelper = new DatabaseHelper(SqliteDemoActivity.this,
						"test_user_db", 2);
				
				SQLiteDatabase db = dbHelper.getReadableDatabase();
			}
		});
		
		insertButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				ContentValues values = new ContentValues();
				values.put("id", id);
				values.put("name", "zhangsan"+ (id++) );
				
				
				DatabaseHelper dbHelper = new DatabaseHelper(SqliteDemoActivity.this,
						"test_user_db", 2);
				
				SQLiteDatabase db = dbHelper.getWritableDatabase();
				
				db.insert("tbl_user", null, values);
				System.out.println("insert id:"+id);
			}
		});
		
		updateButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				DatabaseHelper dbHelper = new DatabaseHelper(SqliteDemoActivity.this,
						"test_user_db", 2);
				
				SQLiteDatabase db = dbHelper.getWritableDatabase();
				
				ContentValues values = new ContentValues();
				values.put("name", "zhanglian");
				
				db.update("tbl_user", values, "id=?", new String[]{"1"});
				
				System.out.println("update id=1");
				
			}
		});
		
		queryButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				DatabaseHelper dbHelper = new DatabaseHelper(SqliteDemoActivity.this,
						"test_user_db", 2);
				
				SQLiteDatabase db = dbHelper.getReadableDatabase();
				
				Cursor rs = db.query("tbl_user", new String[]{"id", "name"}, null, null, 
						null, null, "id");
				
				while(rs.moveToNext()){
					int id2 = rs.getInt(rs.getColumnIndex("id"));
					String name = rs.getString(rs.getColumnIndex("name"));
					
					System.out.println("id:"+id2+",name:"+name);
				}
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.sqlite, menu);
		return true;
	}

}
