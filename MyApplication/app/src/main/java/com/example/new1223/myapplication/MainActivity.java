package com.example.new1223.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.GetChars;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    DataBaseHelper dataBaseHelper;
    EditText editTextID, editTextName, editTextBranch;
    Button buttonInsertDetails, buttonShowDetails, buttonUpdateDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextID = (EditText) findViewById(R.id.edit_text_id);
        editTextName = (EditText) findViewById(R.id.edit_text_name);
        editTextBranch = (EditText) findViewById(R.id.edit_text_branch);
        buttonInsertDetails = (Button) findViewById(R.id.button_insert_details);
        buttonShowDetails = (Button) findViewById(R.id.button_show_details);
        buttonUpdateDetails = (Button) findViewById(R.id.button_update_details);
        dataBaseHelper = new DataBaseHelper(this);


        buttonInsertDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt((editTextID.getText()).toString());
                if (id >= 0) {
                    dataBaseHelper.insertStudentDetail(id, editTextName.getText().toString(), editTextBranch.getText().toString());
                    dataBaseHelper.insertStudentDetail1(id, editTextName.getText().toString(), editTextBranch.getText().toString());
                    Toast toast = Toast.makeText(getApplicationContext(), "DATA INSERTED", LENGTH_SHORT);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Please enter currect ID", LENGTH_SHORT);
                    toast.show();
                }
            }
        });


        buttonShowDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt((editTextID.getText()).toString());
                if (id >= 0) {
                    Cursor res = dataBaseHelper.getData(getApplicationContext(), id);
                    res.moveToNext();
                    editTextID.setInputType(id);
                    //editTextName.setText(res.getString(res.getColumnIndex()));
                    //editTextBranch.setText(res.getString(2));
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Please enter currect ID", LENGTH_SHORT);
                    toast.show();
                }
            }
        });


        buttonUpdateDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt((editTextID.getText()).toString());
                if (id >= 0) {
                    dataBaseHelper.updateStudentDetails(id, editTextName.getText().toString(), editTextBranch.getText().toString());
                    Toast toast = Toast.makeText(getApplicationContext(), "Information update", LENGTH_SHORT);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Please enter currect ID", LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }




}
