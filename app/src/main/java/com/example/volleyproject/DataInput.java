package com.example.volleyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import static android.widget.Toast.makeText;

public class DataInput extends AppCompatActivity {
    private TextInputLayout textInputDate;
    private TextInputLayout textInputRival;
    private TextInputLayout textInputSet;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_input);
        getSupportActionBar().hide(); //隱藏title

        button = findViewById(R.id.next);
        textInputDate = findViewById(R.id.text_input_date);
        textInputRival = findViewById(R.id.text_input_rival);
        textInputSet = findViewById(R.id.text_input_set);
    }

    private boolean validateDate() {
        String dateInput = textInputDate.getEditText().getText().toString().trim();

        if (dateInput.isEmpty()) {
            textInputDate.setError("不能空白");
            return  false;
        }
        else {
            textInputDate.setError(null);
            return true;
        }
    }

    private boolean validateRival() {
        String rivalInput = textInputRival.getEditText().getText().toString().trim();

        if (rivalInput.isEmpty()) {
            textInputRival.setError("不能空白");
            return  false;
        }
        else {
            textInputRival.setError(null);
            return true;
        }
    }

    private boolean validateSet() {
        String setInput = textInputSet.getEditText().getText().toString().trim();

        if (setInput.isEmpty()) {
            textInputSet.setError("不能空白");
            return  false;
        }
        else {
            textInputSet.setError(null);
            return true;
        }
    }

    public void confirmInput(View V)
    {
        if(!validateDate() | !validateRival() | !validateSet() ) {
            return;
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openRecordActivity();
            }
        });
    }

    public void openRecordActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
