package com.example.maalgaadi.retrofitget.data.remote;

/**
 * Created by maalgaadi on 24/6/17.
 */

public class APIs {
    public static  final  String BASE_URL = "http://dev.maalgaadi.net/api/customerMobile/";

    public static APIServices getAPIServices()
    {
        return RetrofitBuilder.getRetrofitClient(BASE_URL).create(APIServices.class);

    }

}
