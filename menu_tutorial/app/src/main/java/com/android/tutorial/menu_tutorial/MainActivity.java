package com.android.tutorial.menu_tutorial;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFloatingContext();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.home_menu){
            Log.v("HomeMenu", "======================================= welcome to Home menu =======================================");
            return true;
        }else if(id == R.id.setting_menu){
            Log.v("SettingMenu", "======================================= Welcome to setting menu =======================================");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void getFloatingContext(){
        Intent intent = new Intent(this, ListViewActivity.class);
        startActivity(intent);
    }
}
