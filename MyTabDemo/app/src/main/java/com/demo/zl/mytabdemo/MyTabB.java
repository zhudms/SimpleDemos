package com.demo.zl.mytabdemo;

import android.graphics.Bitmap;


/**
 * 侧边导航
 * Created by TANG on 2016/4/2.
 */
public class MyTabB {

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String text;
    private int picResource =-1;
    private Bitmap picDitmap;

    private boolean ifShow=false;

    public int getPicResource() {
        return picResource;
    }

    public void setPicResource(int picResource) {
        this.picResource = picResource;
    }

    public boolean ifShow() {
        return ifShow;
    }

    public void setIfShow(boolean ifShow) {
        this.ifShow = ifShow;
    }

    public Bitmap getPicDitmap() {
        return picDitmap;
    }

    public void setPicDitmap(Bitmap picDitmap) {
        this.picDitmap = picDitmap;
    }

}
