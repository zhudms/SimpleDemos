package com.demo.zxyl.patientlogindemo.beans;

/**
 * Created by TANG on 2016/4/25.
 */
public class ResultB<T> extends RetrofitB {

   public T INFO;

   public T getINFO() {
      return INFO;
   }

   public void setINFO(T INFO) {
      this.INFO = INFO;
   }
}
