package com.android.tutorial.layout_tutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.android.tutorial.layout_tutorial.adapter.GridViewAdapter;
import com.android.tutorial.layout_tutorial.entity.Person;

import java.util.ArrayList;
import java.util.List;

public class GridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        List<Person> persons = getData();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        GridView gridView = (GridView) findViewById(R.id.gridView);

        GridViewAdapter gridViewAdapter = new GridViewAdapter(getApplicationContext(), persons);
        gridView.setAdapter(gridViewAdapter);

    }

    public List<Person> getData() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Ann", "Smith", "Rivar Falls"));
        persons.add(new Person("David", "Smith", "Rivar Falls"));
        persons.add(new Person("Aston", "Smith", "Rivar Falls"));
        persons.add(new Person("Gary", "Smith", "Rivar Falls"));
        persons.add(new Person("Alter", "Smith", "Rivar Falls"));
        persons.add(new Person("Wiscon", "Smith", "Rivar Falls"));
        persons.add(new Person("Larry", "Smith", "Rivar Falls"));
        persons.add(new Person("Tom", "Smith", "Rivar Falls"));
        persons.add(new Person("Pom", "Smith", "Rivar Falls"));
        persons.add(new Person("Yom", "Smith", "Rivar Falls"));
        persons.add(new Person("Zom", "Smith", "Rivar Falls"));
        persons.add(new Person("Aom", "Smith", "Rivar Falls"));

        return persons;
    }
}
