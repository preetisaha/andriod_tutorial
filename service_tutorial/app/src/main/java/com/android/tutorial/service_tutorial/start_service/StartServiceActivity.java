package com.android.tutorial.service_tutorial.start_service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.tutorial.service_tutorial.R;
import com.android.tutorial.service_tutorial.foreground.ForegroundServiceActivity;

public class StartServiceActivity extends AppCompatActivity {

    public static final String input1Key = "input1Key";
    public static final String input2Key = "input2Key";
    BroadcastReceiver broadcastReceiver;

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

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(StartService.action);

        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        broadcastReceiver = new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {
                TextView view = (TextView) findViewById(R.id.broadcast_start_service);
                view.setText(((Integer)intent.getIntExtra(StartService.result, -1)).toString());
            }
        };

        localBroadcastManager.registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        localBroadcastManager.unregisterReceiver(broadcastReceiver);
    }
}
