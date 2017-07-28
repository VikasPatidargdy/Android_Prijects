package com.example.admin.recyclerview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private List<Movie> moviesList;

    public MoviesAdapter(List<Movie> moviesList) {
        this.moviesList = moviesList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item_movie_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movie movie = moviesList.get(position);
        holder.textViewName.setText(movie.getName());
        holder.textViewYear.setText(movie.getYear());

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName, textViewYear;

        public MyViewHolder(View view) {
            super(view);

            textViewName = (TextView) view.findViewById(R.id.clicked_text_name);
            textViewYear = (TextView) view.findViewById(R.id.clicked_text_year);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Movie movie = moviesList.get(getAdapterPosition());
                    Intent intent;
                    intent = new Intent(v.getContext(), DescriptionActivity.class);
                    intent.putExtra("message1", movie);
                    v.getContext().startActivity(intent);

                }
            });
        }
    }
}
