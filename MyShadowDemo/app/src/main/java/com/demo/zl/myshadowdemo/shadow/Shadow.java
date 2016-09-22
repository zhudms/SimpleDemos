package com.demo.zl.myshadowdemo.shadow;

import android.graphics.Canvas;

import com.demo.zl.myshadowdemo.utils.ZDepthParam;


public interface Shadow {
    public void setParameter(ZDepthParam parameter, int left, int top, int right, int bottom);
    public void onDraw(Canvas canvas);
}
