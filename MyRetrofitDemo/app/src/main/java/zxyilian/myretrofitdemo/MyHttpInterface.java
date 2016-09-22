package zxyilian.myretrofitdemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import zxyilian.myretrofitdemo.model.Repo;

/**
 * Created by TANG on 2016/3/12.
 */
public interface MyHttpInterface {

    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);

}
