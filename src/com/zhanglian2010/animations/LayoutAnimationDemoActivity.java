package com.zhanglian2010.animations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.zhanglian2010.R;

public class LayoutAnimationDemoActivity extends ListActivity {

	private ListView listView;
	private Button button;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_layout_animation_demo);
		
		listView = getListView();
		button = (Button) findViewById(R.id.buttonId);
		button.setOnClickListener(new ButtonListener());
		
	}
	
	private ListAdapter buildListAdapter(){
		List<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
		HashMap<String, String> m1 = new HashMap<String, String>();
		m1.put("user_name", "张三");
		m1.put("user_gender", "男");
		
		HashMap<String, String> m2 = new HashMap<String, String>();
		m2.put("user_name", "李四");
		m2.put("user_gender", "女");
		
		HashMap<String, String> m3 = new HashMap<String, String>();
		m3.put("user_name", "王五");
		m3.put("user_gender", "女");
		
		list.add(m1);
		list.add(m2);
		list.add(m3);
		
		SimpleAdapter adapter = new SimpleAdapter(this, list,
				R.layout.item, new String[]{"user_name", "user_gender"},
				new int[]{R.id.user_name, R.id.user_gender}
				);
		
		return adapter;
	}
	
	
	private class ButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			listView.setAdapter(buildListAdapter());
			//通过在布局文件的ListView中设置android:layoutAnimation="@anim/list_anim_layout"来启动动画
			
//			//或者通过代码设置动画到ListView中（而上面的布局文件配置就不需要了）
//			Animation anim = (Animation) AnimationUtils.loadAnimation(LayoutAnimationDemoActivity.this, R.anim.list_anim);
//			LayoutAnimationController lac = new LayoutAnimationController(anim);
//			lac.setOrder(LayoutAnimationController.ORDER_NORMAL);
//			lac.setDelay(0.5f);
//			listView.setLayoutAnimation(lac);
			
		}
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.layout_animation_demo, menu);
		return true;
	}

}
