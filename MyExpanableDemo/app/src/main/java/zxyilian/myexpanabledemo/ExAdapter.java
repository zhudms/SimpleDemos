package zxyilian.myexpanabledemo;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by TANG on 2016/5/5.
 */
public class ExAdapter extends BaseExpandableListAdapter {

    private Context mContext;

    private String[] mGroup;
    private String[][] mChilds;

    public ExAdapter(Context context ,String[] group, String[][] child) {
        mContext=context;
        mGroup = group;
        mChilds = child;

    }


    @Override
    public int getGroupCount() {
        return mGroup.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mChilds[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mGroup[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mChilds[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
      String name=mGroup[groupPosition];
        View v=getGroup(name);
        return v;
    }

    private View getGroup(String name) {
        TextView textView=new TextView(mContext);
        textView.setText(name);
        textView.setBackgroundColor(Color.RED);
        return textView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String name=mChilds[groupPosition][childPosition];
        View v=getChild(name);
        return v;
    }

    private View getChild(String name) {

        TextView textView=new TextView(mContext);
        textView.setText(name);
        textView.setBackgroundColor(Color.BLUE);
        return textView;

    }


    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
