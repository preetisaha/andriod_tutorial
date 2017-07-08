package com.android.tutorial.service_tutorial.parallel_execution;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.tutorial.service_tutorial.R;

public class ParallelExecutionActivity extends AppCompatActivity {

    public static final String userInputKey = "userInputKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parallel_execution);

        Button execution1 = (Button) findViewById(R.id.execution1);

        execution1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText userInput = (EditText) findViewById(R.id.userInput);
                goToExecution(userInput.getText().toString());
            }
        });
    }

    public void goToExecution(String userInput){
        Intent intent = new Intent(this, ParallelExecutionService.class);
        intent.putExtra(userInputKey, userInput);
        startService(intent);
    }
}
