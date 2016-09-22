package com.demo.zxyl.mydoublewswithservice;

import android.app.Application;


/**
 * Created by TANG on 2016/3/4.
 */
public class MyApplaction extends Application {


    public static String inSno = "2914044";

    public static String getUuid() {
        return uuid;
    }

    public static void setUuid(String uuid) {
        MyApplaction.uuid = uuid;
    }

    public static String mPatientId = "409579";//ehrId

    public static String bedSno = "2899680";
    public static String orgCode = "2899680";
    public static String ehrId = "256";//健康档案ID
    public static String uuid = "1CD342661A5241629B9AE4487725D278";//userId

    public static String getmPatientId() {
        return mPatientId;
    }
}
