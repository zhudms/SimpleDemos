package com.demo.zxyl.patientlogindemo.urils;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

import com.demo.zxyl.patientlogindemo.R;

/**
 * Created by TANG on 2016/6/16.
 * PatientLogInDemo
 */
public class LocalDeviceUtil {

    public static String getMacString(Context context) {

        String result = "";
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        result = wifiInfo.getMacAddress();

        if (result.length() == 0) {
            ToastUtil.toast(context, R.string.get_macid_error);
        }

//        return result;
        return "08:00:27:11:ed:c6";
    }


}
