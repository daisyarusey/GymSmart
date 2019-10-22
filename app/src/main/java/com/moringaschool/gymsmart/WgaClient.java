package com.moringaschool.gymsmart;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.moringaschool.gymsmart.Constants.WGA_API_KEY;
import static com.moringaschool.gymsmart.Constants.WGA_BASE_URL;

public class WgaClient {
    private static Retrofit retrofit = null;

    public static WgaApi getClient() {

        if (retrofit== null){
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request newRequest = chain.request().newBuilder()
                                    .addHeader("Authorization",WGA_API_KEY)
                                    .build();
                            return chain.proceed(newRequest);

                        }
                    })
                    .build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(WGA_BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(WgaApi.class);
    }
}
