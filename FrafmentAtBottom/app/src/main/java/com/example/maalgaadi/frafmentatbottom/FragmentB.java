package com.example.maalgaadi.frafmentatbottom;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by maalgaadi on 8/7/17.
 */

public class FragmentB extends Fragment implements MyAdapter.GetData {
    Button button;
    CardView frameLayoutBottom;
    TextView textViewItem;


    public FragmentB() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.b_fragmnet, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button = (Button) view.findViewById(R.id.show_c);
        textViewItem = view.findViewById(R.id.text_c);
        frameLayoutBottom = (CardView) view.findViewById(R.id.bottom_frame);


        MyAdapter.setListner(this);
        getActivity().setTitle("Fragment B");
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
      //  fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        fragmentTransaction.replace(R.id.bottom_frame, new FragmentC());
        fragmentTransaction.commit();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frameLayoutBottom.setVisibility(View.VISIBLE);
                Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.slide_left);
                frameLayoutBottom.startAnimation(animation);
            }
        });

    }

    @Override
    public void onDataReceived(String s) {
        textViewItem.setText(s);
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.slide_left_out);
        frameLayoutBottom.startAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                frameLayoutBottom.setVisibility(View.GONE);
            }
        },300);





    }
}
