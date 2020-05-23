package com.example.volleyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Analysis extends AppCompatActivity {
    private Button another;
    private Button first;
    TextView text1 ;
    TextView text2;
    TextView text3 ;
    TextView text4;
    TextView text5 ;
    TextView text6;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);
        getSupportActionBar().hide(); //隱藏title

        text1 = findViewById(R.id.data1);
        text2 = findViewById(R.id.data2);
        text3 = findViewById(R.id.data3);
        text4 = findViewById(R.id.data4);
        text5 = findViewById(R.id.data5);
        text6 = findViewById(R.id.data6);

        Random rand = new Random();
        text1.setText(Math.round(10000*rand.nextFloat())/(float)100+"%");
        text2.setText(Math.round(10000*rand.nextFloat())/(float)100+"%");
        text3.setText(Math.round(10000*rand.nextFloat())/(float)100+"%");
        text4.setText(Math.round(10000*rand.nextFloat())/(float)100+"%");
        text5.setText(Math.round(10000*rand.nextFloat())/(float)100+"%");
        text6.setText(rand.nextInt(9)+ 1+"次");

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