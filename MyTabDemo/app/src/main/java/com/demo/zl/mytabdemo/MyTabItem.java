package com.demo.zl.mytabdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by TANG on 2016/4/2.
 */
public class MyTabItem extends RelativeLayout {


    private ImageView mPicImage;
    private TextView mNewMessage;
    private RelativeLayout mlayou;
    private TextView imageText;
    private Bitmap bitmap;
    private String text;



    public MyTabItem(Context context) {
        super(context);
        mlayou=(RelativeLayout)LayoutInflater.from(context).inflate(R.layout.tabs_item_layout, null, false);
        addView(mlayou);
        mPicImage = (ImageView) findViewById(R.id.tabs_image);
        mNewMessage = (TextView) findViewById(R.id.tabs_newmessage);
        imageText = (TextView)findViewById(R.id.image_text);
    }

    public void setImage(int resourse) {
        mPicImage.setImageResource(resourse);
    }

    public void setImage(Bitmap bitmap) {
        mPicImage.setImageBitmap(bitmap);
        this.bitmap = bitmap;
    }

    public void showNewMessage(boolean ifShow) {
        if (ifShow) {
            mNewMessage.setVisibility(View.VISIBLE);
        } else {
            mNewMessage.setVisibility(View.GONE);
        }
    }

    public void setImageText(String resourse) {
        this.text =resourse;
        imageText.setText(resourse);
    }
    public TextView getImageText(){return imageText;}

    public Bitmap getmPicImage(){return bitmap;}
    public String getImageTextString(){return text;}
}



