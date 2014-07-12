package com.zhanglian2010.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class SmsReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		System.out.println("receive sms...");
		
		Bundle bundle = intent.getExtras();
		Object[] objs = (Object[])bundle.get("pdus");
		SmsMessage messages[] = new SmsMessage[objs.length];
		
		for(int i=0; i<objs.length; i++){
			messages[i] = SmsMessage.createFromPdu((byte[])objs[i]);
			System.out.println("received: " + messages[i].getDisplayMessageBody());
		}
	}

}
