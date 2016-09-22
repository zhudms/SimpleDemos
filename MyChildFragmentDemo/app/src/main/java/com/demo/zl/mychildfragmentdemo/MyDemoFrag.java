package com.demo.zl.mychildfragmentdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by TANG on 2016/9/1.
 * MyChildFragmentDemo
 */
public class MyDemoFrag extends Fragment {
    private static final String COLOR = "color";

    View v;

    public static  MyDemoFrag getInstance(int color) {
        MyDemoFrag demoFrag = new MyDemoFrag();

        Bundle bundle = new Bundle();
        bundle.putInt(COLOR, color);
        demoFrag.setArguments(bundle);

        return demoFrag;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.content_main, null, false);

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        v.findViewById(R.id.tv).setBackgroundColor(getArguments().getInt(COLOR));
    }
}
