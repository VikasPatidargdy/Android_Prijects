package com.example.new1223.test1;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by new1223 on 14/6/17.
 */

public class NetworkRequest {

    public void getList(final Context context, final NetworkCallback networkCallback, final ProgressBar progressBar) {

        progressBar.setVisibility(View.VISIBLE);

        String urlJsonObj = "http://dev.maalgaadi.net/api/customerMobile/getCustomerRunningBooking?phone=9893801881&page=1";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlJsonObj, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e("JSONResponse", response.toString());
                progressBar.setVisibility(View.GONE);
                try {
                    ObjectInfo objectInfo;
                    JSONObject tempJSONObject = response.getJSONObject("success");
                    JSONArray tempJSONArray = tempJSONObject.getJSONArray("data");
                    DBHandler dbHandler = new DBHandler(context);
                    ArrayList<ObjectInfo> listOfObjectInfo = new ArrayList<>();

                      for (int i = 0; i < tempJSONArray.length(); i++) {
                        tempJSONObject = tempJSONArray.getJSONObject(i);
                        objectInfo = new ObjectInfo();
                        Log.e("JSON OBJECT", tempJSONObject.toString());

                        objectInfo.setTripID(tempJSONObject.getLong("trip_id"));
                        objectInfo.vehicle = tempJSONObject.getString("vehicle");
                        objectInfo.driver = tempJSONObject.getString("driver");
                        objectInfo.driverNumber = tempJSONObject.getString("driver_number");
                        objectInfo.driverVehicleNumber = tempJSONObject.getString("driver_vehicle_no");
                        objectInfo.pickUp = tempJSONObject.getString("pick_up");
                        objectInfo.drop = tempJSONObject.getString("drop");
                        objectInfo.dropPoints = 0;
                        objectInfo.mgCode = tempJSONObject.getString("mg_code");
                        objectInfo.bokingType = tempJSONObject.optString("booking_type");
                        objectInfo.tripCharge = tempJSONObject.getInt("trip_charge");
                        objectInfo.lowerTripCharge = tempJSONObject.getInt("lower_trip_charge");
                        objectInfo.discountAmount = tempJSONObject.getInt("discount_amount");
                        objectInfo.tripAmount = tempJSONObject.getInt("trip_amount");
                        objectInfo.totalCharge = tempJSONObject.getInt("total_charge");
                        objectInfo.tripDistance = ((float) tempJSONObject.getDouble("trip_distance"));
                        objectInfo.lowerTripDistance = (float) tempJSONObject.getDouble("lower_trip_distance");
                        objectInfo.loadingCharge = tempJSONObject.getInt("loading_charge");
                        objectInfo.unloadingCharge = tempJSONObject.getInt("unloading_charge");
                        objectInfo.dropPointCharge = tempJSONObject.getInt("drop_point_charge");
                        objectInfo.surgeAmount = tempJSONObject.getInt("surge_amount");
                        objectInfo.surgePercentage = tempJSONObject.getInt("surge_percentage");
                        objectInfo.estimatedLowerBill = tempJSONObject.getInt("estimated_lower_bill");
                        objectInfo.estimatedUperBill = tempJSONObject.getInt("estimated_upper_bill");
                        objectInfo.minimumTime = tempJSONObject.getInt("minimum_time");
                        objectInfo.minimumDistance = (float) tempJSONObject.getDouble("minimum_distance");
                        objectInfo.minimumBill = tempJSONObject.getInt("minimum_bill");
                        objectInfo.customerNotes = tempJSONObject.getString("customer_notes");
                        objectInfo.finalBalance = tempJSONObject.getInt("final_balance");
                        objectInfo.amountToBePaid = tempJSONObject.getInt("amount_to_be_paid");
                        objectInfo.date = tempJSONObject.getString("date");
                        objectInfo.status = tempJSONObject.getString("status");
                        // Log.e("Status", objectInfo.status);

                        listOfObjectInfo.add(i, objectInfo);
                        dbHandler.insertInfo(objectInfo);
                          dbHandler.getAllDATA(objectInfo.tripID);
                      }

                    if (listOfObjectInfo.size() > 0) {
                        progressBar.setVisibility(View.GONE);
                        networkCallback.onListChanged(listOfObjectInfo);
                    } else {
                        networkCallback.onListChanged(null);
                    }

                } catch (Exception e) {
                    Toast.makeText(context, "Exception in JSON Parsing", Toast.LENGTH_SHORT).show();
                    Log.e("ERROR", e.toString());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error to get JSON Object", Toast.LENGTH_SHORT).show();

            }
        });


        Singleton.getRequestQueue(context).add(jsonObjectRequest);

    }
}
