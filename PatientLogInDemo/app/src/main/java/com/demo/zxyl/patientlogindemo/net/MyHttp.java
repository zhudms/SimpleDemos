package com.demo.zxyl.patientlogindemo.net;


import com.demo.zxyl.patientlogindemo.beans.BedMessageB;
import com.demo.zxyl.patientlogindemo.beans.PatientB;
import com.demo.zxyl.patientlogindemo.beans.ResultB;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by TANG on 2016/5/25.
 */
public interface MyHttp {


    //    获取床位信息
    @GET("patient/patient_getDeviceBedInfo.action")
    Call<ResultB<BedMessageB>> getBedMessage(@Query("macNo") String mac);



    //获取病人的基本信息
    @GET("common_ getPatientInfo.action")
    Call<ResultB<PatientB>> getPaientBasicInfo(@Query("bedSno") String bedSno,
                                               @Query("orgCode")  String orgCode);


}
