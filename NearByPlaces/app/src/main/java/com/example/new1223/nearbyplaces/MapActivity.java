package com.example.new1223.nearbyplaces;

import android.animation.IntEvaluator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MapActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, OnMapReadyCallback, LocationListener {


    GoogleMap googleMap;
    Location currentLocation;
    LatLng latLng;
    FloatingActionButton buttonLocation;
    String locationProvider;
    String item;
    Button searchButton;
    Spinner typeSpinner;
    RequestQueue requestQueue;
    JSONObject jsonObject;
    ValueAnimator vAnimator;
    GroundOverlay groundOverlay1, groundOverlay2, groundOverlay3;
    MarkerOptions markerOptions;
    RadiusAnimation groundAnimation;
    Handler handler;
    SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        searchButton = (Button) findViewById(R.id.button_search);
        typeSpinner = (Spinner) findViewById(R.id.spinner_type);
        buttonLocation = (FloatingActionButton) findViewById(R.id.button_location);
        buttonLocation.setVisibility(View.GONE);


        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_map);
        mapFragment.getMapAsync(this);
        handler = new Handler();

        List<String> categories = new ArrayList<>();
        categories.add("ATM");
        categories.add("bank");
        categories.add("restaurant");
        categories.add("school");
        categories.add("hospital");
        typeSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        typeSpinner.setAdapter(dataAdapter);


        requestQueue = Volley.newRequestQueue(this, null);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                googleMap.clear();
                getNearByData();
            }
        });
    }


    void getNearByData() {
        String s = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + latLng.latitude + "," + latLng.longitude + "&radius=1000&type=" + item + "&key=" + "AIzaSyChGWDNQ54dFDj8fD7eF4U90DFJqL-33jY";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, s, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Log.e("GET NEARBY METHOD", "+++++++++BEFORE PARSING RESPONSE+++++++++++" + response);
                    JSONArray jsonArray = response.getJSONArray("results");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        Log.e("GET NEARBY METHOD", "+++++++++BEFORE PARSING+++++++++++");
                        jsonObject = new JSONObject();
                        jsonObject = jsonArray.getJSONObject(i);
                        jsonObject = jsonObject.getJSONObject("geometry");
                        jsonObject = jsonObject.getJSONObject("location");
                        double lat = jsonObject.optDouble("lat");
                        double lng = jsonObject.optDouble("lng");
                        LatLng mLatLng = new LatLng(lat, lng);
                        Log.e("GET NEARBY METHOD", "+++++++++AFTER PARSING+++++++++++");
                        googleMap.addMarker(new MarkerOptions().position(mLatLng));
                    }


                } catch (JSONException e) {
                    e.printStackTrace();

                    Log.e("GET NEARBY METHOD", "+++++++++EXCEPTION PARSING+++++++++++");

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("GET NEARBY METHOD", "+++++++++ ERROR TO GET JSON OBJECT+++++++++++");

            }
        });

        requestQueue.add(jsonObjectRequest);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        item = adapterView.getItemAtPosition(i).toString();
        Log.e("SELECTED ITEM", " ************" + item);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    @Override
    public void onMapReady(final GoogleMap googleMap) {

        this.googleMap = googleMap;


        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.getUiSettings().setIndoorLevelPickerEnabled(false);
        googleMap.setMyLocationEnabled(false);
        currentLocation = getLocation();

        latLng = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
        buttonLocation.setVisibility(View.VISIBLE);
        buttonLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonLocation.setVisibility(View.GONE);
                googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng), new GoogleMap.CancelableCallback() {
                    @Override
                    public void onFinish() {
                        googleMap.animateCamera(CameraUpdateFactory.zoomTo(16));
                    }

                    @Override
                    public void onCancel() {

                    }
                });


            }
        });

        googleMap.clear();
        if (currentLocation == null) {
            Log.e("onMapReady", "********No current location found***********\n\n");
        }


        groundOverlay1 = googleMap.addGroundOverlay(new GroundOverlayOptions()
                .position(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()), 2000)
                .transparency(0.5f)
                .image(BitmapDescriptorFactory.fromResource(R.drawable.concentric_circle)));
        groundOverlay2 = googleMap.addGroundOverlay(new GroundOverlayOptions()
                .position(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()), 200)
                .transparency(0.8f)
                .image(BitmapDescriptorFactory.fromResource(R.drawable.circle_blue)));
        groundOverlay3 = googleMap.addGroundOverlay(new GroundOverlayOptions()
                .position(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()), 25)
                .transparency(0f)
                .image(BitmapDescriptorFactory.fromResource(R.drawable.vikas_ka_circle)));

        overLay(groundOverlay1);


        CameraPosition googleplex = CameraPosition.builder()
                .target(latLng)
                .zoom(16)
                .bearing(0)
                .tilt(0)
                .build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(googleplex));
        markerOptions = new MarkerOptions();
        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.circle_blue));
        markerOptions.position(latLng);
        // googleMap.addMarker(markerOptions);
        // googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

    }


    Location getLocation() {

        LocationManager locationManager = (LocationManager) getSystemService(this.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        locationProvider = locationManager.getBestProvider(criteria, false);
        currentLocation = locationManager.getLastKnownLocation(locationProvider);
        locationManager.requestLocationUpdates(locationProvider, 15000, 1, this);

        return currentLocation;
    }


    @Override
    public void onLocationChanged(Location location) {
        currentLocation = location;
        LatLng latLng1 = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
        groundOverlay1.setPosition(latLng1);
        groundOverlay2.setPosition(latLng1);
        groundOverlay3.setPosition(latLng1);

        /*handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (groundOverlay1.isVisible()) {
                    groundOverlay1.remove();

                    groundOverlay1 = googleMap.addGroundOverlay(new GroundOverlayOptions()
                            .position(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()), 2000)
                            .transparency(0.5f)
                            .image(BitmapDescriptorFactory.fromResource(R.drawable.concentric_circle)));

                    overLay(groundOverlay1);
                }
            }
        }, 500);*/
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    public void overLay(final GroundOverlay groundOverlay) {
        vAnimator = ValueAnimator.ofInt(0, 201);
        int r = 99999;
        vAnimator.setRepeatCount(r);
        // vAnimator.setIntValues(android.R.anim.fade_in,android.R.anim.fade_in);
        vAnimator.setDuration(2000);
        vAnimator.setEvaluator(new IntEvaluator());
        vAnimator.setInterpolator(new LinearInterpolator());

        vAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer i = (Integer) valueAnimator.getAnimatedValue();
                // Log.e("Animation value " , "   ======== "+i);
                groundOverlay.setDimensions(i);
                int x = i / 20;
                groundOverlay.setTransparency(x * 0.1f);

            }
        });
        vAnimator.start();


    }

}


