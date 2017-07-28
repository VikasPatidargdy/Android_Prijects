package com.example.new1223.nearbyplaces;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import java.util.ArrayList;
import java.util.List;

public class AndroMapActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener /*,*//*AdapterView.OnItemSelectedListener,*//* OnMapReadyCallback*/ {
   /* Button buttonSearchAndro;
    SupportMapFragment mapFragment;
    Spinner spinnerTypeAndro;
    RequestQueue requestQueue;
    GoogleMap googleMap;
    String item;*/
    GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_andro_map);

        mGoogleApiClient = new GoogleApiClient
                .Builder(this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .enableAutoManage(this, this)
                .build();

        int PLACE_PICKER_REQUEST = 1;
        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

        try {

            startActivityForResult(builder.build(this), PLACE_PICKER_REQUEST);

        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }


    }





    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(this,"Connection Failed", Toast.LENGTH_SHORT).show();
    }
}






/*
    @Override
    public void onMapReady(GoogleMap googleMap) {

    }*/

   /* @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        item = adapterView.getItemAtPosition(i).toString();
        Log.e("SELECTED ITEM", " ************" + item);
    }*/
/*    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }*/
        /*spinnerTypeAndro = (Spinner) findViewById(R.id.spinner_type_andro);
        buttonSearchAndro = (Button) findViewById(R.id.button_search_andro);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_map_andro);
        mapFragment.getMapAsync(this);

        List<String> categories = new ArrayList<>();
        categories.add("ATM");
        categories.add("bank");
        categories.add("restaurant");
        categories.add("school");
        categories.add("hospital");
        spinnerTypeAndro.setOnItemSelectedListener(this);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerTypeAndro.setAdapter(dataAdapter);


        requestQueue = Volley.newRequestQueue(this, null);
        buttonSearchAndro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                googleMap.clear();
                getNearByData();

            }
        });*/
