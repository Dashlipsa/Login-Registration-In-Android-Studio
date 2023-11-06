package com.example.sqlitedb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText l_email,l_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        l_email=(EditText) findViewById(R.id.l_Email);
        l_pass=(EditText) findViewById(R.id.l_password);
    }

    public void loginUser(View view) {
        String email_l=l_email.getText().toString();
        String pass_l=l_pass.getText().toString();
        DbHelper dbHelper=new DbHelper(this);
        boolean logedin=dbHelper.login(email_l,pass_l);
        if (logedin){
            Intent intent=new Intent(Login.this,Profile.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this,"Email id and password didnot matched",Toast.LENGTH_SHORT).show();
        }
    }
}