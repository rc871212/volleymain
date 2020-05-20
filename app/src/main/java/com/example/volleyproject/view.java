package com.example.volleyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import android.os.Bundle;

public class view extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        getSupportActionBar().hide(); //隱藏title

        button = findViewById(R.id.next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openViewForm();
            }
        });
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        String[] set = {"資工","社福","中訊","機械"};
        ArrayAdapter<String> setList = new ArrayAdapter<>(view.this,android.R.layout.simple_spinner_dropdown_item,set);
        spinner.setAdapter(setList);
    }

    public void openViewForm(){
        Intent intent = new Intent(this, ChooseForm.class);
        startActivity(intent);
    }
}
