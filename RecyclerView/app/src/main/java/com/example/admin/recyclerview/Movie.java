package com.example.admin.recyclerview;

import java.io.Serializable;

/**
 * Created by admin on 6/8/2017.
 */

public class Movie implements Serializable {
    private String name, year;

    public Movie(String name1, String year1) {
        this.name = name1;
        this.year = year1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
