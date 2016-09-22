package zxyilian.mytreelistdemo;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import zxyilian.mytreelistdemo.bean.MessageDetaile;
import zxyilian.mytreelistdemo.bean.Node;
import zxyilian.mytreelistdemo.bean.TreeListViewAdapter;
import zxyilian.mytreelistdemo.bean.SimpleTreeAdapter;

public class MainActivity extends Activity {
    //	private List<Bean> mDatas = new ArrayList<Bean>();
    private List<MessageDetaile> mDatas2 = new ArrayList<MessageDetaile>();
    private List<MessageDetaile> mLists = new ArrayList<MessageDetaile>();

    private ListView mTree;
    private TreeListViewAdapter mAdapter;
    private MessageDetaile detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDatas();
        mTree = (ListView) findViewById(R.id.id_tree);
        try {
            mAdapter = new SimpleTreeAdapter<MessageDetaile>(mTree, this, mDatas2, 10);
            mAdapter.setOnTreeNodeClickListener(new TreeListViewAdapter.OnTreeNodeClickListener() {
                @Override
                public void onClick(Node node, int position) {
                    if (node.isLeaf()) {
                        Toast.makeText(getApplicationContext(), node.getName(),
                                Toast.LENGTH_SHORT).show();
                    }
                }

            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        mTree.setAdapter(mAdapter);

    }


    private void initView() {
        MessageDetaile detaile;


        for (int i = 0; i < 7; i++) {

            detaile = new MessageDetaile();
            detaile.level = i;
            detaile.title = "title";
            detaile.message = "message";
            detaile.isCollected = true;
            detaile.isNewMessage = false;
            detaile.pId = 2;
            detaile.time = "2010." + i;
            detaile.type = i % 2;
            detaile.isExpand = true;
            mLists.add(detaile);

            if (i % 2 == 0) {
                MessageDetaile
                        detaile2 = new MessageDetaile();
                detaile2.level = i;
                detaile2.message = "message";
                detaile2.isCollected = true;
                detaile2.isNewMessage = false;
                detaile.isLeaf = false;
                detaile2.time = "2010." + i;
                detaile2.type = i % 2;
                detaile2.isExpand = true;
                mLists.add(detaile2);
            } else {
                detaile.isLeaf = true;
            }
        }
    }

    private void initDatas() {
//		mDatas.add(new Bean(1, 0, "根目录1"));
//		mDatas.add(new Bean(2, 0, "根目录2"));
//		mDatas.add(new Bean(3, 0, "根目录3"));
//		mDatas.add(new Bean(4, 0, "根目录4"));
//		mDatas.add(new Bean(5, 1, "子目录1-1"));
//		mDatas.add(new Bean(6, 1, "子目录1-2"));
//
//		mDatas.add(new Bean(7, 5, "子目录1-1-1"));
//		mDatas.add(new Bean(8, 2, "子目录2-1"));
//
//		mDatas.add(new Bean(9, 4, "子目录4-1"));
//		mDatas.add(new Bean(10, 4, "子目录4-2"));
//
//		mDatas.add(new Bean(11, 10, "子目录4-2-1"));
//		mDatas.add(new Bean(12, 10, "子目录4-2-3"));
//		mDatas.add(new Bean(13, 10, "子目录4-2-2"));
//		mDatas.add(new Bean(14, 9, "子目录4-1-1"));
//		mDatas.add(new Bean(15, 9, "子目录4-1-2"));
//		mDatas.add(new Bean(16, 9, "子目录4-1-3"));

        mDatas2.add(new MessageDetaile(1, 0, "文件管理系统", mLists.get(0)));
        mDatas2.add(new MessageDetaile(2, 1, "游戏", mLists.get(0)));
        mDatas2.add(new MessageDetaile(3, 1, "文档", mLists.get(0)));
        mDatas2.add(new MessageDetaile(4, 1, "程序", mLists.get(0)));
        mDatas2.add(new MessageDetaile(5, 2, mLists.get(0).message, mLists.get(0)));
        mDatas2.add(new MessageDetaile(6, 2, "刀塔传奇", mLists.get(0)));

        mDatas2.add(new MessageDetaile(7, 4, "面向对象", mLists.get(0)));
        mDatas2.add(new MessageDetaile(8, 4, "非面向对象", mLists.get(0)));

        mDatas2.add(new MessageDetaile(9, 7, "C++", mLists.get(0)));
        mDatas2.add(new MessageDetaile(10, 7, "JAVA", mLists.get(0)));
        mDatas2.add(new MessageDetaile(11, 7, "Javascript", mLists.get(0)));
        mDatas2.add(new MessageDetaile(12, 8, "C", mLists.get(0)));

    }

}
