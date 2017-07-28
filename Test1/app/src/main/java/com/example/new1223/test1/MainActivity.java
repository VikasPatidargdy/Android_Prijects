package com.example.new1223.test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NetworkCallback {
    List<ObjectInfo> objectInfoList = new ArrayList<>();
    RecyclerView recyclerView;
    ObjectAdapter objectAdapter;
    DBHandler dbHandler;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {

            dbHandler = new DBHandler(MainActivity.this);
            recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
            progressBar = (ProgressBar) findViewById(R.id.progress_bar);

            new NetworkRequest().getList(MainActivity.this, this,progressBar);


            objectAdapter = new ObjectAdapter(objectInfoList, MainActivity.this);
            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            recyclerView.setAdapter(objectAdapter);
        } catch (Exception e) {
            Log.e("ERROR IN Main", e.toString());
        }

    }


    @Override
    public void onListChanged(ArrayList<ObjectInfo> list) {
        if (list != null) {
            objectInfoList.addAll(list);
            objectAdapter.notifyDataSetChanged();
        } else {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }
    }
}
