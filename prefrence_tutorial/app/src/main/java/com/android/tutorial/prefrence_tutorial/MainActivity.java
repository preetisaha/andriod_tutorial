package com.android.tutorial.prefrence_tutorial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.setting);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        TextView view1 = (TextView) findViewById(R.id.textView);
        TextView view2 = (TextView) findViewById(R.id.textView2);
        TextView view3 = (TextView) findViewById(R.id.textView3);

        view1.setText(((Boolean)preferences.getBoolean("bKey", false)).toString());
        view2.setText(preferences.getString("sKey", "not set"));
        view3.setText(preferences.getString("iKey", "-1"));
    }
}
