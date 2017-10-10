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
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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
    private int childWidth = 400;//每个子项的宽度
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
        spiderwidth = (mWidth - shownNumb * childWidth) / (shownNumb + 1);
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

            for (int i = 0; i < count; i++) {
                childView = getChildAt(i);
                if (childView.getVisibility() == VISIBLE) {
                    int left = childX.get(i);
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
//
//    public void addFaces(Bitmap bitmap) {
//        faceLists.add(bitmap);
//        UIChild child = (UIChild) getUnShownView();
//        if (child != null) {
//            child.setmBitmap(bitmap);
//            startShow(child);
//        } else {
//            faceLists.add(bitmap);
//        }
//
//    }

    public void startShow( UIChild child) {
        boolean isMore = false;

        if (getShownChildNumb() >= maxShown) {
            child.setVisibility(INVISIBLE);
            isMore = true;
        }
//
        child.setBackgroundColor(Color.GREEN);
        if (getChildCount() > 0) {
            TranslateAnimation animation;
            View view;
            int i;
            for (i = 0; i < getChildCount() - 1; i++) {
                Log.d(TAG, "startShow: i=" + i);
                view = getChildAt(i);
                animation = getTranslateAnimation(view);
                view.startAnimation(animation);
            }
            Log.d(TAG, "startShow: i=" + i);
            view = getChildAt(i);
            AlphaAnimation alphaAnimation = getAlphaAnimation(view);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    Toast.makeText(mContext, "onAnimationStart: onAnimaition end", Toast.LENGTH_SHORT).show();
                    final LayoutParams paramers = new LayoutParams(300, 300);
                    addView(child, paramers);
//                    removeViewAt(0);
                    invalidate();
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
//            view.startAnimation(alphaAnimation);


//            TranslateAnimation animation = new TranslateAnimation();
//            animation.setDuration(1000);
//
//            animation.setAnimationListener(new Animation.AnimationListener() {
//                @Override
//                public void onAnimationStart(Animation animation) {
//                    Toast.makeText(mContext, "onAnimationStart: onAnimaition Start", Toast.LENGTH_SHORT).show();
////                    Log.d(TAG, "onAnimationStart: onAnimaition Start");
//                }
//
//                @Override
//                public void onAnimationEnd(Animation animation) {
//                    Toast.makeText(mContext, "onAnimationStart: onAnimaition end", Toast.LENGTH_SHORT).show();
//                    final LayoutParams paramers = new LayoutParams(300, 300);
//                    addView(child, paramers);
//                    invalidate();
//
//                }
//
//                @Override
//                public void onAnimationRepeat(Animation animation) {
//
//                }
//            });
//            for (int i = 0; i < getChildCount(); i++) {
//                getChildAt(i).startAnimation(animation);
//
//            }


//        } else {
            addView(child);
//            invalidate();
//            AlphaAnimation alphaAnimation = getAlphaAnimation(child);
//            alphaAnimation.start();
//        }


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

    private TranslateAnimation getTranslateAnimation(final View child) {

        float x = child.getX();
        float y = child.getY();

        TranslateAnimation animation = new TranslateAnimation(x, -(childWidth + spiderwidth), y, y);
        animation.setDuration(1000);

        return animation;

    }

    private AlphaAnimation getAlphaAnimation(final View child) {
        AlphaAnimation animation = new AlphaAnimation(0f, 1f);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                final LayoutParams paramers = new LayoutParams(300, 300);
                addView(child, paramers);
                invalidate();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        return animation;

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
