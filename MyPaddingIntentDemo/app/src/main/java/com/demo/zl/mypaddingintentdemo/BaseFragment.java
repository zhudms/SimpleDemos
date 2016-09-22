package com.demo.zl.mypaddingintentdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by TANG on 2016/9/14.
 * MyPaddingIntentDemo
 */
public abstract class BaseFragment extends Fragment {

    protected View mRootView;

    protected abstract int getLayoutID();

    protected abstract void initData();//所有不需要layout支持的数据都在这里初始化

    protected abstract void initView();

    protected abstract void getDataToshow();
    protected abstract void clearShow();
    protected abstract void hideChildFragment(String tag);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return mRootView = inflater.inflate(getLayoutID(), null, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }
}
