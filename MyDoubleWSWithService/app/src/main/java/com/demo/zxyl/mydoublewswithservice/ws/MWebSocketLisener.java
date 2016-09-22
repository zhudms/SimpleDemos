package com.demo.zxyl.mydoublewswithservice.ws;


/**
 * 推送消息入口，接入消息之后判断类型，再进行事件分发
 */
public class MWebSocketLisener implements WebSocketUtils.WebSocketListener{

    @Override
    public void onMessage(String msg) {
//EventBus

//        EventBus.getDefault().post(EventUtil.getEventInstance(msg));

    }
}