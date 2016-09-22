package com.demo.zl.mychilddemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout relativeLayout = ((RelativeLayout) findViewById(R.id.root));
        relativeLayout.addView(new ImageView(MainActivity.this));

//        System.out.print("childCount=" + relativeLayout.getChildCount());
        Log.d("asd", "childCount=" + relativeLayout.getChildCount());
        ((View) relativeLayout.getChildAt(1)).setVisibility(View.GONE);
        Log.d("asd", "2__childCount=" + relativeLayout.getChildCount());
//        System.out.print("2__childCount=" + relativeLayout.getChildCount());
    }


}
