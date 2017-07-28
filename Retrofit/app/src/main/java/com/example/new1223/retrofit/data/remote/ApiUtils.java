package com.example.new1223.retrofit.data.remote;
public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://jsonplaceholder.typicode.com/";
    public static final String BASE_URL1 = "http://dev.maalgaadi.net/api/customerMobile/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }

    public static CustomerService getCustomerService() {

        return RetrofitClient.getClient(BASE_URL1).create(CustomerService.class);
    }
}