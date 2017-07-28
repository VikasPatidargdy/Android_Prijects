package com.example.maalgaadi.expandablerv;

import android.view.View;
import android.widget.TextView;

/**
 * Created by maalgaadi on 29/6/17.
 */

public class MoviesViewHolder extends ChildViewHolder {

    private TextView mMoviesTextView;

    public MoviesViewHolder(View itemView) {
        super(itemView);
        mMoviesTextView = (TextView) itemView.findViewById(R.id.tv_movies);
    }

    public void bind(Movies movies) {
        mMoviesTextView.setText(movies.getName());
    }
}
