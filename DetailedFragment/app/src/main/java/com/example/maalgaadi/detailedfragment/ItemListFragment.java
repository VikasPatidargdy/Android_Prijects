package com.example.maalgaadi.detailedfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by maalgaadi on 22/6/17.
 */

public class ItemListFragment extends android.support.v4.app.ListFragment /*implements AdapterView.OnItemSelectedListener*/ {
    String str[];
    FragmentManager fragmentManager;
    TextView textViewDetail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        str = new String[]{"vikas", "Deepa", "Sanjay", "Ankur", "Rahul", "Jyoti"};

        List<String> stringList = new ArrayList<String>(Arrays.asList(str));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, stringList);

        setListAdapter(arrayAdapter);

        textViewDetail = view.findViewById(R.id.text_view_detail);
        fragmentManager = getFragmentManager();



        return view;


    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

         DetailFragment detailFragment = new DetailFragment();
         DetailFragment detailFragment1 = new DetailFragment();
        fragmentManager.popBackStack();
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.portrait_mode , detailFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.detail_frame_land,detailFragment1);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        detailFragment.setData(str[position]);
        detailFragment1.setData(str[position]);

    }

}
