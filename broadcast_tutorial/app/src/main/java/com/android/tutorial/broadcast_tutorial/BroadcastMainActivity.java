package com.android.tutorial.broadcast_tutorial;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BroadcastMainActivity extends AppCompatActivity {

    BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_LOW);
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        intentFilter.addAction(Intent.ACTION_BATTERY_OKAY);
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (action.equals(Intent.ACTION_BATTERY_LOW)){
                    TextView view1 = (TextView) findViewById(R.id.broadcast_view1);
                    view1.setText("Battery is low");

                }else if(action.equals(Intent.ACTION_BATTERY_CHANGED)){
                    TextView view2 = (TextView) findViewById(R.id.broadcast_view2);
                    view2.setText("Battery has changed");

                }else if(action.equals(Intent.ACTION_BATTERY_OKAY)){
                    TextView view3 = (TextView) findViewById(R.id.broadcast_view3);
                    view3.setText("Battery is okay");

                }else if(action.equals(Intent.ACTION_POWER_CONNECTED)){
                    TextView view4 = (TextView) findViewById(R.id.broadcast_view4);
                    view4.setText("Power has connected");

                }else if(action.equals(Intent.ACTION_POWER_DISCONNECTED)){
                    TextView view5 = (TextView) findViewById(R.id.broadcast_view5);
                    view5.setText("Power has Disconnected");
                }
            }
        };
        registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
    }
}
