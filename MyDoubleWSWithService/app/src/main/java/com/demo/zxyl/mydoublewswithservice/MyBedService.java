package com.demo.zxyl.mydoublewswithservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;


import com.demo.zxyl.mydoublewswithservice.ws.MWebSocketLisener;
import com.demo.zxyl.mydoublewswithservice.ws.WebSocketUtils;

import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * 通过MAC地址获取床位信息（bedSno&orgCode）
 *
 * Created by TANG on 2016/6/6.
 * Patient
 */
public class MyBedService extends Service {


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

//        ((MyApplaction) getApplication()).isServiceRunning(R.string.bed_process);
        initWebSocket();
//        return super.onStartCommand(intent, flags, startId);

        return  START_STICKY_COMPATIBILITY;
    }




    public void initWebSocket() {



        WebSocketUtils.initInstanceIfNecessary(this, ClientAPI.WS_SERVICE_BED);//开启websocket
        WebSocketUtils.setWebSocketListener(new MWebSocketLisener());

        WebSocketUtils.setWebSocketListener(new WebSocketUtils.WebSocketListener() {
            @Override
            public void onMessage(String msg) {
                try {
                    JSONTokener jsonParser = new JSONTokener(msg);
                    JSONObject person = (JSONObject) jsonParser.nextValue();
                    String type = person.getString("type");
                    String content = person.getString("content");
                    String receive = person.getString("RECEIVE");
                    ;


//                    EventBusHelper.post(GetPatientEnum.GET_BEDINFO);
//                    switch (type) {
//                        case NewPatinetsMessageE.CHANGE_MESSAGE:
//                            EventBusHelper.post(new NewPatinetsMessageE(type));
//                            break;
//                        case NewPatinetsMessageE.CHANGE_PATIENT:
//                            EventBusHelper.post(new NewMessageMessageE(type));
//                            break;
//                        case NewPatinetsMessageE.CHANGE_SOURCE:
//                            EventBusHelper.post(new NewSourceMessageE(type));
//                            break;
//
//
//                    }

                } catch (Exception e) {

                }
            }
        });
    }

}
