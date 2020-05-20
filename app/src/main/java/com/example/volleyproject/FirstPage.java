package com.example.volleyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstPage extends AppCompatActivity {
    private Button button;
    private Button button2;
    private Button button5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); //隱藏title
        setContentView(R.layout.activity_first_page);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openRecordActivity();
            }
        });
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openView();
            }
        });
        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openPaidFeatures();
            }
        });


    }

    public void openRecordActivity(){
        Intent intent = new Intent(this, RecordForm.class);
        startActivity(intent);
    }
    public void openView(){
        Intent intent = new Intent(this, view.class);
        startActivity(intent);
    }

    public void openPaidFeatures(){
        Intent intent = new Intent(this, PaidFeatures.class);
        startActivity(intent);
    }
}
