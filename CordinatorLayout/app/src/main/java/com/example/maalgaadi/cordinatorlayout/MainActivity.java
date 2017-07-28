package com.example.maalgaadi.cordinatorlayout;

import android.content.res.Resources;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import static com.example.maalgaadi.cordinatorlayout.R.color.colorAccent;

public class MainActivity extends AppCompatActivity {
CoordinatorLayout coordinatorLayout;
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.mipmap.back_button);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.coordinator_layout);


    }

    public void fabSnakBar(View view) {
        Log.e("FAB on Click", "Ouchhhh Pls Don't touch me");
        final Snackbar snackbar = Snackbar.make(coordinatorLayout,"Oh! Don't click. :)", Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction("Close", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snackbar.dismiss();
            }
        }).show();
    }
}
