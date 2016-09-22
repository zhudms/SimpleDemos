package zxyilian.tryfragmentflip;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TANG on 2016/5/9.
 */
public class MyFragmetToShow extends MyFragment {



    public static MyFragmetToShow getInstance(){
        MyFragmetToShow toShow=new MyFragmetToShow();
        return  toShow;
    }

    @Override
    protected int supplyTabs(List<TabInfo> tabs) {

        TabInfo info_1=new TabInfo(0,"one",FragmentOne.class);
        TabInfo info_2=new TabInfo(0,"one",FragmentTwo.class);
        tabs.add(info_1);
        tabs.add(info_2);
        return 0;
    }
}
