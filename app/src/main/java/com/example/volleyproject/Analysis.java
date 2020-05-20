package com.example.volleyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Analysis extends AppCompatActivity {
    private Button another;
    private Button first;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);
        getSupportActionBar().hide(); //隱藏title

        another = findViewById(R.id.another);
        another.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openView();
            }
        });
        first = findViewById(R.id.first);
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openFirstPage();
            }
        });
    }

    public void openView(){
        Intent intent = new Intent(this, view.class);
        startActivity(intent);
    }

    public void openFirstPage(){
        Intent intent = new Intent(this, FirstPage.class);
        startActivity(intent);
    }
}
