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
public class FragmentTwo extends Fragment {
    public static FragmentTwo getInstance() {
        return new FragmentTwo();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frame_two, null, false);
    }
}
