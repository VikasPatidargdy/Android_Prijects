package com.example.maalgaadi.fragmentorientation;

import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

static RelativeLayout relativeLayoutLand;
    FrameLayout frameLayoutPotr;

    public static FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayoutLand = (RelativeLayout)findViewById(R.id.relative_land);
        frameLayoutPotr = (FrameLayout) findViewById(R.id.fram_potr);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction;
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fram_potr, new Fragment1(), "A");
        fragmentTransaction.commit();

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        Log.e("onconfiguaration change","************* Called ***************");

        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.e("onconfiguaration change","************* Called Portrait ***************");
            frameLayoutPotr.setVisibility(View.VISIBLE);
            relativeLayoutLand.setVisibility(View.GONE);
            FragmentTransaction fragmentTransaction;
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fram_potr, new Fragment1(), "A");
            fragmentTransaction.commit();
        }

        else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.e("onconfiguaration change","************* Called Landscape ***************");
            frameLayoutPotr.setVisibility(View.GONE);
            relativeLayoutLand.setVisibility(View.VISIBLE);
            FragmentTransaction fragmentTransaction;
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame1, new Fragment1(), "A");
            fragmentTransaction.replace(R.id.frame2, new Fragment1(), "B");
            fragmentTransaction.commit();
        }


    }

  /*  public static void loadFragment(Fragment f, String s, int id)
    {
        Log.e("mainactivity   ","loadfragment called clicked*************");
        FragmentTransaction fragmentTransaction1;
        fragmentTransaction1 = fragmentManager.beginTransaction();
        fragmentTransaction1.replace(id, f, s);
        fragmentTransaction1.addToBackStack(s);
        fragmentTransaction1.commit();
        Log.e("MAIN Activity   ","End of LoadFragment*************");
    }*/

}
