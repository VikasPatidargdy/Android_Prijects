package com.example.maalgaadi.expandablerv;

import java.util.List;

/**
 * Created by maalgaadi on 29/6/17.
 */

class MovieCategory implements ParentListItem
{ private String mName;
    private List<Movies> mMovies;

    public MovieCategory(String name, List<Movies> movies) {
        mName = name;
        mMovies = movies;
    }

    public String getName() {
        return mName;
    }

    @Override
    public List<?> getChildItemList() {
        return mMovies;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }
}
