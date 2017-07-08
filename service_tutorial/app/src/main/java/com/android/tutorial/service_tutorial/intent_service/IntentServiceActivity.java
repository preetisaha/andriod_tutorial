package com.android.tutorial.service_tutorial.intent_service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.tutorial.service_tutorial.R;
import com.android.tutorial.service_tutorial.parallel_execution.ParallelExecutionActivity;

public class IntentServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);

        Button messageButton = (Button) findViewById(R.id.messageButton);
        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });

        Button textButton = (Button) findViewById(R.id.textButton);
        textButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendText();
            }
        });

    }

    public void sendMessage(){
        Intent intent = new Intent(this, MyIntentService.class);
        intent.setAction(MyIntentService.messageAction);
        startService(intent);
    }

    public void sendText(){
        Intent intentText = new Intent(this, MyIntentService.class);
        intentText.setAction(MyIntentService.textAction);
        startService(intentText);
    }

}
