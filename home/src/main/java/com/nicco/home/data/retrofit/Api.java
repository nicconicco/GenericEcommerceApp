package com.nicco.home.data.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Api {
    @POST("/homecard/{new}.json")
    Call<HomeCardRequest> setData(@Path("new") String s1, @Body HomeCardRequest user);

    @GET("/homecard/sushil.json")
    Call<HomeCardRequest> getData();

    @PUT("/homecard/{new}.json")
    Call<HomeCardRequest> setDataWithoutRandomness(@Path("new") String s1, @Body HomeCardRequest user);
}