package com.example.admin.broadcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Sender extends AppCompatActivity {
    EditText etMessage;
    Button send;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender);
        etMessage = (EditText) findViewById(R.id.message);
        send = (Button) findViewById(R.id.sendButton);

        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intentMessage = new Intent("Message_Broadcasting");
                message = etMessage.getText().toString();
                intentMessage.putExtra("key1", message);
                sendBroadcast(intentMessage);
            }
        });
    }
}
