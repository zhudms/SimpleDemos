package zxyilian.tryfragmentflip;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by TANG on 2016/5/9.
 */
public class FragmentOne extends Fragment {


    public static FragmentOne getInstance(){
        return  new FragmentOne();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frame_one,null,false);
    }
}
