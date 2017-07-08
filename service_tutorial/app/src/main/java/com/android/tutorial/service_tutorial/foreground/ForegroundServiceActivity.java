package com.android.tutorial.service_tutorial.foreground;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.tutorial.service_tutorial.R;
import com.android.tutorial.service_tutorial.intent_service.IntentServiceActivity;

public class ForegroundServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foreground_service);
        goToForeground();

        Button intentButton = (Button) findViewById(R.id.goToIntent);
        intentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToIntent();
            }
        });
    }

    public void goToForeground(){
        Intent intent = new Intent(this, ForegroundService.class);
        startService(intent);
    }

    public void goToIntent(){
        Intent intent = new Intent(this, IntentServiceActivity.class);
        startActivity(intent);
    }
}
