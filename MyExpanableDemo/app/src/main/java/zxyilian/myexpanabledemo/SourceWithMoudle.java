package zxyilian.myexpanabledemo;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by TANG on 2016/5/5.
 */
public class SourceWithMoudle extends BaseExpandableListAdapter {

    private Context mContext;

    private ArrayList<SourceDetailsB> mBeans;


    public SourceWithMoudle(Context context, ArrayList<SourceDetailsB> beans) {
        mContext = context;
        mBeans = beans;

    }


    @Override
    public int getGroupCount() {
        return mBeans.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        if (mBeans.get(groupPosition).getChildLists() != null) {

            return mBeans.get(groupPosition).getChildLists().size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mBeans.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mBeans.get(groupPosition).getChildLists().get(childPosition);
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
        SourceDetailsB bean = mBeans.get(groupPosition);
        String name = bean.getMODEL_NAME();
        View v;
        if (bean.getChildLists() == null || bean.getChildLists().size() == 0) {
            v = getChild(bean);
        } else {
            v = getGroup(name);
        }
        return v;
    }

    private View getGroup(String name) {
        TextView textView = new TextView(mContext);
        textView.setText(name);
        textView.setBackgroundColor(Color.RED);
        return textView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        SourceDetailsB source = mBeans.get(groupPosition).getChildLists().get(childPosition);

        View v = getChild(source);
        return v;
    }

    private View getChild(SourceDetailsB source) {
        TextView textView = new TextView(mContext);
        textView.setText(source.getTITLE());
        textView.setBackgroundColor(Color.BLUE);
        return textView;

    }


    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
