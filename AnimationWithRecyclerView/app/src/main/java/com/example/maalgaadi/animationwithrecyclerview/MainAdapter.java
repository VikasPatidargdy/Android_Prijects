package com.example.maalgaadi.animationwithrecyclerview;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by maalgaadi on 28/6/17.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {


    Context context;

    List<String> list;
    CardView swipeLayout, regularLayout;
    TextView textViewUndo;
    int lastPosition = -1;


    public MainAdapter(List<String> list1, Context context1) {

        this.context = context1;
        this.list = list1;
    }

    @Override
    public MainAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_main, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainAdapter.MyViewHolder holder, int position) {
        holder.textView.setText(list.get(position));
        this.swipeLayout = holder.swipeLayout;
        this.regularLayout = holder.regularLayout;
        this.textViewUndo = holder.undo;
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.slid_in_right);
        animation.setDuration((position + 1) * 250);
        holder.itemView.startAnimation(animation);
        Log.e("list item", list.get(position));
        //setAnimation(holder.itemView );

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView, undo;
        CardView swipeLayout, regularLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            undo = itemView.findViewById(R.id.text_view_undo);
            textView = itemView.findViewById(R.id.text_view_item);
            regularLayout = itemView.findViewById(R.id.card_view);
            swipeLayout = itemView.findViewById(R.id.card_view_swipe);
            undo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e("undo *******", "undo done");
                }
            });


        }
    }
}

