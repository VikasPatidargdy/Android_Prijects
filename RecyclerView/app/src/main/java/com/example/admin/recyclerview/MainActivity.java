package com.example.admin.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Movie> movieList = new ArrayList<>();
    RecyclerView recyclerView;
    MoviesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new MoviesAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();
    }

    private void prepareMovieData () {
        Movie movie = new Movie("Mad Max: Fury Road", "2015");
        movieList.add(movie);

        movie = new Movie("Inside Out", "2015");
        movieList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "2015");
        movieList.add(movie);

        movie = new Movie("Shaun the Sheep", "2015");
        movieList.add(movie);

        movie = new Movie("The Martian", "2015");
        movieList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation", "2015");
        movieList.add(movie);

        movie = new Movie("Up" , "2009");
        movieList.add(movie);

        movie = new Movie("Star Trek", "2009");
        movieList.add(movie);

        movie = new Movie("The LEGO Movie", "2014");
        movieList.add(movie);


        mAdapter.notifyDataSetChanged();
    }
}
