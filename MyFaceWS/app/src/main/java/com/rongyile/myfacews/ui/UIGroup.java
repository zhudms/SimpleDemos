package com.rongyile.myfacews.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rongyile.myfacews.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rongyile on 2017/8/16.
 */

public class UIGroup extends RelativeLayout {

    private static final String TAG = "asd";
    private ArrayList<Bitmap> faceLists;
    private Context mContext;
    public static final int maxShown = 3;//最多显示多少个view
    private int mWidth;
    private int mHeigth;
    private int spiderwidth = 30;
    private int showNumb = 0;//当前界面显示多少个view
    private int childWidth=400;//每个子项的宽度
    private List<Integer> childX = new ArrayList<>();


    public UIGroup(Context context) {
        super(context);
        mContext = context;
//        LayoutInflater.from(context).inflate(R.layout.grouplayout, this, true);
    }


    public UIGroup(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        mHeigth = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);

        int shownNumb = getShownChildNumb();
        if (shownNumb <= 0) {
            return;
        }
//        childWidth = mWidth/(shownNumb + 1);
        spiderwidth =( mWidth-shownNumb*childWidth) / (shownNumb + 1);
        Integer left = 0;
        childX.clear();
        for (int i = 0; i < shownNumb; i++) {

            left = spiderwidth * (i + 1) + i * childWidth;
            childX.add(left);
        }

    }

    //    @Override
//    public int getChildCount() {
//        return getShownChildNumb();
//    }
//
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        View childView;


        int shownNumb = getShownChildNumb();
        if (shownNumb <= 0) {
            super.onLayout(changed, l, t, r, b);
        } else {

            final int count = getChildCount();

//        for (int i = 0; i < count; i++) {
//            View child = getChildAt(i);
//            if (child.getVisibility() != GONE) {
//                RelativeLayout.LayoutParams st =
//                        (RelativeLayout.LayoutParams) child.getLayoutParams();
//                child.layout(st.mLeft, st.mTop, st.mRight, st.mBottom);
//            }
//        }
            for (int i = 0; i < count; i++) {
                childView = getChildAt(i);
                if (childView.getVisibility() != GONE) {
                    int left = childX.get(i);
//            int top = (getMeasuredHeight() - mHeigth) / 2;
                    int top = 0;
                    int right = left + childWidth;
                    int bottom = top + mHeigth;
                    childView.layout(left, top, right, bottom);
                    childView.setPivotX(0);
                    childView.setPivotY(mHeigth / 2);
                }
            }
        }


    }

    public void addFaces(Bitmap bitmap) {
        faceLists.add(bitmap);
        UIChild child = (UIChild) getUnShownView();
        if (child != null) {
            child.setmBitmap(bitmap);
            startShow(child);
        } else {
            faceLists.add(bitmap);
        }

    }

    public void startShow(UIChild child) {
//        child.setVisibility(View.VISIBLE);
LayoutParams paramers=new LayoutParams(300,300);
        if (getShownChildNumb()>=maxShown){
            child.setVisibility(GONE);
        }
        child.setBackgroundColor(Color.GREEN);
        addView(child,paramers);
        invalidate();


//        TextView t = new TextView(mContext);
//        t.setBackgroundColor(Color.BLUE);
//        t.setText(System.currentTimeMillis()+"fsaf35grestbvuTSDHGUrejfiejrigjeirtug");
//        if (getShownChildNumb()>=maxShown){
//            t.setVisibility(GONE);
//        }
//        addView(t);
////        requestLayout();
//        invalidate();

//        notify();
    }

    public int getShownChildNumb() {

        int num = 0;
        for (int i = 0; i < getChildCount(); i++) {
//            Log.e(TAG, "getShownChildNumb: " + getChildCount() + ",currentNUmb=" +getChildCount());
            if (getChildAt(i).getVisibility() == View.VISIBLE) {
                num++;
            }
        }

        return num;

    }

    public UIChild getUnShownView() {
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i).getVisibility() == GONE) {
                return ((UIChild) getChildAt(i));
            }
        }

        return null;
    }
}
