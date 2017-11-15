package com.example.timofey.retrofitsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.instagram.com/")
                .addConverterFactory(GsonConverterFactory.create())
//                .addConverterFactory(new ToStringConverterFactory())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);
        service.listRepos(
                "",
                "",
                "",
                "",
                ""
        ).enqueue(new Callback<AccessToken>() {
            @Override
            public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                response.toString();
            }

            @Override
            public void onFailure(Call<AccessToken> call, Throwable t) {
                call.toString();
            }
        });
    }


    public interface GitHubService {
        @FormUrlEncoded
        @POST("oauth/access_token")
        Call<AccessToken> listRepos(
                @Field("client_id")  String client_id,
                @Field("client_secret")  String client_secret,
                @Field("grant_type")  String grant_type,
                @Field("redirect_uri")  String redirect_uri,
                @Field("code")  String code
        );
    }
}
