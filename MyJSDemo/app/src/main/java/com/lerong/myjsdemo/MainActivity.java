package com.lerong.myjsdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    private WebView mWV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setWV();
        mWV.loadUrl("file:///android_asset/index.html");
    }

//    var a=  android.getIPAddresses();
//    alert(a);
    private void setWV() {
        mWV = ((WebView) findViewById(R.id.wv));
        WebSettings wSet = mWV.getSettings();
//        wSet.setJavaScriptEnabled(true);
//        wSet.setSupportZoom(true);
//        wSet.setAppCacheEnabled(true);//是否使用缓存

        wSet.setJavaScriptCanOpenWindowsAutomatically(true);//设置js可以直接打开窗口，如window.open()，默认为false
        wSet.setJavaScriptEnabled(true);//是否允许执行js，默认为false。设置true时，会提醒可能造成XSS漏洞

        wSet.setSupportZoom(true);//是否可以缩放，默认true
//        wSet.setBuiltInZoomControls(true);//是否显示缩放按钮，默认false
        wSet.setUseWideViewPort(true);//设置此属性，可任意比例缩放。大视图模式
        wSet.setLoadWithOverviewMode(true);//和setUseWideViewPort(true)一起解决网页自适应问题
        wSet.setAppCacheEnabled(true);//是否使用缓存
        wSet.setDomStorageEnabled(true);//DOM Storage
//        mWV.getSettings().setUserAgentString("User-Agent:Android");//设置用户代理，一般不用

        mWV.addJavascriptInterface(new JavaScriptinterface(this),
                "android");
        mWV.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;// 返回false
            }
        });

    }



    public class JavaScriptinterface {
        Context context;
        public JavaScriptinterface(Context c) {
            context= c;
        }

        /**
         * 与js交互时用到的方法，在js里直接调用的
         */
        @JavascriptInterface
        public String getIPAddresses() {
            Toast.makeText(MainActivity.this,"aaaaaaaa",Toast.LENGTH_SHORT).show();
            String s="hhhhhhhhh";
            Log.d("asd", "getIPAddresses: "+s);

            return  s;
        }
    }




}
