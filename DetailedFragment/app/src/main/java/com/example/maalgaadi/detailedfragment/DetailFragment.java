package com.example.maalgaadi.detailedfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static android.R.attr.name;

/**
 * Created by maalgaadi on 22/6/17.
 */

public class DetailFragment extends Fragment {
    String name = "vikas";

    void setData(String str) {
        name = str;

    }

    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        textView = view.findViewById(R.id.text_view_detail);
        textView.setText("");
        textView.setText(name);

        return view;

    }
}
