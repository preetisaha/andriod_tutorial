package com.android.tutorial.layout_tutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.android.tutorial.layout_tutorial.adapter.ListViewAdapter;
import com.android.tutorial.layout_tutorial.entity.Person;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Person person1 = new Person("Ann", "Smith", "Rivar Falls");
        Person person2 = new Person("Siya", "shell", "New York");
        Person person3 = new Person("Ted", "Mosbi", "Minneapolis");

        List<Person> persons = new ArrayList<>();

        persons.add(person1);
        persons.add(person2);
        persons.add(person3);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView listView = (ListView) findViewById(R.id.listView);
        ListViewAdapter listViewAdapter = new ListViewAdapter(getApplicationContext(), persons);

        listView.setAdapter(listViewAdapter);

        Button button = (Button) findViewById(R.id.click);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToGridView();
            }
        });
    }

    public void goToGridView(){
        Intent intent = new Intent(this, GridViewActivity.class);
        startActivity(intent);
    }
}
