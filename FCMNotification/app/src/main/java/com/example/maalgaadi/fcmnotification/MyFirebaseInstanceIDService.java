package com.example.maalgaadi.fcmnotification;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by maalgaadi on 19/6/17.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
public  static  String fcmToken=null;
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
         fcmToken = FirebaseInstanceId.getInstance().getToken();
        Log.e("TOKEN","++++++  "+fcmToken+ "     ++++++++");

    }

}

