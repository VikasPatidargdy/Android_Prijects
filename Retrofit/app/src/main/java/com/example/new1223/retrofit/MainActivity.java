package com.example.new1223.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.new1223.retrofit.data.model.Example;
import com.example.new1223.retrofit.data.model.Post;
import com.example.new1223.retrofit.data.remote.APIService;
import com.example.new1223.retrofit.data.remote.ApiUtils;
import com.example.new1223.retrofit.data.remote.CustomerService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView mResponseTv, mResponseTVCustomer;
    private APIService mAPIService;
    private CustomerService mCustomerService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText titleEt = (EditText) findViewById(R.id.et_title);
        final EditText bodyEt = (EditText) findViewById(R.id.et_body);
        Button submitBtn = (Button) findViewById(R.id.btn_submit);
        mResponseTv = (TextView) findViewById(R.id.tv_response);
        mResponseTVCustomer = (TextView) findViewById(R.id.tv_response_customer);

        mAPIService = ApiUtils.getAPIService();
        mCustomerService = ApiUtils.getCustomerService();

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = titleEt.getText().toString().trim();
                String body = bodyEt.getText().toString().trim();
                getCustomerDetails(title, body);
                if (!TextUtils.isEmpty(title) && !TextUtils.isEmpty(body)) {
                    sendPost(title, body);
                }
            }
        });
    }


    public void sendPost(String title, String body) {
        mAPIService.savePost(title, body, 1).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if (response.isSuccessful()) {
                    showResponse(response.body().toString());
                    Log.i("send post's on response", "post submitted to API." + response.body().getTitle());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.e("send post's on response", "Unable to submit post to API.");
            }
        });
    }

    public void getCustomerDetails(String mobile, String password) {
        mCustomerService.getCustomerDetails("9893801881", "123456").enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.e("sggge", "post submitted to API. " + response.body() + " " + response.errorBody());
                if (response.isSuccessful()) {
                    showResponseCustomer(response.body().toString());
                    Log.e("send post's on response", "post submitted to API." + response.body().getSuccess().getCustomer().getTripCode());
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("send post's on response", "Unable to submit post to API." + t.toString());
            }
        });
    }

    public void showResponseCustomer(String response) {
        if (mResponseTVCustomer.getVisibility() == View.GONE) {
            mResponseTVCustomer.setVisibility(View.VISIBLE);
        }
        mResponseTVCustomer.setText(response);
    }

    public void showResponse(String response) {
        if (mResponseTv.getVisibility() == View.GONE) {
            mResponseTv.setVisibility(View.VISIBLE);
        }
        mResponseTv.setText(response);
    }
}

