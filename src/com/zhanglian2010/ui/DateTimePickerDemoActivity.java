package com.zhanglian2010.ui;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;
import android.widget.Toast;

public class DateTimePickerDemoActivity extends Activity implements OnDateChangedListener,
		OnTimeChangedListener, OnClickListener {

	private Button dateButton, timeButton;
	
	private DatePicker datePicker;
	
	private TimePicker timePicker;
	
	private int hour, minute;
	
	private int year, month, day;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_date_time_picker_demo);
		
		dateButton = (Button) findViewById(R.id.dateButton1);
		timeButton = (Button) findViewById(R.id.timeButton1);
		dateButton.setOnClickListener(this);
		timeButton.setOnClickListener(this);
		
		datePicker = (DatePicker) findViewById(R.id.datePick);
		timePicker = (TimePicker) findViewById(R.id.timePick);
		
		datePicker.init(2001, 1, 25, this);
		
		timePicker.setIs24HourView(true);
		timePicker.setOnTimeChangedListener(this);
		
		Calendar cale = Calendar.getInstance();
		year = cale.get(Calendar.YEAR);
		month = cale.get(Calendar.MONTH);
		day = cale.get(Calendar.DAY_OF_MONTH);
		hour = cale.get(Calendar.HOUR_OF_DAY);
		minute = cale.get(Calendar.MINUTE);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.dateButton1:
			DatePickerDialog dialog = new DatePickerDialog(DateTimePickerDemoActivity.this,
					new MyDatePickerDialogListener(), year, month, day);
			dialog.show();
			break;
		case R.id.timeButton1:
			TimePickerDialog dialog2 = new TimePickerDialog(DateTimePickerDemoActivity.this,
					new MyTimePickerDialogListener(), hour, minute, true);
			dialog2.show();
			break;
		default:
			break;
		}
	}
	
	private class MyDatePickerDialogListener implements DatePickerDialog.OnDateSetListener {

		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			Toast.makeText(DateTimePickerDemoActivity.this, 
					"year:" + year + ",month:" + monthOfYear + ",day:" + dayOfMonth, Toast.LENGTH_SHORT).show();
		}
	}
	
	private class MyTimePickerDialogListener implements TimePickerDialog.OnTimeSetListener {

		@Override
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			Toast.makeText(DateTimePickerDemoActivity.this, 
					"hoursOfDay:" + hourOfDay + ",minute:" + minute , Toast.LENGTH_SHORT).show();
		}
	}
	
	@Override
	public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
		Toast.makeText(DateTimePickerDemoActivity.this, 
				"hoursOfDay:" + hourOfDay + ",minute:" + minute , Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onDateChanged(DatePicker view, int year, int monthOfYear,
			int dayOfMonth) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(datePicker.getYear(), 
				datePicker.getMonth(), datePicker.getDayOfMonth(), timePicker.getCurrentHour(), timePicker.getCurrentMinute());
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Toast.makeText(DateTimePickerDemoActivity.this, 
				format.format(calendar.getTime()) , Toast.LENGTH_SHORT).show();
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.date_time_picker_demo, menu);
		return true;
	}


}
