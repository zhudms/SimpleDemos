package com.demo.zxyl.patientlogindemo.events;

import java.io.Serializable;

/**
 * Created by TANG on 2016/5/25.
 */
public class RetifitE implements Serializable {

    public String errorMessage;//失败原因（以此判断是否请求成功）
    public int flag;//请求的成功/失败

    public RetifitE(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public RetifitE() {
    }

    public RetifitE(int flag) {

        this.flag = flag;
    }

    public RetifitE(int flag, String errorMessage) {

        this.errorMessage = errorMessage;
        this.flag = flag;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

}
