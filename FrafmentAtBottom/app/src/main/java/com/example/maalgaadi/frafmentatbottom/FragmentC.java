package com.example.maalgaadi.frafmentatbottom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by maalgaadi on 8/7/17.
 */

public class FragmentC extends Fragment {
    RecyclerView recyclerView;
    MyAdapter myAdapter;

    public FragmentC() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.c_fragmnet, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false);
        myAdapter = new MyAdapter();

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(myAdapter);
        getActivity().setTitle("Fragment C");
    }
}
