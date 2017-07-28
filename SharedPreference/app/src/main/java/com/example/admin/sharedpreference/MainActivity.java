package com.example.admin.sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextName;
    EditText editTextID;
    EditText editTextSurname;
    EditText editTextDOB;
    Button buttonStoreData, buttonShowData;
    SharedPreferences mySharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = (EditText) findViewById(R.id.edit_text_name);
        editTextID = (EditText) findViewById(R.id.edit_text_id);
        editTextSurname = (EditText) findViewById(R.id.edit_text_surname);
        editTextDOB = (EditText) findViewById(R.id.edit_text_dob);
        buttonStoreData = (Button) findViewById(R.id.store_data);
        buttonShowData = (Button) findViewById(R.id.show_data);

        mySharedPreferences = getSharedPreferences("MyPreferences", MODE_PRIVATE);
        buttonStoreData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editTextID.getText().toString();
                if (!id.isEmpty()) {

                    SharedPreferences.Editor editor = mySharedPreferences.edit();
                    editor.putString("ID" + id, editTextID.getText().toString());
                    editor.putString("Name" + id, editTextName.getText().toString());
                    editor.putString("Surname" + id, editTextSurname.getText().toString());
                    editor.putString("DOB" + id, editTextDOB.getText().toString());
                    editor.commit();
                    Toast toast = Toast.makeText(getApplicationContext(), "Information Saved ", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Please Enter Id /ID is compalasory", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
        buttonShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editTextID.getText().toString();
                if (!id.isEmpty()) {

                    editTextName.setText(mySharedPreferences.getString("Name" + id, "No Entry Present"));
                    editTextSurname.setText(mySharedPreferences.getString("Surname" + id, "No Entry Present"));
                    editTextDOB.setText(mySharedPreferences.getString("DOB" + id, "No Entry Present"));
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Please Enter Id /ID is compalasory", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });


    }
}
