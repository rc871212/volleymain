package com.example.volleyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.*;

import android.os.Bundle;

import com.google.android.material.textfield.TextInputLayout;

public class AddPlayer extends AppCompatActivity {
    private TextInputLayout textInputId;
    private TextInputLayout textInputName;
    private int id;
    private Button create;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);
        Button create = findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBag();
            }
        });
        textInputName = findViewById(R.id.textName);
        textInputId = findViewById(R.id.textId);
        create = findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openBag();
            }
        });




    }
    private boolean validateName() {
        String NameInput = textInputName.getEditText().getText().toString().trim();

        if (NameInput.isEmpty()) {
            textInputName.setError("不能空白");
            return  false;
        }
        else {
            textInputName.setError(null);
            return true;
        }
    }

    private boolean validateId() {
        String IDInput = textInputId.getEditText().getText().toString().trim();

        if (IDInput.isEmpty()) {
            textInputId.setError("不能空白");
            return  false;
        }

        else {
            try
            {
                id= Integer.parseInt(textInputId.getEditText().getText().toString().trim());

            }
            catch (NumberFormatException e)
            {
                textInputId.setError("請填數字");
                return  false;
            }

            textInputId.setError(null);
            return true;
        }

    }
    public void openBag() {
        if(!validateName() || !validateId() ) {
            return;
        }
        Intent intent = new Intent(this, AddPlayer.class);
        Bundle bundle = new Bundle();
        bundle.putInt("id",id);
        bundle.putString("Name",textInputName.getEditText().getText().toString().trim());
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
