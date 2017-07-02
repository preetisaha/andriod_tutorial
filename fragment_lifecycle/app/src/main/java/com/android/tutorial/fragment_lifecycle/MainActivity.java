package com.android.tutorial.fragment_lifecycle;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button overlap = (Button) findViewById(R.id.overlap);
        Button delete = (Button) findViewById(R.id.delete);
        //delete.setEnabled(false);

        Fragment mainFragment = new MainFragment();
        FragmentTransaction fragmentTransaction= getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragmentContainer, mainFragment).commit();

        overlap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment overlapFragment = new OverlapFragment();
                FragmentTransaction fragmentTransaction= getFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.fragmentContainer, overlapFragment).addToBackStack(null).commit();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment deleteFragment = new DeleteFragment();
                FragmentTransaction fragmentTransaction= getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer, deleteFragment).commitAllowingStateLoss();
            }
        });
    }
}
