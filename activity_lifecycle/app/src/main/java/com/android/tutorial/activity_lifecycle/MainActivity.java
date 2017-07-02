package com.android.tutorial.activity_lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("MainActivity", " ========================= Method - onCreate is running");
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                buttonOnClick();
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("MainActivity", " ========================= Method - onRestart is running");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("MainActivity", " ========================= Method - onStart is running");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("MainActivity", " ========================= Method - onResume is running");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("MainActivity", " ========================= Method - onPause is running");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("MainActivity", " ========================= Method - onStop is running");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("MainActivity", " ========================= Method - onDestroy is running");
    }

    public void buttonOnClick(){
        Intent intent = new Intent(this, NextActivity.class);
        startActivity(intent);
    }
}
