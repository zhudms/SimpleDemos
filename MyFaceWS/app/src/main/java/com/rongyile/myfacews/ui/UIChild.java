package com.rongyile.myfacews.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.rongyile.myfacews.R;

/**
 * Created by rongyile on 2017/8/16.
 */

public class UIChild extends RelativeLayout implements MoveAble {
    private Bitmap mBitmap;
    private ImageView mImageView;

    public UIChild(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UIChild(Context context, Bitmap mBitmap) {
        super(context);
        this.mBitmap = mBitmap;
        initShow(context);
    }

    public UIChild(Context context) {
        super(context);
        initShow(context);

    }

    private void initShow(Context context) {
        addView(LayoutInflater.from(context).inflate(R.layout.childlayout, null, false));
        mImageView = ((ImageView) findViewById(R.id.child_img));
        mImageView.setImageBitmap(mBitmap);
        mImageView.setBackgroundColor(Color.RED);

    }

    @Override
    public void onAdd() {

    }

    @Override
    public void onRemove() {
        mBitmap.recycle();
        mBitmap = null;

    }

    public void setmBitmap(Bitmap mBitmap) {
        this.mBitmap = mBitmap;
    }
}
