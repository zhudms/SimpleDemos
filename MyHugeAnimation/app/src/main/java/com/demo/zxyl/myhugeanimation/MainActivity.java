package com.demo.zxyl.myhugeanimation;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;


public class MainActivity extends Activity {

    private ImageView mImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        setContentView(R.layout.activity_main);
        mImage = ((ImageView) findViewById(R.id.imge));
//        Animation animation= AnimationUtils.loadAnimation(this, R.anim.loading);
//        mImage.setAnimation(animation);
        mImage.setImageResource(R.drawable.loading);
        AnimationDrawable animationDrawable = (AnimationDrawable) mImage.getDrawable();
        animationDrawable.start();
    }


}
