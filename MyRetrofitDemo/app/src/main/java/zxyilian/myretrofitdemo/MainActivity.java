package zxyilian.myretrofitdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;


import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import zxyilian.myretrofitdemo.model.Repo;


public class MainActivity extends FragmentActivity {

    private final String API_URL = "https://api.github.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = restAdapter.create(GitHubService.class);
        Call<Repo> call = (Call<Repo>) service.listRepos("octocat");
        call.enqueue(new Callback<Repo>() {
            @Override
            public void onResponse(Response<Repo> response, Retrofit retrofit) {

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }


    public interface GitHubService {
        @GET("/users/{user}/repos")
        Call<Repo> listRepos(@Query("user") String user);
    }


}
