package com.example.volleyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class Bag extends AppCompatActivity {
    private Button button;
    ArrayList name=new ArrayList();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bag);

        button = findViewById(R.id.add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRecordActivity();
            }
        });
    }
    public void openRecordActivity() {
        Intent intent = new Intent(this, AddPlayer.class);
        startActivity(intent);
    }

}

