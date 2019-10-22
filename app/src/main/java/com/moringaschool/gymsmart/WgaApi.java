package com.moringaschool.gymsmart;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WgaApi {
    @GET("exercise")
    Call<WgaResponse> getExersices(

    );
}
