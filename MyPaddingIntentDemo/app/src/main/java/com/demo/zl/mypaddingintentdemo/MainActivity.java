package com.demo.zl.mypaddingintentdemo;

import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

//待测试 ：Act onStop后还能接到注册的广播吗 （静态，动态）
public class MainActivity extends Activity {

    private final Intent intent = new Intent("com.josenaves.alarm.ALARM_FIRED");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("alarm", "Creating alarm");

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.add(Calendar.SECOND, 3);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), 5000, getPendingIntent());
        ArrayList<String> list = new ArrayList<>(2);
        ArrayList<String> list1 = ((ArrayList<String>) list.clone());


    }

    @Override
    protected void onPause() {
        super.onPause();
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.cancel(getPendingIntent());
    }

    @Override
    protected void onDestroy() {
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.cancel(getPendingIntent());
        super.onDestroy();
    }

    private PendingIntent getPendingIntent() {
        Intent intent = new Intent("com.josenaves.alarm.ALARM_FIRED");
        return PendingIntent.getBroadcast(this, 0, intent, 0);
    }

}
