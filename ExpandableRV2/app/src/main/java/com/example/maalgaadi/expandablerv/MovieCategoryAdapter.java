package com.example.maalgaadi.expandablerv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.List;

/**
 * Created by maalgaadi on 29/6/17.
 */

public class MovieCategoryAdapter extends ExpandableRecyclerAdapter<MovieCategoryViewHolder, MoviesViewHolder> {
    private LayoutInflater mInflator;
    Context context;

    public MovieCategoryAdapter(Context context, List<? extends ParentListItem> parentItemList) {
        super(parentItemList);
        this.context = context;
        mInflator = LayoutInflater.from(context);
    }

    @Override
    public MovieCategoryViewHolder onCreateParentViewHolder(ViewGroup parentViewGroup) {
        View movieCategoryView = mInflator.inflate(R.layout.movie_category_view, parentViewGroup, false);
        return new MovieCategoryViewHolder(movieCategoryView);
    }

    @Override
    public MoviesViewHolder onCreateChildViewHolder(ViewGroup childViewGroup) {
        View moviesView = mInflator.inflate(R.layout.movies_view, childViewGroup, false);
        return new MoviesViewHolder(moviesView);
    }

    @Override
    public void onBindParentViewHolder(MovieCategoryViewHolder movieCategoryViewHolder, int position, ParentListItem parentListItem) {
        MovieCategory movieCategory = (MovieCategory) parentListItem;

        Animation animation = AnimationUtils.loadAnimation(context, R.anim.slid_in_left);
        animation.setDuration((position + 1) * 250);
        movieCategoryViewHolder.itemView.startAnimation(animation);

        movieCategoryViewHolder.bind(movieCategory);
    }

    @Override
    public void onBindChildViewHolder(MoviesViewHolder moviesViewHolder, int position, Object childListItem) {
        Movies movies = (Movies) childListItem;

        Animation animation = AnimationUtils.loadAnimation(context, R.anim.slid_in_right);
        animation.setDuration((position + 1) * 250);
        moviesViewHolder.itemView.startAnimation(animation);

        moviesViewHolder.bind(movies);
    }
}
