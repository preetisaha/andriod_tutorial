package com.android.tutorial.layout_tutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VerticalLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_layout);

        Button button = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRelativeLayout();
            }
        });
    }

    public void goToRelativeLayout(){
        Intent intent = new Intent(this, RelativeLayout.class);
        startActivity(intent);
    }
}
