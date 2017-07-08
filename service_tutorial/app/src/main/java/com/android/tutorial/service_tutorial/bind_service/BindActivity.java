package com.android.tutorial.service_tutorial.bind_service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.tutorial.service_tutorial.R;
import com.android.tutorial.service_tutorial.start_service.StartServiceActivity;

public class BindActivity extends Activity implements ServiceConnection, BindService.CallBack {

    private BindService myService;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_service);
        button = findViewById(R.id.button);
        button.setEnabled(false);

        Log.v(this.getClass().getName(), " ======================= OnCreate =================== ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent bindIntent = new Intent(this, BindService.class);
        bindService(bindIntent, this, BIND_AUTO_CREATE);
        Log.v(this.getClass().getName(), " ======================= OnResume =================== ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(myService != null){
            unbindService(this);
        }
        Log.v(this.getClass().getName(), " ======================= OnPause =================== ");
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        myService = ((BindService.LocalBinder)iBinder).getService();
        myService.setActivity(this);
        button.setEnabled(true);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myService.executeTask();
            }
        });
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        myService = null;
    }

    @Override
    public void taskComplete(int value) {
        TextView textView = findViewById(R.id.textView);
        textView.setText( ((Integer)value).toString() );
    }

}
