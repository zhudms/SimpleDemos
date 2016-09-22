package com.demo.zl.mypaddingintentdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AlarmBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i("alarm", "Alarm fired!");
		Toast.makeText(context, "Alarm fired!", Toast.LENGTH_LONG).show();
	}
}
