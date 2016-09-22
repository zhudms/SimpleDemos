package com.demo.zxyl.patientlogindemo.net;

import android.content.Context;

import com.demo.zxyl.patientlogindemo.MyApplication;
import com.demo.zxyl.patientlogindemo.urils.LocalDeviceUtil;

/**
 * Created by TANG on 2016/6/16.
 * PatientLogInDemo
 */
public class ClientAPI {

    public static String BASE_URL = null;
    public static String BASE_HTTP = "http://" + BASE_URL + "/";
    public static String BASE_WSMAC;
    public static String BASE_WSBED;

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static void setBaseUrl(String baseUrl) {
        BASE_URL = baseUrl;
        BASE_HTTP = "http://" + BASE_URL + "/";

    }


    public static void initWS(Context context) {
        BASE_WSMAC = "ws://" + BASE_URL + "/message/" + LocalDeviceUtil.getMacString(context) + "/" + LocalDeviceUtil.getMacString(context);
        BASE_WSBED = "ws://" + BASE_URL + "/message/" + MyApplication.getmPatient().getIN_SNO()+ "/" +  MyApplication.getmPatient().getIN_SNO();
    }


}
