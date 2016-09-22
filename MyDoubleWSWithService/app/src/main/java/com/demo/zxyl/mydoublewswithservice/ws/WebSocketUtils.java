package com.demo.zxyl.mydoublewswithservice.ws;

import android.content.Context;
import android.os.Handler;
import android.util.Log;


import com.demo.zxyl.mydoublewswithservice.LogUtil;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by zhengyuji on 9/13/14.
 */
public class WebSocketUtils {
    public static final String TAG = "WebSocketUtils:";
    public static final String MSG_HEART_PACKAGE_CONTENT = "ping";
    private static Context sContext;
    private static WebSocketUtils sInstance;
    public static String URI_WEB_SOCKET = "";
    private static WebSocketClient sWebSocketClient;
    private static WebSocketListener mWebSocketListener;
    //    private static ArrayList<WebSocketListener> sWebSocketListenerList = new ArrayList<WebSocketListener>();
    private static WebSocketLogic sWebSocketLogic;
    //待发送的消息
    private static String sMsg2Send = null;
    private static Handler sHandler = new Handler();

    private WebSocketUtils() {
    }

    /**
     * @param context
     * @return
     */
    public static WebSocketUtils initInstanceIfNecessary(Context context, String location) {
        sContext = context;
        if (sInstance == null) {
//            String url = "";
//            try {
//                url = context.getPackageManager().getApplicationInfo(context.getPackageName(),
//                        PackageManager.GET_META_DATA).metaData.getString("websocket_ip");
//                url = url.replace("http", "ws");

//            } catch (PackageManager.NameNotFoundException e) {
//                e.printStackTrace();
//            }
//            URI_WEB_SOCKET = url + "/cloud/websocket/v1/";

            if (location != null) {
                URI_WEB_SOCKET = location;
            }

            sInstance = new WebSocketUtils();
           sWebSocketLogic =new WebSocketLogic(location);
            activateSocketClient();
        }
        return sInstance;
    }

    public static void clearInstance() {
        if (sWebSocketLogic != null) {
            sWebSocketLogic.destroy();
        }
        if (sWebSocketClient != null) {
            sWebSocketClient.close();
            sWebSocketClient = null;
        }
        sInstance = null;
    }

    /**
     * 建立websocket链接
     * 开启后台心跳
     */
    private static void activateSocketClient() {
        initWebSocketClient();
        LogUtil.d("asd","=========="+sWebSocketLogic);
      sWebSocketLogic.keepWebSocketAlive(sContext, sWebSocketClient);
    }

    public static void reLiveSocketClient() {
        initWebSocketClient();
        sWebSocketLogic.setWebSocketClient(sWebSocketClient);
    }

    /**
     * 建立websocket连接
     */
    private static void initWebSocketClient() {
        try {
            LogUtil.d("asd", TAG+"init");
            sWebSocketClient = new WebSocketClient(new URI(URI_WEB_SOCKET), new Draft_17()) {
                @Override
                public void onOpen(final ServerHandshake serverHandshake) {
                    LogUtil.d(TAG, "onOpen");
                    send(MSG_HEART_PACKAGE_CONTENT);
                    LogUtil.d(TAG, "onThread:" + Thread.currentThread().getId());
                    //发送待发送的消息
                    if (sMsg2Send != null) {//在此应用中无使用WS主动发送的消息
//                        send(sMsg2Send);
//                        sMsg2Send = null;
                    }


                }

                @Override
                public void onMessage(final String s) {
                    LogUtil.d(TAG, "onThread:" + Thread.currentThread().getId());
                    LogUtil.d("asd", TAG+"message=" + s);
//                    sHandler.post(new Runnable() {
//                        @Override
//                        public void run() {
////                            for (int i = 0; i < sWebSocketListenerList.size(); i++) {
////                                WebSocketListener webSocketListener = sWebSocketListenerList.get(i);
////                                if (webSocketListener != null) {
////                                    webSocketListener.onMessage(s);
////                                }
////                            }
//
//                         if (mWebSocketListener!=null){
//                             mWebSocketListener.onMessage(s);
//                         }
//                        }
//                    });

                    if (mWebSocketListener != null) {
                        mWebSocketListener.onMessage(s);
                    }
                }

                @Override
                public void onClose(final int index, final String s, final boolean b) {
                    LogUtil.d(TAG, "onClose");
                }

                @Override
                public void onError(final Exception e) {
                    LogUtil.e(TAG, "onError");
                }
            };
            sWebSocketClient.connect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static void setWebSocketListener(WebSocketListener webSocketListener) {
//        sWebSocketListenerList.add(webSocketListener);
        mWebSocketListener = webSocketListener;
    }

    public static void removeWebSocketListener(WebSocketListener webSocketListener) {
//        if (sWebSocketListenerList.contains(webSocketListener)) {
//            sWebSocketListenerList.remove(webSocketListener);
//        }
        mWebSocketListener = null;
    }


    /**
     * 通过webSocket发送信息，若连接断开则释放链接，若所发信息为心跳信息就保存本条信息（只能保存一条在sMsgSend）
     *
     * @param msg 心跳包信息
     */
    public void send(String msg) {
        if (sWebSocketClient.getConnection() == null || !sWebSocketClient.getConnection().isOpen()) {
            reLiveSocketClient();

            //保存没发送成功的非心跳包消息
            if (!msg.equals(MSG_HEART_PACKAGE_CONTENT)) {
                sMsg2Send = msg;
            }
        } else {
            sWebSocketClient.send(msg);
        }
    }

    /**
     * 自定义回调接口，回调webSocket接到的信息
     */
    public interface WebSocketListener {
        //public void onOpen(ServerHandshake serverHandshake);

        public void onMessage(String msg);

        //public void onClose(int i, String s, boolean b);

        //public void onError(Exception e);
    }
}
