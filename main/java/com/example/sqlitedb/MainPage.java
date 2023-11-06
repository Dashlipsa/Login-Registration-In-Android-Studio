package com.example.sqlitedb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
    }

    public void registerActivity(View view) {
        Intent intent=new Intent(MainPage.this,MainActivity.class);
        startActivity(intent);
    }

    public void loginActivity(View view) {
        Intent intent=new Intent(MainPage.this,Login.class);
        startActivity(intent);
    }
}