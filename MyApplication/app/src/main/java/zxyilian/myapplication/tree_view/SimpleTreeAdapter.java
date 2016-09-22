package zxyilian.myapplication.tree_view;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.zhy.tree.bean.Node;
import com.zhy.tree.bean.TreeListViewAdapter;

import zxyilian.myapplication.R;
import zxyilian.myapplication.tree.bean.MessageDetaile;


public class SimpleTreeAdapter extends TreeListViewAdapter
{

	public SimpleTreeAdapter(ListView mTree, Context context, List<MessageDetaile> datas,
			int defaultExpandLevel) throws IllegalArgumentException,
			IllegalAccessException
	{
		super(mTree, context, datas, defaultExpandLevel);
	}




	@Override
	public View getConvertView(Node node , int position, View convertView, ViewGroup parent)
	{

		ViewHolder viewHolder = null;
		if (convertView == null)
		{
			convertView = mInflater.inflate(R.layout.list_item, parent, false);
			viewHolder = new ViewHolder();
			viewHolder.icon = (ImageView) convertView
					.findViewById(R.id.id_treenode_icon);
			viewHolder.label = (TextView) convertView
					.findViewById(R.id.id_treenode_label);
			convertView.setTag(viewHolder);

		} else
		{
			viewHolder = (ViewHolder) convertView.getTag();
		}

		if (node.getIcon() == -1)
		{
			viewHolder.icon.setVisibility(View.INVISIBLE);
		} else
		{
			viewHolder.icon.setVisibility(View.VISIBLE);
			viewHolder.icon.setImageResource(node.getIcon());
		}

		viewHolder.label.setText(node.getName());


		return convertView;
	}

//	@Override
//	public View getConvertView(Node node , int position, View convertView, ViewGroup parent)
//	{
//
//		ViewHolder viewHolder = null;
//		if (convertView == null)
//		{
//			convertView = mInflater.inflate(R.layout.list_item, parent, false);
//			viewHolder = new ViewHolder();
//			viewHolder.icon = (ImageView) convertView
//					.findViewById(R.id.id_treenode_icon);
//			viewHolder.label = (TextView) convertView
//					.findViewById(R.id.id_treenode_label);
//			convertView.setTag(viewHolder);
//
//		} else
//		{
//			viewHolder = (ViewHolder) convertView.getTag();
//		}
//
//		if (node.getIcon() == -1)
//		{
//			viewHolder.icon.setVisibility(View.INVISIBLE);
//		} else
//		{
//			viewHolder.icon.setVisibility(View.VISIBLE);
//			viewHolder.icon.setImageResource(node.getIcon());
//		}
//
//		viewHolder.label.setText(node.getName());
//
//
//		return convertView;
//	}

	private final class ViewHolder
	{
		ImageView icon;
		TextView label;
	}

}
