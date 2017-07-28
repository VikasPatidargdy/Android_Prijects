package com.example.maalgaadi.detailedfragment;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout relativeLayoutPort;
    LinearLayout LinearLayoutLand;
    ItemListFragment itemListFragment;
    DetailFragment detailFragment;

    FragmentManager fragmentManager;
    static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayoutPort = (RelativeLayout) findViewById(R.id.portrait_mode);
        relativeLayoutPort.setVisibility(View.VISIBLE);
        LinearLayoutLand = (LinearLayout) findViewById(R.id.landscape_mode);
        LinearLayoutLand.setVisibility(View.GONE);
        itemListFragment = new ItemListFragment();
        detailFragment = new DetailFragment();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction;
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.portrait_mode, itemListFragment);
        fragmentTransaction.addToBackStack("list");
        fragmentTransaction.commit();
        context = getBaseContext();


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            relativeLayoutPort.setVisibility(View.VISIBLE);
            LinearLayoutLand.setVisibility(View.GONE);


        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            relativeLayoutPort.setVisibility(View.GONE);
            LinearLayoutLand.setVisibility(View.VISIBLE);
            FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
            fragmentTransaction1.replace(R.id.list_frame_land,new ItemListFragment());
            //fragmentTransaction.replace(R.id.list_frame_land, itemListFragment);
           /* fragmentTransaction1.replace(R.id.detail_frame_land, new DetailFragment());*/
            fragmentTransaction1.addToBackStack(null);
            fragmentTransaction1.commit();


        }
    }
}
