package com.demo.zxyl.patientlogindemo.events;


import com.demo.zxyl.patientlogindemo.beans.PatientB;

/**
 * Created by GuanYangyi on 2016/6/6.
 */
public class PaientInfoEvent {

    public PatientB getBean() {
        return bean;
    }

    public void setBean(PatientB bean) {
        this.bean = bean;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    private PatientB bean;
    private String errorMsg;

    public PaientInfoEvent(PatientB bean) {
        this.bean = bean;
    }

    public PaientInfoEvent(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
