package com.example.volleyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignIn extends AppCompatActivity {
    private Button next;
    private Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().hide(); //隱藏title

        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openFirstPage();
            }
        });
        register = findViewById((R.id.register));
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openRegister();
            }
        });
    }

    public void openFirstPage(){
        Intent intent = new Intent(this, FirstPage.class);
        startActivity(intent);
    }

    public void openRegister(){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
}
