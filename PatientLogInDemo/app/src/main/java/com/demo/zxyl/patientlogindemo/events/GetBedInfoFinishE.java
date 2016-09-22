package com.demo.zxyl.patientlogindemo.events;


import com.demo.zxyl.patientlogindemo.beans.BedMessageB;

/**
 * 获取床位信息成功（用于请求患者信息）
 * 应用新开启时无床位信息
 * Created by TANG on 2016/6/6.
 * Patient
 */
public class GetBedInfoFinishE extends RetifitE {
   public BedMessageB mBedBean;

    public GetBedInfoFinishE(String errorMessage) {
        super(errorMessage);
    }

    public GetBedInfoFinishE(BedMessageB mBedBean) {
        this.mBedBean = mBedBean;
    }

    public BedMessageB getmBedBean() {
        return mBedBean;
    }

    public void setmBedBean(BedMessageB mBedBean) {
        this.mBedBean = mBedBean;
    }
}
