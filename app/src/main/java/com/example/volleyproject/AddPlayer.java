package com.example.volleyproject;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.*;

import android.os.Bundle;

public class AddPlayer extends AppCompatActivity {
    private Button create;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);
        create=findViewById(R.id.create);




    }
}
