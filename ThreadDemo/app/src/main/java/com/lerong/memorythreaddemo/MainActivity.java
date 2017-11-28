package com.lerong.memorythreaddemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuAdapter;
import android.util.Log;
import android.widget.ImageView;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.squareup.leakcanary.RefWatcher;

import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;

/*
使用Android Monitor中InitiateGC按钮测试线程执行完成后， 线程中持有的Act引用可以被回收
（所以内存泄露一说怎么来的？是说不能被立刻清除?无论线程是否作为类变量，最后内存都可以被回收）
另外递归的内存消耗真的好恐怖
 */
public class MainActivity extends AppCompatActivity {

    //    @BindView(R.id.main_btn)
    ImageView view;
    private Mythread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        view=new ImageView(MainActivity.this);

        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(5)         // (Optional) How many method line to show. Default 2
//                .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
                .tag("qwe")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));


        Log.d("asd", "onCreate: ");

        HashMap<String ,String> map=new HashMap<>(2);
        map.put("1","aa");
        map.put("2","bb");

        thread =new Mythread(MainActivity.this, new Runnable() {
            @Override
            public void run() {
                Log.d("asd", "runnable" +
                        " ");
                int sum = 0;
                sum=getSum(500);
                Log.d("asd", "sum= "+sum);
                view=new ImageView(thread.mCotext);
//                view.setBackgroundResource(R.drawable.aa);
            }
        });

        thread.start();
        Logger.d(map);
    }

    @Override
    protected void onStart() {
        super.onStart();
//
//        thread=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int sum = 0;
//                sum=getSum(50000);
//                Log.d("asd", "sum= "+sum);
//                view=new ImageView(MainActivity.this);
////                view.setBackgroundResource(R.drawable.aa);
//            }
//        });
//        thread.start();
        Log.d("asd", "onStartFinish");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent=new Intent();
        intent.setClass(MainActivity.this,AnotherAct.class);
        startActivity(intent);
        this.finish();
    }

    /*
    计算从0到j的累加
     */

    public int getSum(int j){
        int sum=0;
        for (int i = 0; i < j; i++) {
            sum+=i;
//            Logger.d("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqsumqqqqqqqqqqqqqqqqqqqsumqqqqqqqqqqqqqqqqqqqsumqqqqqqqqqqqqqqqqqqqsumsum=",sum);
//            Log.d("asd", "sum="+sum);
        }
        return sum;
//     if (j==0){
//            return  0;
//        }else{
//            return j+getSum(j--);
//        }

    }

    class  Mythread extends Thread{
        Context mCotext;

        public Mythread(Context mCotext,Runnable runnable) {
            super(runnable);
            this.mCotext = mCotext;
        }



    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("asd", "onDestroy: qqqqqqqqqq");
        RefWatcher refWatcher = MyApplication.getRefWatcher(MainActivity.this);
        refWatcher.watch(this);
    }
}
