package com.example.admin.broadcastrec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Receiver extends AppCompatActivity implements MyReceiver.GetString{
    EditText etmsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        etmsg = (EditText) findViewById(R.id.rmessage);
        MyReceiver.setListener(this);

    }

    @Override
    public void onMessageReceived(String s) {
        etmsg.setText(s);
    }
}


//admin.broadcastrec.Receiver