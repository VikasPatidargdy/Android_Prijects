package com.example.new1223.jsonparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    RequestQueue requestQueue;

    private TextView textViewResponse;

    private String jsonResponse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue = Volley.newRequestQueue(getApplicationContext());

        Button buttonJSONParsing, buttonJSONArrayParsing;

        buttonJSONParsing = (Button) findViewById(R.id.button_json_parsing);
        buttonJSONArrayParsing = (Button) findViewById(R.id.button_json_array_parsing);
        textViewResponse = (TextView) findViewById(R.id.text_view_response);

        buttonJSONParsing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parsingJSON();
            }
        });
        buttonJSONArrayParsing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parsingJSONArray();
            }


        });
    }

    private void parsingJSON() {
        String urlJsonObj = "http://api.androidhive.info/volley/person_object.json";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlJsonObj, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    jsonResponse = "HELLOOOO!\n";
                    jsonResponse += "NAME:--  " + response.getString("name")+"\n";
                    jsonResponse += "EMAIL:--  " + response.getString("email")+"\n";

                    JSONObject phone = response.getJSONObject("phone");

                    jsonResponse += "HOME:--  " + phone.getString("home")+"\n";
                    jsonResponse += "MOBILE:--  " + phone.getString("mobile")+"\n\n";
                    textViewResponse.setText(jsonResponse);
                    Log.e("JSONResponse", jsonResponse);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Exception in JSON Parsing", Toast.LENGTH_SHORT).show();
                    Log.e("ERROR", e.toString());
                }
            }
        },       new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error to get JSON Object", Toast.LENGTH_SHORT).show();

            }
        });

        requestQueue.add(jsonObjectRequest);
    }

    private void parsingJSONArray() {
        String urlJSONArrayObject = "http://api.androidhive.info/volley/person_array.json";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, urlJSONArrayObject, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {
                    jsonResponse = "";
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject person = response.getJSONObject(i);

                        jsonResponse += "Name:- " + person.getString("name")+"\n";
                        jsonResponse += "Email:- " + person.getString("email")+"\n";
                        JSONObject phone =  person.getJSONObject("phone");
                        jsonResponse += "home:- " + phone.getString("home")+"\n";
                        jsonResponse += "mobile:- " + phone.getString("mobile")+"\n\n";
                        Log.e("JSON Response", jsonResponse.toString());
                    }
                    textViewResponse.setText(jsonResponse);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Error in parsing the info from JSON Array", Toast.LENGTH_SHORT).show();
                    Log.e("Exception Array", e.toString());
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error to get JSON Array object", Toast.LENGTH_SHORT).show();

            }
        });
        requestQueue.add(jsonArrayRequest);

    }

}
