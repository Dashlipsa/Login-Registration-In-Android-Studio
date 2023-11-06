package com.example.sqlitedb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText PersonName,EmailAddress,Password,gender;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PersonName=(EditText) findViewById(R.id.PersonName);
        EmailAddress=(EditText) findViewById(R.id.EmailAddress);
        Password=(EditText) findViewById(R.id.Password);
        gender=(EditText) findViewById(R.id.gender);

        dbHelper=new DbHelper(getApplicationContext());
    }
    public void registerUser(View view){
        String name=PersonName.getText().toString();
        String email=EmailAddress.getText().toString();
        String pswd=Password.getText().toString();
        String gen=gender.getText().toString();

        boolean b=dbHelper.registerUserHelper(name,email,pswd,gen);
        if (b==true){
            Toast.makeText(this, "User Register Successfully", Toast.LENGTH_SHORT).show();
            PersonName.setText("");
            EmailAddress.setText("");
            Password.setText("");
            gender.setText("");
        }else {
            Toast.makeText(this, "User Not Register ", Toast.LENGTH_SHORT).show();
        }

    }
}