package zxyilian.tryfragmentflip;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {


    private FragmentManager mManager;
    private MyFragmetToShow myFragment;
    private FrameLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mManager = getSupportFragmentManager();
        myFragment = MyFragmetToShow.getInstance();
        mContainer = (FrameLayout) findViewById(R.id.container);

        mManager.beginTransaction().add(R.id.container, myFragment).addToBackStack(null).commit();

    }


}
