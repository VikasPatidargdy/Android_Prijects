package com.example.new1223.volley;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    RequestQueue requestQueue;
    EditText editTextResponse;
    Button buttonGet, buttonPost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonGet = (Button) findViewById(R.id.button_get);
        buttonPost = (Button) findViewById(R.id.button_post);


        buttonGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDataFromInternetByGet(getApplicationContext());
            }
        });



        buttonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDataFromInternetByPost(getApplicationContext());
            }
        });
    }

    private void getDataFromInternetByGet(Context context) {

        editTextResponse = (EditText) findViewById(R.id.edit_text_response);
        String getURL = "https://en.wikipedia.org/wiki/";
        getURL = getURL + editTextResponse.getText().toString();
        requestQueue = Volley.newRequestQueue(context);


        StringRequest stringRequestGet = new StringRequest(StringRequest.Method.GET, getURL,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        Log.e("Response", response);
                        editTextResponse.setText("Response from get method " + response.substring(0, 500));
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                editTextResponse.setText("*******ERROR******");
            }
        });

        requestQueue.add(stringRequestGet);
    }



    private void getDataFromInternetByPost(Context context) {

        requestQueue = Volley.newRequestQueue(context);
        String postURL = "https://en.wikipedia.org/wiki/";
        editTextResponse = (EditText) findViewById(R.id.edit_text_response);
        postURL = postURL + editTextResponse.getText().toString();


        StringRequest stringRequestPost = new StringRequest(StringRequest.Method.POST, postURL,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        Log.e("Response", response);
                        editTextResponse.setText("Response from post method " + response.substring(0, 500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                editTextResponse.setText("*******ERROR******");
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                return map;
            }
        };
        requestQueue.add(stringRequestPost);
    }
}
