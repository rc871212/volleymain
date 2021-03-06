package com.example.volleyproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Register extends AppCompatActivity {
    private Button create;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private String account;
    private String password;
    private TextInputLayout accoutLayout;
    private TextInputLayout passwordLayout;
    private EditText accountEdit;
    private EditText passwordEdit;
    private FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide(); //隱藏title
        initView();


    }

    private void initView() {
        mAuth = FirebaseAuth.getInstance();
        accountEdit =  findViewById(R.id.mail_edit);
        passwordEdit =  findViewById(R.id.password_edit);
        accoutLayout =  findViewById(R.id.mail);
        passwordLayout =  findViewById(R.id.password);
        passwordLayout.setErrorEnabled(true);
        accoutLayout.setErrorEnabled(true);

        create = findViewById(R.id.next);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if (TextUtils.isEmpty(account)) {
                    accoutLayout.setError(getString(R.string.plz_input_accout));
                    passwordLayout.setError("");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    accoutLayout.setError("");
                    passwordLayout.setError(getString(R.string.plz_input_pw));
                    return;
                }
                accoutLayout.setError("");
                passwordLayout.setError("");
                mAuth.createUserWithEmailAndPassword(account, password)
                        .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Register.this, R.string.register_success, Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent();
                                    intent.setClass(Register.this, FirstPage.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(Register.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}
