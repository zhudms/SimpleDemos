package com.demo.zxyl.mydoublewswithservice.ws;

import android.content.Context;

import org.java_websocket.client.WebSocketClient;

/**
 * �����ػ�����
 * Created by zhengyuji on 9/12/14.
 */
public class WebSocketLogic {
    private WebSocketDaemonThread daemonThread;
    private String mLocation;


    public WebSocketLogic(String mLocation){
        mLocation=mLocation;
    }

    public void keepWebSocketAlive(Context context, WebSocketClient webSocketClient, String location) {
        daemonThread = new WebSocketDaemonThread(context, location, webSocketClient);
        daemonThread.setDaemon(true);
        daemonThread.start();
    }

    public void keepWebSocketAlive(Context context, WebSocketClient webSocketClient) {
        daemonThread = new WebSocketDaemonThread(context, webSocketClient);
        daemonThread.setDaemon(true);
        daemonThread.start();
    }

    public void setWebSocketClient(WebSocketClient webSocketClient) {
        if (daemonThread != null) {
            daemonThread.setWebSocketClient(webSocketClient);
        }
    }

    public void destroy() {
        if (daemonThread != null) {
//            daemonThread.die();
            daemonThread = null;
        }
    }
}
