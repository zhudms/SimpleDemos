package com.demo.zxyl.patientlogindemo.net;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


/**
 * Created by TANG on 2016/6/25.
 * PatientLogInDemo
 */
public class MyCallBack<T> implements Callback<T> {

    @Override
    public void onResponse(Response<T> response, Retrofit retrofit) {

    }

    @Override
    public void onFailure(Throwable t) {

    }
}
