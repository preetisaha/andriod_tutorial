package com.android.tutorial.layout_tutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RelativeLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);

        Button button = (Button) findViewById(R.id.relativeButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToListView();
            }
        });
    }

    public void goToListView(){
        Intent intent = new Intent(this, ListViewActivity.class);
        startActivity(intent);
    }
}
