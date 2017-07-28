package com.example.maalgaadi.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by maalgaadi on 20/6/17.
 */

public class LoginFragment extends Fragment {

    public static LoginFragment getLoginFragment() {
        LoginFragment loginFragment = new LoginFragment();
        return loginFragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        return v;
    }
}
