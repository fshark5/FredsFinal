package com.example.myapplication;



import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText et = findViewById(R.id.editText1);
        findViewById(R.id.button).setOnClickListener(v -> {
            if(et.getText().toString().trim().length() != 0){
                Intent newIntent = new Intent(getApplicationContext(), RecyclerActivity.class);
                newIntent.putExtra("location",et.getText().toString());
                startActivity(newIntent);
            }
        });
    }}
