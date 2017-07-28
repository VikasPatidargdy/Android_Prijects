package com.example.admin.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {
    TextView textViewName, textViewYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discription);
        Intent intent = getIntent();
        Movie movie = (Movie) intent.getSerializableExtra("message1");
        textViewName = (TextView) findViewById(R.id.text_dis_name);
        textViewYear = (TextView) findViewById(R.id.text_dis_year);
        textViewName.setText(movie.getName());
        textViewYear.setText(movie.getYear());


    }
}
