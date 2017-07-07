package com.android.tutorial.service_tutorial.foreground;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.tutorial.service_tutorial.R;

public class ForegroundServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foreground_service);
        createIntent();
    }

    public void createIntent(){
        Intent intent = new Intent(this, ForegroundService.class);
        startService(intent);
    }
}
