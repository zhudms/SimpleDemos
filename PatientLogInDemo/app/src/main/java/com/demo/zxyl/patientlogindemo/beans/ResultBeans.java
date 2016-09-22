package com.demo.zxyl.patientlogindemo.beans;

import java.util.ArrayList;

/**
 * Created by TANG on 2016/4/26.
 */
public class ResultBeans<T> extends RetrofitB {
    public ArrayList<T> INFO;

    public ArrayList<T> getINFO() {
        return INFO;
    }

    public void setINFO(ArrayList<T> INFO) {
        this.INFO = INFO;
    }
}
