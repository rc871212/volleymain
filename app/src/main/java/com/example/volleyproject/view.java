package com.example.volleyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.io.File;

public class view extends AppCompatActivity {
    private Button button;
    private String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        getSupportActionBar().hide(); //隱藏title

        File set = new File(Environment.getExternalStorageDirectory(), "DCIM");
        String[] listFiles = set.list();
        for(int i = 0; i < listFiles.length; i++) {
            listFiles[i] = getFileName((listFiles[i]));
        }
        final Spinner spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> setList = new ArrayAdapter<>(view.this,android.R.layout.simple_spinner_dropdown_item,listFiles);
        setList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(setList);
        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str = parent.getSelectedItem().toString();
                str+=".json";
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        button = findViewById(R.id.next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openViewForm();
            }
        });
    }

    public void openViewForm(){
        Intent intent = new Intent(this,  ChooseForm.class);
        Bundle bundle = new Bundle();
        bundle.putString("select", str);
        intent.putExtras(bundle);

        startActivity(intent);
    }

    public static String getFileName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot >-1) && (dot < (filename.length()))) {
                return filename.substring(0, dot);
            }
        }
        return filename;
    }
}
