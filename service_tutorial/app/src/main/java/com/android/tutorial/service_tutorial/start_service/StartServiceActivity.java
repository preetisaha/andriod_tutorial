package com.android.tutorial.service_tutorial.start_service;

import android.content.Intent;
import android.content.ServiceConnection;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.tutorial.service_tutorial.R;

public class StartServiceActivity extends AppCompatActivity {

    public static final String input1Key = "input1Key";
    public static final String input2Key = "input2Key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_service);
        Button button = (Button) findViewById(R.id.next);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                EditText input = (EditText) findViewById(R.id.input1);
                EditText value = (EditText) findViewById(R.id.input2);
                createIntent(input.getText().toString(), value.getText().toString());
            }
        });
    }

    public void createIntent(String input, String value){
        Intent intent = new Intent(this, StartService.class);
        intent.putExtra(input1Key, (CharSequence) input);
        intent.putExtra(input2Key, (CharSequence) value);
        startService(intent);
    }
}
