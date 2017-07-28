package com.example.maalgaadi.animationwithrecyclerview;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  private   boolean flagR = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String semList[] = {"1st", "2nd", "3rd", "4th", "5th", "6th"};
        String subList[] = {"OOPC", "ADA", "CSO", "DC", "ADC", "DCS"};
        Log.e("Main Activity", "before Adapter call");
        final List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(subList));
        final MainAdapter mainAdapter = new MainAdapter(list, this);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(mainAdapter);
        mainAdapter.notifyDataSetChanged();
        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                final int position = viewHolder.getAdapterPosition();
              // mainAdapter.bindViewHolder(,position);

                Log.e("Position" , " +++++++++++"+position);


                mainAdapter.regularLayout.setVisibility(View.GONE);
                mainAdapter.swipeLayout.setVisibility(View.VISIBLE);
                mainAdapter.textViewUndo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mainAdapter.regularLayout.setVisibility(View.VISIBLE);
                        mainAdapter.swipeLayout.setVisibility(View.GONE);
                        flagR = false;
                    }
                });

                if (flagR) {
                    list.remove(position);
                }
                mainAdapter.notifyItemRemoved(position);
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        Log.e("Main Activity", "After Adapter call");
    }
}
