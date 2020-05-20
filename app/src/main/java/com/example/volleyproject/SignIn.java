package com.example.volleyproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignIn extends AppCompatActivity {
    private Button next;
    private Button register;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private String account;
    private String password;
    private TextInputLayout accoutLayout;
    private TextInputLayout passwordLayout;
    private EditText accountEdit;
    private EditText passwordEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().hide(); //隱藏title


        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        if(user != null){
            Intent intent = new Intent();
            intent.setClass(SignIn.this, FirstPage.class);
            startActivity(intent);
            finish();
        }
        else {initView();}



        register = findViewById((R.id.register));
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegister();
            }
        });

    }

    private void initView() {
        mAuth = FirebaseAuth.getInstance();
        accountEdit = (EditText) findViewById(R.id.mail1_edit);
        passwordEdit = (EditText) findViewById(R.id.password1_edit);
        accoutLayout = (TextInputLayout) findViewById(R.id.mail1);
        passwordLayout = (TextInputLayout) findViewById(R.id.password1);
        passwordLayout.setErrorEnabled(true);
        accoutLayout.setErrorEnabled(true);
        next = (Button) findViewById(R.id.next1);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if(TextUtils.isEmpty(account)){
                    accoutLayout.setError(getString(R.string.plz_input_accout));
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    passwordLayout.setError(getString(R.string.plz_input_pw));
                    return;
                }
                Log.e("帳密給我出來", account+"/"+password);
                accoutLayout.setError("");
                passwordLayout.setError("");
                mAuth.signInWithEmailAndPassword(account, password)
                        .addOnCompleteListener(SignIn.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(SignIn.this, R.string.login_success, Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent();
                                    intent.setClass(SignIn.this, FirstPage.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(SignIn.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
    public void openRegister(){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }

}