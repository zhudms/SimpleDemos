package zxyilian.myexpanabledemo;


import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * 全部Http请求的接口都在这
 * 分不同方法
 * Created by TANG on 2016/3/12.
 */
public interface MyHttp {



    //获取资源详情列表
    @GET("common_getResourceInfos.action")
    Call<ResultBeans<SourceDetailsB>> getSourceDetails(@Query("typeId") String typeID,
                                                       @Query("collectId") String uId);


}
