package com.example.maalgaadi.frafmentatbottom;

import android.content.Context;
import android.graphics.drawable.Icon;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.zip.Inflater;

import static com.example.maalgaadi.frafmentatbottom.R.mipmap.ic_launcher_round;

/**
 * Created by maalgaadi on 8/7/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
    Context context;
    String message;
    static GetData listner;

    public MyAdapter() {
        //this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_my, parent, false);
        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, int position) {

        switch (holder.getAdapterPosition()) {
            case 0:
                holder.textView.setText("Item A");
                break;
            case 1:
                holder.textView.setText("Item B");
                break;
            case 2:
                holder.textView.setText("Item C");
                break;
            case 3:
                holder.textView.setText("Item D");
                break;
            case 4:
                holder.textView.setText("Item E");
                break;
        }

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message = (String) holder.textView.getText();
                if (listner != null) {
                    listner.onDataReceived(message);
                }

            }
        });

    }


    @Override
    public int getItemCount() {
        return 5;
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView textView, textView1;

        public MyHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.recycler_text);

        }

    }

    interface GetData {
        void onDataReceived(String s);

    }
    public static void setListner(GetData listner1) {
        listner = listner1;
    }


}
