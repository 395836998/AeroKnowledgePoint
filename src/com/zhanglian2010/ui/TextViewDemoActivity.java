package com.zhanglian2010.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class TextViewDemoActivity extends Activity {

	private TextView textViewRun;
	private TextView textView;
	private TextView textView2;
	private TextView textView3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_text_view_demo);

		//跑马灯
		textViewRun = (TextView) findViewById(R.id.textViewRunId);
		String html = "这两天自媒体圈最火的事情，莫过于<a href='http://www.qq.com'>腾讯</a>公布公众号发布的文章的阅读数，一时间弹赞不一，而几乎同时，百度百家也做了一次大改版，原来每篇文章显眼的“阅读数”不见了，仅在作者主页以及右边栏推荐中，才出现文章的阅读数量。两个巨头同时出手，为什么策略却大相径庭？";
		CharSequence c = Html.fromHtml(html);
		textViewRun.setText(c);
		textViewRun.setMovementMethod(LinkMovementMethod.getInstance());
		
		//使用文本框显示html文本
		textView = (TextView) findViewById(R.id.textViewId);
		String htmlStr = "<p><font color='red'>百度地址：</font>" +
				"<a href='http://www.baidu.com'>百度</a>" +
				"</p>";

		CharSequence charSeq = Html.fromHtml(htmlStr);
		textView.setText(charSeq);
		textView.setMovementMethod(LinkMovementMethod.getInstance());


		//使用文本框显示富内容
		textView2 = (TextView) findViewById(R.id.textViewId2);
		String text = "我的地址： http://www.baidu.com\n"; 
		text += "我的电话：+ 86 18883885136";
		textView2.setText(text);
		textView2.setMovementMethod(LinkMovementMethod.getInstance());

		
		//使用文本框点击启动activity
		textView3 = (TextView) findViewById(R.id.textViewId3);
		String str = "启动MainActivity";
		
		SpannableString spanStr = new SpannableString(str);
		spanStr.setSpan(new ClickableSpan() {
			@Override
			public void onClick(View widget) {
				Intent intent = new Intent(TextViewDemoActivity.this, MainActivity.class);
				startActivity(intent);
			}
		}, 0, str.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		
		textView3.setText(spanStr);
		textView3.setMovementMethod(LinkMovementMethod.getInstance());
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.text_view_demo, menu);
		return true;
	}

}
