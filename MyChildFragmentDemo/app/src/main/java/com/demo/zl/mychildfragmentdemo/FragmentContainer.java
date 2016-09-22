package com.demo.zl.mychildfragmentdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by TANG on 2016/9/1.
 * MyChildFragmentDemo
 */
public class FragmentContainer extends Fragment {
    private static final String ONE = "1";
    private static final String TWO = "2";
    private static final String THREE = "3";
    View v;


    MyDemoFrag demoFrag1;
    MyDemoFrag demoFrag2;
    MyDemoFrag demoFrag3;
    Button button;
    int count = 0;

    MyDemoFrag currentFrag;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.container_layout, null, false);

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button = ((Button) v.findViewById(R.id.button));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment;
                if (count % 3 == 0) {
                    fragment = getChildFragmentManager().findFragmentByTag(ONE);
                    if (fragment == null) {
                        fragment = MyDemoFrag.getInstance(Color.RED);
                        getChildFragmentManager().beginTransaction().add(R.id.fragment_container, fragment, ONE).show(fragment).addToBackStack(ONE).commit();
                    } else {
                        getChildFragmentManager().beginTransaction().hide(currentFrag).show(fragment).commit();
                    }
                    currentFrag = ((MyDemoFrag) fragment);

                } else if (count % 3 == 1) {
                    fragment = getChildFragmentManager().findFragmentByTag(TWO);
                    if (fragment == null) {
                        fragment = MyDemoFrag.getInstance(Color.GREEN);
                        getChildFragmentManager().beginTransaction().add(R.id.fragment_container, fragment, TWO).show(fragment).addToBackStack(TWO).commit();
                    } else {
                        getChildFragmentManager().beginTransaction().hide(currentFrag).show(fragment).commit();
                    }

                    currentFrag = ((MyDemoFrag) fragment);
                } else if (count % 3 == 2) {
                    fragment = getChildFragmentManager().findFragmentByTag(THREE);
                    if (fragment == null) {
                        fragment = MyDemoFrag.getInstance(Color.BLUE);

                        getChildFragmentManager().beginTransaction().add(R.id.fragment_container, fragment, THREE).hide(currentFrag).show(fragment).addToBackStack(THREE).commit();
                    } else {
                        getChildFragmentManager().beginTransaction().hide(currentFrag).show(fragment).commit();
                    }
                    currentFrag = ((MyDemoFrag) fragment);

                }
                count++;
            }
        });

        {
            demoFrag1 = MyDemoFrag.getInstance(Color.RED);
            demoFrag2 = MyDemoFrag.getInstance(Color.GREEN);
            demoFrag3 = MyDemoFrag.getInstance(Color.BLUE);

            getChildFragmentManager().beginTransaction().add(R.id.fragment_container, demoFrag1, ONE).hide(demoFrag1).addToBackStack(null).commit();
            getChildFragmentManager().beginTransaction().add(R.id.fragment_container, demoFrag2, TWO).hide(demoFrag2).addToBackStack(null).commit();
            getChildFragmentManager().beginTransaction().add(R.id.fragment_container, demoFrag3, THREE).hide(demoFrag3).addToBackStack(null).commit();
            currentFrag = demoFrag3;
        }
    }

}
