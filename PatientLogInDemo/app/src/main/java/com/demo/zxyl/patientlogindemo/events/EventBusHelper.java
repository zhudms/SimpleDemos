package com.demo.zxyl.patientlogindemo.events;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by SEELE on 2016/5/25.
 */
public class EventBusHelper {

    public static void post(Object obj){
        EventBus.getDefault().post(obj);
    }
}
