package zxyilian.pulltoreflushdemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by TANG on 2016/5/22.

 */
public class SimpleAdapter extends BaseAdapter {
    private ArrayList<PatientB> patients;
    private Context mContexts;

    public SimpleAdapter(ArrayList<PatientB> patients, Context mContexts) {
        this.patients = patients;
        this.mContexts = mContexts;
    }

    @Override
    public int getCount() {
        return patients.size();
    }

    @Override
    public Object getItem(int position) {
        return patients.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=new TextView(mContexts);
        ((TextView)convertView).setText(patients.get(position).getNAME());
        return convertView;
    }
}
