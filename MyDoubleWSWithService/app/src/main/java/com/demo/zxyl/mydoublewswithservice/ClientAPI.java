package com.demo.zxyl.mydoublewswithservice;


/**
 * Created by TANG on 2016/3/4.
 */
public class ClientAPI {

    //    public static  String BASE_URL="192.168.1.132:8080";
//    public static  String BASE_URL="192.168.1.254:7088/push";
    public static String BASE_URL = "192.168.1.53:8080";
    public static String BASE_HTTP = "http://" + BASE_URL + "/";
    public static String BASE_WS = "ws://" + BASE_URL + "/message/" + MyApplaction.getmPatientId() + "/" + MyApplaction.getmPatientId();

//    public static String WS_SERVICE_BED = "http://" + BASE_URL + "/";
    public static String WS_SERVICE_PATIENT = "http://" + BASE_URL + "/";
    public static String WS_SERVICE_BED ="";
}
