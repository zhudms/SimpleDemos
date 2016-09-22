package zxyilian.pulltoreflushdemo;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * 全部Http请求的接口都在这
 * 分不同方法
 * Created by TANG on 2016/3/12.
 */
public interface MyHttp {


    /**
     * 登陆后获取责任患者列表（登录完成之后）
     *
     * @return
     */
    @GET("nurse/nurse_getChargeBed.action")
    Call<ResultBeans<PatientB>> getPatientTend(@Query("nurseId") String nurseId);


}
