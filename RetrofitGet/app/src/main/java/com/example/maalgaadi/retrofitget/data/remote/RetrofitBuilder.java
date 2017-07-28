package com.example.maalgaadi.retrofitget.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by maalgaadi on 24/6/17.
 */


public class RetrofitBuilder {

    public static Retrofit retrofit = null;

    public static Retrofit getRetrofitClient(String baseUrl) {
        if(retrofit == null)
        retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }

}
