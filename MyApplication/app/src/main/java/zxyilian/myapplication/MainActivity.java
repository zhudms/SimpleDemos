package zxyilian.myapplication;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.zhy.tree.bean.Node;
import com.zhy.tree.bean.TreeListViewAdapter;
import com.zhy.tree.bean.TreeListViewAdapter.OnTreeNodeClickListener;

import zxyilian.myapplication.R;
import zxyilian.myapplication.bean.Bean;
import zxyilian.myapplication.bean.FileBean;
import zxyilian.myapplication.tree.bean.MessageDetaile;
import zxyilian.myapplication.tree_view.SimpleTreeAdapter;

public class MainActivity extends Activity
{
//	private List<Bean> mDatas = new ArrayList<Bean>();
//	private List<FileBean> mDatas2 = new ArrayList<FileBean>();
	private List<MessageDetaile> mDatas2 = new ArrayList<MessageDetaile>();
	private ListView mTree;
	private TreeListViewAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initDatas();
		mTree = (ListView) findViewById(R.id.id_tree);
		try
		{
			mAdapter = new SimpleTreeAdapter<MessageDetaile>(mTree, this, mDatas2, 10);
			mAdapter.setOnTreeNodeClickListener(new OnTreeNodeClickListener()
			{
				@Override
				public void onClick(Node node, int position)
				{
					if (node.isLeaf())
					{
						Toast.makeText(getApplicationContext(), node.getName(),
								Toast.LENGTH_SHORT).show();
					}
				}

			});

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		mTree.setAdapter(mAdapter);

	}

	private void initDatas()
	{
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

//		mDatas2.add(new FileBean(1, 0, "文件管理系统"));
//		mDatas2.add(new FileBean(2, 1, "游戏"));
//		mDatas2.add(new FileBean(3, 1, "文档"));
//		mDatas2.add(new FileBean(4, 1, "程序"));
//		mDatas2.add(new FileBean(5, 2, "war3"));
//		mDatas2.add(new FileBean(6, 2, "刀塔传奇"));
//
//		mDatas2.add(new FileBean(7, 4, "面向对象"));
//		mDatas2.add(new FileBean(8, 4, "非面向对象"));
//
//		mDatas2.add(new FileBean(9, 7, "C++"));
//		mDatas2.add(new FileBean(10, 7, "JAVA"));
//		mDatas2.add(new FileBean(11, 7, "Javascript"));
//		mDatas2.add(new FileBean(12, 8, "C"));


				mDatas2.add(new MessageDetaile(1, 0, "文件管理系统"));
		mDatas2.add(new MessageDetaile(2, 1, "游戏"));
		mDatas2.add(new MessageDetaile(3, 1, "文档"));
		mDatas2.add(new MessageDetaile(4, 1, "程序"));
		mDatas2.add(new MessageDetaile(5, 2, "war3"));
		mDatas2.add(new MessageDetaile(6, 2, "刀塔传奇"));

		mDatas2.add(new MessageDetaile(7, 4, "面向对象"));
		mDatas2.add(new MessageDetaile(8, 4, "非面向对象"));

		mDatas2.add(new MessageDetaile(9, 7, "C++"));
		mDatas2.add(new MessageDetaile(10, 7, "JAVA"));
		mDatas2.add(new MessageDetaile(11, 7, "Javascript"));
		mDatas2.add(new MessageDetaile(12, 8, "C"));



	}

}
