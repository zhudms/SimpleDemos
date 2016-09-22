package zxyilian.myexpanabledemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;

import java.util.ArrayList;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by TANG on 2016/5/5.
 */
public class TryAct extends Activity {

    ExpandableListView mExpanableListVeiw;
    SourceWithMoudle mAdapter;

    ArrayList<SourceDetailsB> mLists = new ArrayList<>();
    MyHttp mHttp;

    String tempMoudle = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initRetrifit();
        setContentView(R.layout.activity_main);
        mExpanableListVeiw = (ExpandableListView) findViewById(R.id.list);
        mAdapter = new SourceWithMoudle(this, mLists);
        mExpanableListVeiw.setAdapter(mAdapter);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMessage();

            }
        });

        mExpanableListVeiw.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                Log.d("asd", "groupPosition=" + groupPosition + ",childPosition=" + childPosition);
                return true;
            }
        });


        mExpanableListVeiw.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Log.d("asd", "groupPosition=" + groupPosition);
                return false;
            }
        });


    }

    private void initRetrifit() {
        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl("http://192.168.1.53:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mHttp = restAdapter.create(MyHttp.class);
    }


    private void getMessage() {
        Call<ResultBeans<SourceDetailsB>> call = mHttp.getSourceDetails("85670A0A1DAC4A0282F403CC72546091",
                "1CD342661A5241629B9AE4487725D278");
        call.enqueue(new Callback<ResultBeans<SourceDetailsB>>() {
            @Override
            public void onResponse(Response<ResultBeans<SourceDetailsB>> response, Retrofit retrofit) {
                if (response != null && response.body() != null) {

                    shortResponse(response.body().getINFO());
                } else {
                    Log.d("asd", "getFaile");
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    private void shortResponse(ArrayList<SourceDetailsB> info) {

        ArrayList<SourceDetailsB> arrayList = new ArrayList<>(info.size());

        String mTempMoudle = new String();

        if (mLists.size() != 0) {//使用逻辑控制，这里应该不需要，需要对数据进行去重处理
            mTempMoudle = mLists.get(mLists.size() - 1).getMODEL_NAME();
        }

        SourceDetailsB source;
        String currentModel;
        for (int i = 0, len = info.size(); i < len; i++) {
            source = info.get(i);
            currentModel = source.getMODEL_NAME();
            if (currentModel == null || currentModel.length() == 0) {

                //没有模板直接添加
                arrayList.add(source);
                mTempMoudle = "";
            } else {//先做效果这里数据有逻辑问题
                //有模板

                if (mTempMoudle.equals(currentModel)) {//添加到上一个里
                    SourceDetailsB detailsParent = arrayList.get(arrayList.size() - 1);
                    detailsParent.addChild(source);
                } else {
                    SourceDetailsB detailsB = new SourceDetailsB(currentModel);
                    detailsB.addChild(source);
                    arrayList.add(detailsB);
                    mTempMoudle = currentModel;

                }
            }
        }

        mLists.addAll(arrayList);
        mAdapter.notifyDataSetChanged();
    }
}
