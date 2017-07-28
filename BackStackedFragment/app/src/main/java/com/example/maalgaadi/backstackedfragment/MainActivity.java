package com.example.maalgaadi.backstackedfragment;

import android.content.ClipData;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity  {


    public static FragmentManager fragmentManager;
    public FrameLayout frameLayout1,frameLayout2;
    float dx,dy;
    Boolean atTop =false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout1 = (FrameLayout)findViewById(R.id.frame);
        frameLayout2 = (FrameLayout)findViewById(R.id.frame2);
        FragmentTransaction fragmentTransaction;
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();
        frameLayout2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                //event holds our finger point out
                //view will hold our views position
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        dx = view.getX() - motionEvent.getRawX();

                        dy = view.getY() - motionEvent.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if(view.getY()<=frameLayout1.getHeight()){
                            Log.e("LOG", "inside if condition");
                            atTop =true;
                        }
                        if(!atTop) {
                            view.animate().y(motionEvent.getRawY() + dy).setDuration(0).start();
                        }
                        atTop = false;
                        break;
                    default:
                        return false;
                }
                return true;

            }


        });
        fragmentTransaction.replace(R.id.frame, fragment1, "A");
        fragmentTransaction.replace(R.id.frame2, fragment2, "B");
        fragmentTransaction.commit();


    }




    public static void loadFragment(Fragment f, String s)
    {
        Log.e("mainactivity   ","loadfragment called clicked*************");
        FragmentTransaction fragmentTransaction1,fragmentTransaction2;
        fragmentTransaction1 = fragmentManager.beginTransaction();
        fragmentTransaction1.setCustomAnimations(R.anim.slide_up, R.anim.slide_up);
        fragmentTransaction1.replace(R.id.frame, f, s);


        if(f.getClass() == Fragment3.class){
            for(int i = 1; i < fragmentManager.getBackStackEntryCount(); ++i) {
                fragmentManager.popBackStack();
            }
        }
        fragmentTransaction1.addToBackStack(s);
        fragmentTransaction1.commit();
        Log.e("MAIN Activity   ", "End of LoadFragment*************");
    }

    public void fragment_load(View view) {

        frameLayout2.setVisibility(View.GONE);
        FragmentTransaction fragmentTransaction3 = fragmentManager.beginTransaction();
        fragmentTransaction3.setCustomAnimations(R.anim.slide_up, R.anim.slide_up);
        fragmentTransaction3.replace(R.id.frame, new Fragment2(), "F2" );
        fragmentTransaction3.commit();
    }
}

