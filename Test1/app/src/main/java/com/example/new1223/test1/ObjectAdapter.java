package com.example.new1223.test1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class ObjectAdapter extends RecyclerView.Adapter<ObjectAdapter.ObjectViewHolder> {

    private List<ObjectInfo> objectInfoList;
    Context context1;

    public ObjectAdapter(List<ObjectInfo> ObjectInfoList, Context context) {
        this.objectInfoList = ObjectInfoList;
        context1 = context;
    }


    @Override
    public ObjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item_object_info_list, parent, false);

        return new ObjectViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ObjectViewHolder holder, int position) {
        ObjectInfo objectInfo = objectInfoList.get(position);
        holder.textViewInfo.setText("TRIP ID\t" + objectInfo.getTripID() + "\nVehicle\t" + objectInfo.getVehicle() + "\nDate\t" + objectInfo.getDate() + "\nTotal Charge\t" + objectInfo.getTotalCharge() + "\nVehicle Number\t" + objectInfo.getDriverVehicleNumber());
       // holder.textViewInfo.setText("TRIP ID :" + objectInfo.getTripID());
        Log.e("Object", "TRIP ID : " + objectInfo.getTripID());

    }

    @Override
    public int getItemCount() {
        return objectInfoList.size();
    }

    public class ObjectViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewInfo;

        public ObjectViewHolder(View view) {
            super(view);

            textViewInfo = view.findViewById(R.id.text_view_info);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ObjectInfo objectInfo = objectInfoList.get(getAdapterPosition());
                    Intent intent;
                    intent = new Intent(context1, DetailedActivity.class);
                    intent.putExtra("Description", objectInfo);
                    v.getContext().startActivity(intent);

                }
            });
        }
    }
}