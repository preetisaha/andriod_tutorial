package com.android.tutorial.service_tutorial;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.tutorial.service_tutorial.R;
import com.android.tutorial.service_tutorial.bind_service.BindActivity;
import com.android.tutorial.service_tutorial.foreground.ForegroundServiceActivity;
import com.android.tutorial.service_tutorial.intent_service.IntentServiceActivity;
import com.android.tutorial.service_tutorial.parallel_execution.ParallelExecutionActivity;
import com.android.tutorial.service_tutorial.start_service.StartServiceActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bindServiceButton = (Button)findViewById(R.id.bind_service_button);
        bindServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BindActivity.class);
                startActivity(intent);
            }
        });

        Button startServiceButton = (Button)findViewById(R.id.start_service_button);
        startServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StartServiceActivity.class);
                startActivity(intent);
            }
        });

        Button foregroundServiceButton = (Button)findViewById(R.id.foreground_service_button);
        foregroundServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ForegroundServiceActivity.class);
                startActivity(intent);
            }
        });

        Button intentServiceButton = (Button)findViewById(R.id.intent_service_button);
        intentServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, IntentServiceActivity.class);
                startActivity(intent);
            }
        });

        Button parallelServiceButton = (Button)findViewById(R.id.parallel_service_button);
        parallelServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ParallelExecutionActivity.class);
                startActivity(intent);
            }
        });
    }
}















