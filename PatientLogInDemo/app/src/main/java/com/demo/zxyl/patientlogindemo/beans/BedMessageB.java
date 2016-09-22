package com.demo.zxyl.patientlogindemo.beans;

import java.io.Serializable;

/**
 * Created by TANG on 2016/5/26.
 * Patient
 */
public class BedMessageB extends RetrofitB implements Serializable{

    public String BED_NO;//床位号
    public  String MAC_NO;//mac地址
    public  String IN_SNO;//入院流水号
    public  String BED_SNO;//床号
    public  String WARD_CODE;//病区编码
    public  String ORG_CODE;//机构编码

    public String getLOW_START_TIME() {
        return LOW_START_TIME;
    }

    public void setLOW_START_TIME(String LOW_START_TIME) {
        this.LOW_START_TIME = LOW_START_TIME;
    }

    public String getLOW_END_TIME() {
        return LOW_END_TIME;
    }

    public void setLOW_END_TIME(String LOW_END_TIME) {
        this.LOW_END_TIME = LOW_END_TIME;
    }

    public  String LOW_START_TIME; //开始时间
    public  String LOW_END_TIME; //屏幕恢复时间


    public String getBED_NO() {
        return BED_NO;
    }

    public void setBED_NO(String BED_NO) {
        this.BED_NO = BED_NO;
    }

    public String getBED_SNO() {
        return BED_SNO;
    }

    public void setBED_SNO(String BED_SNO) {
        this.BED_SNO = BED_SNO;
    }

    public String getIN_SNO() {
        return IN_SNO;
    }

    public void setIN_SNO(String IN_SNO) {
        this.IN_SNO = IN_SNO;
    }

    public String getMAC_NO() {
        return MAC_NO;
    }

    public void setMAC_NO(String MAC_NO) {
        this.MAC_NO = MAC_NO;
    }

    public String getORG_CODE() {
        return ORG_CODE;
    }

    public void setORG_CODE(String ORG_CODE) {
        this.ORG_CODE = ORG_CODE;
    }

    public String getWARD_CODE() {
        return WARD_CODE;
    }

    public void setWARD_CODE(String WARD_CODE) {
        this.WARD_CODE = WARD_CODE;
    }

    public BedMessageB(String BED_NO, String BED_SNO, String IN_SNO, String MAC_NO, String ORG_CODE, String WARD_CODE) {
        this.BED_NO = BED_NO;
        this.BED_SNO = BED_SNO;
        this.IN_SNO = IN_SNO;
        this.MAC_NO = MAC_NO;
        this.ORG_CODE = ORG_CODE;
        this.WARD_CODE = WARD_CODE;
    }
}
