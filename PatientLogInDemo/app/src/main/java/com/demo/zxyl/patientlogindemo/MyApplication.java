package com.demo.zxyl.patientlogindemo;

import android.app.Application;
import android.content.Context;

import com.demo.zxyl.patientlogindemo.beans.PatientB;
import com.demo.zxyl.patientlogindemo.net.MyHttp;
import com.demo.zxyl.patientlogindemo.urils.LocalDataUtil;

/**
 * Created by TANG on 2016/6/16.
 * PatientLogInDemo
 */
public class MyApplication extends Application {

    public static volatile boolean neededWatch = false;

    public static PatientB mPatient /*= new PatientB()*/;
    public static MyHttp mHttp;


    @Override
    public void onCreate() {
        super.onCreate();
//        WebSocketUtils.initInstanceIfNecessary(this);//开启websocket
//        WebSocketUtils.setWebSocketListener(new MWebSocketLisener());

//        initData();
    }


    /**
     * 清除全部本地数据（URL，Patient）
     */
    public static void clearData(Context context) {
        LocalDataUtil.writeURLToPreferce("", context);
        LocalDataUtil.delLocalPatient(context);

        mPatient = null;
        mHttp = null;
    }


    public static PatientB getmPatient() {
        return mPatient;
    }

    public static void setmPatient(PatientB patient) {
        mPatient = patient;

    }


    public static MyHttp getmHttp() {

        return mHttp;
    }

    public static void setmHttp(MyHttp http) {
        mHttp = http;
    }


}
