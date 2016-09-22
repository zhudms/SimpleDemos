package com.demo.zxyl.mydoublewswithservice;

import android.util.Log;

/**
 * Created by Administrator on 2016/3/2.
 */
public class LogUtil {

    private static final boolean IS_DEBUG = true;

    public static void d(String TAG, String message) {
        if (IS_DEBUG) {
            Log.d(TAG, message);
        }

    }

    public static void e(String TAG, String message) {
        if (IS_DEBUG) {
            Log.e(TAG, message);
        }

    }

    public static void w(String TAG, String message) {
        if (IS_DEBUG) {
            Log.w(TAG, message);
        }

    }
}
