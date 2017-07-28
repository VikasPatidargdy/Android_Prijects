package com.example.new1223.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by new1223 on 10/6/17.
 */

public class Student implements Parcelable {
    private int id;
    private String name, mobile, address;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.mobile);
        dest.writeString(this.address);
    }

    public Student() {
    }

    protected Student(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.mobile = in.readString();
        this.address = in.readString();
    }

    public static final Parcelable.Creator<Student> CREATOR = new Parcelable.Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}
