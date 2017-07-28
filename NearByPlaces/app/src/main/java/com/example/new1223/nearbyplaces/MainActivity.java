package com.example.new1223.nearbyplaces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button buttonAndroid, buttonWebServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAndroid = (Button)findViewById(R.id.button_android);
        buttonWebServices = (Button) findViewById(R.id.button_web);

        buttonAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(getBaseContext() , AndroMapActivity.class);
                startActivity(intent);
            }
        });


        buttonWebServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent;
                intent = new Intent(getBaseContext() , MapActivity.class);
                startActivity(intent);

            }
        });
    }
}
