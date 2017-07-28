package com.example.maalgaadi.retrofitget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.maalgaadi.retrofitget.data.model.Example;
import com.example.maalgaadi.retrofitget.data.remote.APIServices;
import com.example.maalgaadi.retrofitget.data.remote.APIs;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    APIServices apiServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text_view_result);
        apiServices = APIs.getAPIServices();
        apiServices.getCustomerInfo("9893801881", "123456").enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                textView.setText("******RESPONSE ******* *********   "+response.body().getSuccess().getCustomer().getCustEmail());
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                textView.setText("RESPONSE FAILURE");

            }
        });


    }
}
