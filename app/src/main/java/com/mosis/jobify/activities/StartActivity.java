package com.mosis.jobify.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mosis.jobify.R;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getSupportActionBar().hide();
    }
}
