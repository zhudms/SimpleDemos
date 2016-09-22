package com.demo.zl.mytabdemo;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * 带Tab的Fragment的抽象类
 * <p/>
 * 保持逻辑的简洁，及页面切换时状态的保存，这样的结构现阶段是可以接受的
 * Created by TANG on 2016/3/5.
 */
public abstract class TabFragment extends BaseFragment {


    protected View mView;
    protected LinearLayout mTabsLinear;


    protected ArrayList<MyTabB> mTabs;

    private int[] mTabIds;
    protected MyTabItem mTempTab;

    protected int mTabPositionFormer;
    protected int mTabPositionNow = 0;

    public FragmentManager mChildFragmentManager;
    public int mChildContainerId;
    public TextView name;
    public TextView number;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        mView = inflater.inflate(R.layout.tabfragment_layout, null, false);
        mTabsLinear = (LinearLayout) mView.findViewById(R.id.tab_container);
        name = (TextView) mView.findViewById(R.id.paient_name);
        number = (TextView) mView.findViewById(R.id.paient_number);

        return mView;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTabs = new ArrayList<MyTabB>(VALUES.LISTDEFAULT_SIZE);
        mChildFragmentManager = getChildFragmentManager();
        mChildContainerId = R.id.tab_detail_frame;
    }


    public void switchTabFragment() {
        //在这里进行Fragment的切换

        FragmentTransaction transaction = mChildFragmentManager.beginTransaction();
        android.support.v4.app.Fragment fragmentFormer = mChildFragmentManager.findFragmentByTag(String.valueOf(mTabPositionFormer));
        android.support.v4.app.Fragment fragmentNew = mChildFragmentManager.findFragmentByTag(String.valueOf(mTabPositionNow));

        if (fragmentNew == null) {
            fragmentNew = getTabFragment(mTabPositionNow);
//            Log.e("TabFragment", "fragmentNew====" + fragmentNew);
            transaction.add(mChildContainerId, fragmentNew, String.valueOf(mTabPositionNow));
        }
        transaction.hide(fragmentFormer).show(fragmentNew).commit();
    }

    public abstract Fragment getTabFragment(int positionNow);

    private void hideTabs() {
        mTabsLinear.setVisibility(View.GONE);
    }


    private int clickPos = 0;
    public static TextView myFormerView; //无奈之举！！！！
    public FrameLayout rootView;

    public void addTabs(ArrayList<MyTabB> tabs) {


        if (tabs == null) {
            hideTabs();
            return;
        }

        this.mTabs.addAll(tabs);

        MyTabB mTab = null;
        MyTabItem mTabItem;

        rootView = (FrameLayout) getActivity().getWindow().getDecorView();
        mTabIds = new int[tabs.size()];

        for (int i = 0; i < tabs.size(); i++) {

            mTab = tabs.get(i);
            mTabItem = new MyTabItem(getActivity());

            mTabItem.setClickable(true);
            if (mTab.getPicResource() != VALUES.NORESOURCE) {
                mTabItem.setImage(mTab.getPicResource());
                mTabItem.setImageText(mTab.getText());
            } else {
                mTabItem.setImage(mTab.getPicDitmap());
            }


            mTabItem.showNewMessage(mTab.ifShow());


            mTabsLinear.addView(mTabItem, getTabParams());
            mTabItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (mTempTab.getId() == v.getId()) {
                        return;
                    }
                    mTabPositionFormer = mTabPositionNow;
                    mTempTab.setSelected(false);
                    mTempTab = (MyTabItem) v;
                    mTempTab.setSelected(true);
                    mTabPositionNow = getTabPosition();
                     // int[] location = new int[2];
                    //mTempTab.getLocationOnScreen(location);


                    MyTabItem former = (MyTabItem) mTabsLinear.getChildAt(clickPos);
/*                    if (myFormerView != null && myFormerView!=null) {
                        rootView.removeViewAt(rootView.indexOfChild(myFormerView));
                    }*/
                    former.getImageText().setTextColor(Color.GRAY);
                    mTempTab.getImageText().setTextColor(Color.GREEN);
                    for (int i = 0; i < mTabsLinear.getChildCount(); i++) {
                        if (((MyTabItem) mTabsLinear.getChildAt(i)) == mTempTab) {
                            clickPos = i;
                        }
                    }


/*                    TextView textView = new TextView(getActivity());
                    textView.setBackgroundColor(getResources().getColor(R.color.app_gray));

                    FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(4,
                            mTempTab.getHeight() - 2);
                    params.setMargins(location[0] + mTempTab.getWidth(), location[1], 0, 0);

                    myFormerView = textView;
                    rootView.addView(textView, params);*/

                    switchTabFragment();
                }
            });
            mTabItem.setId(getTabIds(i));
            mTabIds[i] = mTabsLinear.getChildAt(i).getId();
        }

        mTempTab = (MyTabItem) mTabsLinear.getChildAt(0);
        mTempTab.setSelected(true);
        mTempTab.getImageText().setTextColor(Color.RED);
        mTabPositionFormer = mTabPositionNow = mTempTab.getId();

/*        int[] location = new int[2];
        TextView textView = new TextView(getActivity());
        textView.setBackgroundColor(getResources().getColor(R.color.app_gray));
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(4,
                mTempTab.getHeight() - 2);
        params.setMargins(location[0] + mTempTab.getWidth(), location[1], 0, 0);
        myFormerView = textView;
        rootView.addView(textView, params);*/
    }


    private LinearLayout.LayoutParams getTabParams() {
//        LinearLayout.LayoutParams tabParams = new LinearLayout.LayoutParams
//                (DensityUtil.dp2px(this, getResources().getDimension(R.dimen.tab_with)),
//                        LinearLayout.LayoutParams.WRAP_CONTENT);
//        getActivity().getResources().getDimensionPixelSize(R.dimen.tab_item_picwith)
        LinearLayout.LayoutParams tabParams = new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
        tabParams.gravity = Gravity.CENTER_VERTICAL;

        return tabParams;
    }


    private int getTabPosition() {
        int menuID = mTempTab.getId();
        for (int i = 0; i < mTabIds.length; i++) {
            if (menuID == mTabIds[i]) {
                return i;
            }
        }
        return -1;
    }

//    public abstract void switchTabFragment();

    protected int getTabIds(int i) {
        switch (i) {
            case 0:
                return R.id.tab_zero;
            case 1:
                return R.id.tab_first;
            case 2:
                return R.id.tab_second;
            case 3:
                return R.id.tab_third;
            case 4:
                return R.id.tab_fourth;
            case 5:
                return R.id.tab_fifth;
            case 6:
                return R.id.tab_sixth;
            case 7:
                return R.id.tab_seventh;
            case 8:
                return R.id.tab_eighth;

            default:
                return 0;
        }
    }


}
