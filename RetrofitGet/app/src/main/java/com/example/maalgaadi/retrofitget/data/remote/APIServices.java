package com.example.maalgaadi.retrofitget.data.remote;

import com.example.maalgaadi.retrofitget.data.model.Example;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by maalgaadi on 24/6/17.
 */

public interface APIServices {

    @GET("login")
    Call<Example> getCustomerInfo(@Query("customer_phone") String customerPhone, @Query("customer_password") String customerPassword);
}
