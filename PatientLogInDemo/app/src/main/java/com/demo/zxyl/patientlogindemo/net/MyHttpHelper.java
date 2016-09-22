package com.demo.zxyl.patientlogindemo.net;


import android.content.Context;

import com.demo.zxyl.patientlogindemo.MyApplication;
import com.demo.zxyl.patientlogindemo.beans.BedMessageB;
import com.demo.zxyl.patientlogindemo.beans.PatientB;
import com.demo.zxyl.patientlogindemo.beans.ResultB;
import com.demo.zxyl.patientlogindemo.events.EventBusHelper;
import com.demo.zxyl.patientlogindemo.events.GetBedInfoFinishE;
import com.demo.zxyl.patientlogindemo.events.PaientInfoEvent;
import com.demo.zxyl.patientlogindemo.urils.LocalDeviceUtil;
import com.demo.zxyl.patientlogindemo.urils.VALUES;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by SEELE on 2016/5/25.
 */
public class MyHttpHelper {

    /**
     * 获取床位信息
     *
     * @param context
     */
    public static void getBedInfo(Context context) {
        String macString = LocalDeviceUtil.getMacString(context);
        if (macString.length() == 0) {
            return;
        }
        Call<ResultB<BedMessageB>> call = MyApplication.getmHttp().getBedMessage(macString);
        call.enqueue(new Callback<ResultB<BedMessageB>>() {
            @Override
            public void onResponse(Response<ResultB<BedMessageB>> response, Retrofit retrofit) {
                if (response != null && response.body() != null) {
                    if (response.body().getFLAG() == VALUES.SUCCESS) {
                        EventBusHelper.post(new GetBedInfoFinishE(response.body().getINFO()));
                    } else {
                        EventBusHelper.post(new GetBedInfoFinishE(response.body().getMESSAGE()));
                    }
                } else {
                    EventBusHelper.post(new GetBedInfoFinishE(VALUES.NULL));
                }

            }

            @Override
            public void onFailure(Throwable t) {
                EventBusHelper.post(new GetBedInfoFinishE(t.toString()));
            }
        });
    }


    /**
     * 获取病人详细信息
     *
     * @param bedSno
     * @param orgCode
     */
    public static void getMyPatient(String bedSno, String orgCode) {

        Call<ResultB<PatientB>> call =
                MyApplication.getmHttp().getPaientBasicInfo(bedSno, orgCode);

        call.enqueue(new Callback<ResultB<PatientB>>() {
            @Override
            public void onResponse(Response<ResultB<PatientB>> response, Retrofit retrofit) {


                if (response != null && response.body() != null) {
                    if (response.body().getFLAG() == VALUES.SUCCESS) {
                        EventBusHelper.post(new PaientInfoEvent(response.body().getINFO()));
                    } else {
                        EventBusHelper.post(new PaientInfoEvent(response.body().getMESSAGE()));
                    }
                } else {
                    EventBusHelper.post(new PaientInfoEvent(VALUES.NULL));
                }

            }

            @Override
            public void onFailure(Throwable t) {
                EventBusHelper.post(new PaientInfoEvent(t.toString()));
            }
        });


    }



}
