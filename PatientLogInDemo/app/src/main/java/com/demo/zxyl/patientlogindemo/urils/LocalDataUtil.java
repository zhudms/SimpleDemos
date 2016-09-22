package com.demo.zxyl.patientlogindemo.urils;

import android.content.Context;
import android.content.SharedPreferences;

import com.demo.zxyl.patientlogindemo.beans.PatientB;
import com.demo.zxyl.patientlogindemo.db.DBService;

/**
 * Created by TANG on 2016/6/15.
 * Patient
 */
public class LocalDataUtil {

    public static String getURLPreferce(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(VALUES.BASE_URL, context.MODE_PRIVATE);
        String baseUrl = preferences.getString(VALUES.BASE_URL, VALUES.LOGIN_AUTO_NULL);
        return baseUrl;
    }

    /**
     * 将地址信息写到sharedPreferences
     */
    public static void writeURLToPreferce(String url, Context context) {

        SharedPreferences preferences = context.getSharedPreferences(VALUES.BASE_URL, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(VALUES.BASE_URL, url);
        editor.commit();

    }


    public static void writeLocalPatient(Context context,PatientB patientB) {
        DBService service = DBService.getInstance(context);
        service.savePatient(patientB);
    }

    public static PatientB getLocalPatient(Context context) {
        DBService service = DBService.getInstance(context);
        PatientB patientB = service.getPatient();
        return patientB;
    }

    public static void delLocalPatient(Context context) {
        DBService service = DBService.getInstance(context);
        service.delLocalPatient();
    }

}
