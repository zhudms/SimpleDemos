package zxyilian.myexpanabledemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;

public class MainActivity extends AppCompatActivity {

    ExpandableListView mExpanableListVeiw;
    ExAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mExpanableListVeiw = (ExpandableListView) findViewById(R.id.list);


        String[] group = {"group_1", "group_2"};
        String[][] child = new String[group.length][12];
        for (int i=0;i<5;i++){
            child[0][i]="child_"+i;
        }

        mAdapter = new ExAdapter(this, group, child);
        mExpanableListVeiw.setAdapter(mAdapter);


    }


}
