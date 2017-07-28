package com.example.admin.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by admin on 6/7/2017.
 */

public class MyBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(MyBroadcast.class.getName(), "hello " + intent.getStringExtra("msg"));
    }
}
