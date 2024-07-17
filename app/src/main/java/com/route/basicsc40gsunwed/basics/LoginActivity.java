package com.route.basicsc40gsunwed.basics;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.route.basicsc40gsunwed.R;

// MainActivity is A AppCompatActivity
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // Inflation -> XML File
        // R class is a generated class for Android Project resources
    }
}