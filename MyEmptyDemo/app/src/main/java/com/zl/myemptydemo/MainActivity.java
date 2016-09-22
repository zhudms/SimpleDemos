package com.zl.myemptydemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private RelativeLayout mRootView;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = ((ListView) findViewById(R.id.listview));
        mRootView = ((RelativeLayout) findViewById(R.id.root));
        mAdapter = new MyAdapter(new ArrayList<String>(), this);
        mListView.setAdapter(mAdapter);
        addEmptyView();

    }

    private void addEmptyView() {
        View v = View.inflate(MainActivity.this, R.layout.list_empty_view, null);
        v.setVisibility(View.GONE);
        mRootView.addView(v);
        mListView.setEmptyView(v);
    }

}
