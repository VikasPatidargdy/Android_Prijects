package com.example.admin.broadcastrec;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {
    String message;
    static GetString listener;

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving

        message = intent.getStringExtra("key1");
        if (listener != null) {
            listener.onMessageReceived(message);
        }
        //throw new UnsupportedOperationException("Not yet implemented");
    }

    interface GetString {
        void onMessageReceived(String s);
    }

    public static void setListener(GetString listener1) {
        listener = listener1;
    }
}
