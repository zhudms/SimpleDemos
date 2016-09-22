package com.demo.zxyl.patientlogindemo.beans;

import java.io.Serializable;

/**
 * Created by TANG on 2016/3/4.-copy
 */
public class PatientB implements Serializable {

    public static final String PATIENT_BOY = "1";
    public static final String PATIENT_GIRL = "2";
    public static final String PATIENT_TENDED = "1";
    public static final String PATIENT_ADD = "2";
    public static final String PATIENT_UNADD = "3";

    public static final int PATIENT_ONSELECT = 1;
    public static final int PATIENT_UNSELECT = 0;

    public static final String TEND_ONE = "Y";
    public static final String TEND_TWO = "E";
    public static final String TEND_THREE = "S";
    public static final String TEND_NONE = "N";
    public static final String TEND_SPE = "T";


    public String getNURSE_LEVLE() {
        return NURSE_LEVLE;
    }

    public void setNURSE_LEVLE(String NURSE_LEVLE) {
        this.NURSE_LEVLE = NURSE_LEVLE;
    }


    private boolean isNewMessage;
//    private int addState = TendBedTextView.STATE_NORMAL;


    private int onSelect = PATIENT_UNSELECT;
    public String EHRID;
    public String WARD_CODE;

    public String ROOM_NO;
    public String LASTUPDDATE;
    public String BED_TYPE;
    public String SEX;
    public String BIRTHDAY;
    public String ORG_CODE;
    public String USERNAME;
    public String UPDATE_TIME;
    public String MASTER_DOCTOR_NAME;
    public String THRESHOLD;
    public String IN_SNO;
    public int AGE;
    public String DEPOSIT;
    public String USER_ID;
    public String DEVICE_NO;
    public String WARD_NAME;
    public String BED_USED;
    public String BED_SNO;
    public String PATIENTID;
    public String DEPT_CODE;
    public int MPIID;
    public String DEPT_NAME;
    public String IN_DATE;
    public String BED_NO;
    public String NAME;
    public String NURSE_LEVLE;
    public int NEW_MESSAGES_COUNT;


    public int getOnSelect() {
        return onSelect;
    }

    public void setOnSelect(int onSelect) {
        this.onSelect = onSelect;
    }
//    public int getAddState() {
//        return addState;
//    }
//
//    public void setAddState(int addState) {
//        this.addState = addState;
//    }

    public static String getPatientTended() {
        return PATIENT_TENDED;
    }

    public static String getPatientAdd() {
        return PATIENT_ADD;
    }

    public static String getPatientUnadd() {
        return PATIENT_UNADD;
    }


    public boolean isNewMessage() {
        return isNewMessage;
//        return true;
    }

    public void setIsNewMessage(boolean isNewMessage) {
        this.isNewMessage = isNewMessage;
    }


    public String getWARD_CODE() {
        return WARD_CODE;
    }

    public void setWARD_CODE(String WARD_CODE) {
        this.WARD_CODE = WARD_CODE;
    }


    public String getROOM_NO() {
        return ROOM_NO;
    }

    public void setROOM_NO(String ROOM_NO) {
        this.ROOM_NO = ROOM_NO;
    }

    public String getLASTUPDDATE() {
        return LASTUPDDATE;
    }

    public void setLASTUPDDATE(String LASTUPDDATE) {
        this.LASTUPDDATE = LASTUPDDATE;
    }

    public String getBED_TYPE() {
        return BED_TYPE;
    }

    public void setBED_TYPE(String BED_TYPE) {
        this.BED_TYPE = BED_TYPE;
    }

    public String getSEX() {
        return SEX;
    }

    public void setSEX(String SEX) {
        this.SEX = SEX;
    }

    public String getBIRTHDAY() {
        return BIRTHDAY;
    }

    public void setBIRTHDAY(String BIRTHDAY) {
        this.BIRTHDAY = BIRTHDAY;
    }

    public String getORG_CODE() {
        return ORG_CODE;
    }

    public void setORG_CODE(String ORG_CODE) {
        this.ORG_CODE = ORG_CODE;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getUPDATE_TIME() {
        return UPDATE_TIME;
    }

    public void setUPDATE_TIME(String UPDATE_TIME) {
        this.UPDATE_TIME = UPDATE_TIME;
    }

    public String getMASTER_DOCTOR_NAME() {
        return MASTER_DOCTOR_NAME;
    }

    public void setMASTER_DOCTOR_NAME(String MASTER_DOCTOR_NAME) {
        this.MASTER_DOCTOR_NAME = MASTER_DOCTOR_NAME;
    }

    public String getTHRESHOLD() {
        return THRESHOLD;
    }

    public void setTHRESHOLD(String THRESHOLD) {
        this.THRESHOLD = THRESHOLD;
    }

    public String getIN_SNO() {
        return IN_SNO;
    }

    public void setIN_SNO(String IN_SNO) {
        this.IN_SNO = IN_SNO;
    }


    public String getDEPOSIT() {
        return DEPOSIT;
    }

    public void setDEPOSIT(String DEPOSIT) {
        this.DEPOSIT = DEPOSIT;
    }

    public String getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getDEVICE_NO() {
        return DEVICE_NO;
    }

    public void setDEVICE_NO(String DEVICE_NO) {
        this.DEVICE_NO = DEVICE_NO;
    }

    public String getWARD_NAME() {
        return WARD_NAME;
    }

    public void setWARD_NAME(String WARD_NAME) {
        this.WARD_NAME = WARD_NAME;
    }

    public String getBED_USED() {
        return BED_USED;
    }

    public void setBED_USED(String BED_USED) {
        this.BED_USED = BED_USED;
    }

    public String getBED_SNO() {
        return BED_SNO;
    }

    public void setBED_SNO(String BED_SNO) {
        this.BED_SNO = BED_SNO;
    }

    public String getPATIENTID() {
        return PATIENTID;
    }

    public void setPATIENTID(String PATIENTID) {
        this.PATIENTID = PATIENTID;
    }

    public String getDEPT_CODE() {
        return DEPT_CODE;
    }

    public void setDEPT_CODE(String DEPT_CODE) {
        this.DEPT_CODE = DEPT_CODE;
    }

    public String getEHRID() {
        return EHRID;
    }

    public void setEHRID(String EHRID) {
        this.EHRID = EHRID;
    }



    public int getAGE() {
        return AGE;
    }

    public void setAGE(int AGE) {
        this.AGE = AGE;
    }

    public int getMPIID() {
        return MPIID;
    }

    public void setMPIID(int MPIID) {
        this.MPIID = MPIID;
    }

    public String getDEPT_NAME() {
        return DEPT_NAME;
    }

    public void setDEPT_NAME(String DEPT_NAME) {
        this.DEPT_NAME = DEPT_NAME;
    }

    public String getIN_DATE() {
        return IN_DATE;
    }

    public void setIN_DATE(String IN_DATE) {
        this.IN_DATE = IN_DATE;
    }

    public String getBED_NO() {
        return BED_NO;
    }

    public void setBED_NO(String BED_NO) {
        this.BED_NO = BED_NO;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public int getNEW_MESSAGES_COUNT() {
        return NEW_MESSAGES_COUNT;
    }

    public void setNEW_MESSAGES_COUNT(int NEW_MESSAGES_COUNT) {
        this.NEW_MESSAGES_COUNT = NEW_MESSAGES_COUNT;
    }



    public String toString() {
        return "ExampleBean [EHRID = " + EHRID + ", WARD_CODE = " + WARD_CODE +  ", ROOM_NO = " + ROOM_NO + ", LASTUPDDATE = " + LASTUPDDATE +
                ", BED_TYPE = " + BED_TYPE + ", SEX = " + SEX + ", BIRTHDAY = " + BIRTHDAY +
                ", ORG_CODE = " + ORG_CODE + ", USERNAME = " + USERNAME + ", UPDATE_TIME = " +
                UPDATE_TIME + ", MASTER_DOCTOR_NAME = " + MASTER_DOCTOR_NAME + ", THRESHOLD = " +
                THRESHOLD + ", IN_SNO = " + IN_SNO + ", AGE = " + AGE + ", DEPOSIT = " + DEPOSIT +
                ", USER_ID = " + USER_ID + ", DEVICE_NO = " + DEVICE_NO + ", WARD_NAME = "
                + WARD_NAME + ", BED_USED = " + BED_USED + ", BED_SNO = " + BED_SNO + ", PATIENTID = "
                + PATIENTID + ", DEPT_CODE = " + DEPT_CODE + ", MPIID = " + MPIID + ", DEPT_NAME = " +
                DEPT_NAME + ", IN_DATE = " + IN_DATE + ", BED_NO = " + BED_NO + ", NAME = " + NAME + "]";
    }


}
