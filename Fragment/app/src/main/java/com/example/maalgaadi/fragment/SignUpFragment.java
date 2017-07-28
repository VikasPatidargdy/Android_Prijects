package com.example.maalgaadi.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by maalgaadi on 20/6/17.
 */

public class SignUpFragment extends Fragment {
    
        public static SignUpFragment getSignUpFragment() {
            SignUpFragment signUpFragment = new SignUpFragment();
            return signUpFragment;
        }



        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.fragment_sign_up, container, false);
            return v;
        }
}
