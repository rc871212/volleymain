package com.example.volleyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseForm extends AppCompatActivity {
    private Button analysis;
    private Button process;
    private String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_form);
        getSupportActionBar().hide(); //隱藏title


        Bundle bundle =this.getIntent().getExtras();
        str = bundle.getString("select");
        analysis = findViewById(R.id.analysis);
        analysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openAnalysis();
            }
        });
        process = findViewById(R.id.process);
        process.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openProcess();
            }
        });

    }
    public void openAnalysis(){
        Intent intent = new Intent(this, Analysis.class);
        startActivity(intent);
    }
    public void openProcess(){
        Intent intent = new Intent(this, Process.class);
        Bundle bundle = new Bundle();
        bundle.putString("select", str);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
