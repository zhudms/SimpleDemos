package com.demo.zxyl.patientlogindemo.weight;

import android.content.Context;

import com.demo.zxyl.patientlogindemo.MyApplication;
import com.demo.zxyl.patientlogindemo.R;
import com.demo.zxyl.patientlogindemo.events.EventBusHelper;
import com.demo.zxyl.patientlogindemo.events.IPChagedE;
import com.demo.zxyl.patientlogindemo.urils.LocalDataUtil;
import com.demo.zxyl.patientlogindemo.urils.ToastUtil;

/**
 * 更改IP的监听，本地数据的清理及重新写入本地数据在这里（貌似还是不太合理，稳定后修改）（目前认为在HomeAct中 IPChagedE广播中比较合理）
 */
public  class MyURLDialogLisener implements OnDialogLCickLisener {

    private Context mContext;
    private MySetIpDialog mURLDialog;

    public MyURLDialogLisener(Context mContext, MySetIpDialog mURLDialog) {
        this.mContext = mContext;
        this.mURLDialog = mURLDialog;
    }

    @Override
    public void onConfirm(String editString) {
        if (editString == null || editString.length() == 0) {
            ToastUtil.toast(mContext, R.string.ip_error);
        } else {
            MyApplication.clearData(mContext);
            LocalDataUtil.writeURLToPreferce(editString, mContext);
            EventBusHelper.post(new IPChagedE());
            mURLDialog.dismiss();

        }
    }

    @Override
    public void onCancle() {
        mURLDialog.dismiss();
    }
}