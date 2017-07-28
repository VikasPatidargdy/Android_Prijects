package com.example.maalgaadi.expandablerv;

/**
 * Created by maalgaadi on 29/6/17.
 */

public class Movies {
    public Movies(String mName) {
        this.mName = mName;
    }

    private  String mName;

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }
}

