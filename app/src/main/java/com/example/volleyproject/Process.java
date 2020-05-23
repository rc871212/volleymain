package com.example.volleyproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Process extends AppCompatActivity {
    private Button another;
    private Button first;
    private TextView outputForm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process);
        getSupportActionBar().hide(); //隱藏title

        Bundle bundle = this.getIntent().getExtras();
        String select = bundle.getString("select");

        outputForm = findViewById(R.id.output);
        outputForm.setMovementMethod(ScrollingMovementMethod.getInstance());
        outputForm.append("選手" + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + "動作" + "\t\t\t\t\t\t\t\t\t" + "結果" + "\n");
        String path = Environment.getExternalStorageDirectory().getPath();
        File file = new File(path + "/DCIM/" + select);
        StringBuilder sb = new StringBuilder();
        try {
            FileInputStream fin = new FileInputStream(file);
            byte[] data = new byte[fin.available()];
            while (fin.read(data) != -1) {
                sb.append(new String(data));
            }
            fin.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            JSONArray ja = new JSONArray(sb.toString());
            for (int i = 0; i < ja.length(); i++) {
                JSONObject inf_Array = ja.getJSONObject(i);
                outputForm.append(inf_Array.getString("person") + "\t\t\t\t\t\t\t\t\t");
                outputForm.append(inf_Array.getString("action") + "\t\t\t\t\t\t\t\t\t");
                outputForm.append(inf_Array.getString("point") + "\n");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        another = findViewById(R.id.another);
        another.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openView();
            }
        });
        first = findViewById(R.id.first);
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
