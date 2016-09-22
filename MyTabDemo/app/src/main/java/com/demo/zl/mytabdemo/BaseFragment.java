package com.demo.zl.mytabdemo;

import android.support.v4.app.Fragment;

/**
 * Created by TANG on 2016/4/6.
 */
public class BaseFragment extends Fragment {

    protected String TAG=getClass().getSimpleName()+":";

    @Override
    public void onDetach() {
        super.onDetach();

//        try {
//
//            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
//            childFragmentManager.setAccessible(true);
//            childFragmentManager.set(this, null);
//        } catch (NoSuchFieldException e) {
//            throw new RuntimeException(e);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }
    }




}
