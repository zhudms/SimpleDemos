package com.rongyile.myfacews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rongyile.myfacews.bean.WSReconize;
import com.rongyile.myfacews.eventBean.WSReconizeFaceE;

import org.greenrobot.eventbus.EventBus;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;


public class WebsocketPushMsg {

    public static final String TAG = "asd";

    /**
     * 识别消息推送
     *
     * @param wsUrl   websocket接口 例如 ws://192.168.1.50:9000/video
     * @param rtspUrl 视频流地址 门禁管理-门禁设备-视频流地址
     *                例如 rtsp://192.168.0.100/live1.sdp
     *                或者 rtsp://admin:admin12345@192.168.1.64/live1.sdp
     *                或者 rtsp://192.168.1.103/user=admin&password=&channel=1&stream=0.sdp
     *                或者 rtsp://192.168.1.100/live1.sdp
     *                ?__exper_tuner=lingyun&__exper_tuner_username=admin
     *                &__exper_tuner_password=admin&__exper_mentor=motion
     *                &__exper_levels=312,1,625,1,1250,1,2500,1,5000,1,5000,2,10000,2,10000,4,10000,8,10000,10
     *                &__exper_initlevel=6
     * @throws URISyntaxException //    * @throws MalformedURLException
     *                            //    * @throws UnsupportedEncodingException
     */
    public static void startConnection(final Context mContext, String wsUrl, String rtspUrl) throws URISyntaxException {
        //当视频流地址中出现&符号时，需要进行进行url编码            
        rtspUrl = URLEncoder.encode(rtspUrl);
        URI uri = URI.create(wsUrl + "?url=" + rtspUrl);
        WebSocketClient webSocketClient = new WebSocketClient(uri) {

            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                System.out.println("webSocketClient open " + serverHandshake.getHttpStatusMessage());
                Log.d(TAG, "onOpen: ");

                Toast.makeText(mContext, "onOpen", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onMessage(String s) {
                System.out.println("webSocketClient onMessage " + s);
                Log.d(TAG, "onMessage: ");
                Toast.makeText(mContext, "onMessage", Toast.LENGTH_LONG).show();

                WSReconize reconize = JSON.parseObject(s, WSReconize.class);

                byte[] image = Base64.decode(reconize.data.face.image, Base64.NO_WRAP);
                Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
                System.out.println("webSocketClient onMessage bitmap.size=" + image.length);
                EventBus.getDefault().post(new WSReconizeFaceE(bitmap));
            }

            @Override
            public void onClose(int i, String s, boolean b) {
                System.out.println("webSocketClient onClose " + s + " " + i + " " + b);


                Toast.makeText(mContext, "onClose", Toast.LENGTH_LONG).show();


            }

            @Override
            public void onError(Exception e) {
                System.out.println("webSocketClient onError " + e.getMessage());
                Toast.makeText(mContext, "onError", Toast.LENGTH_LONG).show();


            }
        };

        webSocketClient.connect();
    }


    /**
     * websocket接口返回face.image
     * image为base64编码的字符串
     * 将字符串转为可以识别的图片
     *
     * @param imgStr
     * @return
     */
    public static boolean generateImage(String imgStr, String imgFile) throws Exception {
        // 对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) // 图像数据为空
            return false;
//        BASE64Decoder decoder = new BASE64Decoder();
//        try {
//            // Base64解码
//            byte[] b = decoder.decodeBuffer(imgStr);
//            for (int i = 0; i < b.length; ++i) {
//                if (b[i] < 0) {// 调整异常数据
//                    b[i] += 256;
//                }
//            }
//            // 生成jpeg图片
//            String imgFilePath = imgFile;// 新生成的图片
//            OutputStream out = new FileOutputStream(imgFilePath);
//            out.write(b);
//            out.flush();
//            out.close();
//            return true;
//        } catch (Exception e) {
//            throw e;
//        }
        return true;
    }


}