package com.demo.zl.myshadowdemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
//import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.demo.zl.myshadowdemo.utils.ZDepth;
import com.demo.zl.myshadowdemo.utils.ZDepthShadowLayout;

public class ShadowActivity extends Activity {

    private ZDepthShadowLayout mZDepthShadowLayoutRect;
    private ZDepthShadowLayout mZDepthShadowLayoutRect2;
    private ZDepthShadowLayout mZDepthShadowLayoutRect1;
private int count=0;

//    private CardView mCardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shadow);
//        setContentView(R.layout.activity_card);
        Button b= ((Button) findViewById(R.id.button));
        Button b1= ((Button) findViewById(R.id.button1));
//        mCardView= ((CardView) findViewById(R.id.card_view2));
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mCardView.setCardElevation(5f);
//
//            }
//        });
        mZDepthShadowLayoutRect = ((ZDepthShadowLayout) findViewById(R.id.zDepthShadowLayout_rect2));
        mZDepthShadowLayoutRect2 = ((ZDepthShadowLayout) findViewById(R.id.zDepthShadowLayout_rect3));
        mZDepthShadowLayoutRect1 = ((ZDepthShadowLayout) findViewById(R.id.zDepthShadowLayout_rect1));

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
replace();
//                change();
            }
        });
b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

//        change();

        changeBack();
    }
});
    }

    private void changeBack() {
        if (count%2==0){
            mZDepthShadowLayoutRect1.setBackgroundResource(R.drawable.item_select_bacground);
        }else{
            mZDepthShadowLayoutRect1.setBackgroundColor(Color.WHITE);
        }
    }

    private void replace() {
        count++;
        if (count%2==0){
            mZDepthShadowLayoutRect.changeZDepth(ZDepth.Depth5);
            mZDepthShadowLayoutRect2.changeZDepth(ZDepth.Depth0);
        }else{
            mZDepthShadowLayoutRect2.changeZDepth(ZDepth.Depth5);
            mZDepthShadowLayoutRect.changeZDepth(ZDepth.Depth0);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(ShadowActivity.this,"onResume",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(ShadowActivity.this,"onStart",Toast.LENGTH_SHORT).show();


//        ZDepthShadowLayout mZDepthShadowLayoutOval= ((ZDepthShadowLayout) findViewById(R.id.zDepthShadowLayout_oval));


//        mZDepthShadowLayoutOval.changeZDepth(ZDepth.Depth2);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Toast.makeText(ShadowActivity.this,"onAttachToWindow",Toast.LENGTH_SHORT).show();
    }

    public void change(){
//        Toast.makeText(ShadowActivity.this,"coutnt="+count,Toast.LENGTH_SHORT).show();
        count++;
        Toast.makeText(ShadowActivity.this,"count="+count%6,Toast.LENGTH_SHORT).show();
        switch (count%6){
            case 0:
                mZDepthShadowLayoutRect1.changeZDepth(ZDepth.Depth0);

                break;
            case 1:
                mZDepthShadowLayoutRect1.changeZDepth(ZDepth.Depth1);
break;
            case 2:
                mZDepthShadowLayoutRect1.changeZDepth(ZDepth.Depth2);
                break;

            case 3:
                mZDepthShadowLayoutRect1.changeZDepth(ZDepth.Depth3);
                break;
            case 4:
                mZDepthShadowLayoutRect1.changeZDepth(ZDepth.Depth4);
                break;
            case 5:
                mZDepthShadowLayoutRect1.changeZDepth(ZDepth.Depth5);
                break;
default:
    mZDepthShadowLayoutRect1.changeZDepth(ZDepth.Depth1);

        }


    }
}
