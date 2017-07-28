package com.example.new1223.retrofit.data.remote;

import com.example.new1223.retrofit.data.model.Example;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by new1223 on 23/6/17.
 */

public interface CustomerService {
    @POST("/login")
    @FormUrlEncoded
    Call<Example> getCustomerDetails(@Field("customer_phone") String customerPhone, @Field("customer_password") String customerPassword);
}
