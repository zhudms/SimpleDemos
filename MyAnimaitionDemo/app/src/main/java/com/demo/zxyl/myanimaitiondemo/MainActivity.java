package com.demo.zxyl.myanimaitiondemo;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import android.widget.ImageView;

/**
 *
 */
public class MainActivity extends Activity {

    private ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImage = ((ImageView) findViewById(R.id.image));
//        Animation animation= AnimationUtils.loadAnimation(this, R.anim.loading);
//        mImage.setAnimation(animation);
        mImage.setImageResource(R.drawable.loading);
        AnimationDrawable animationDrawable = (AnimationDrawable) mImage.getDrawable();
        animationDrawable.start();

    }

}
