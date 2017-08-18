package com.rongyile.myfacews.eventBean;

import android.graphics.Bitmap;

/**
 * Created by rongyile on 2017/8/16.
 */

public class WSReconizeFaceE {

    private Bitmap mReconizaFace;

    public WSReconizeFaceE(Bitmap mReconizaFace) {
        this.mReconizaFace = mReconizaFace;
    }

    public Bitmap getmReconizaFace() {
        return mReconizaFace;
    }
}
