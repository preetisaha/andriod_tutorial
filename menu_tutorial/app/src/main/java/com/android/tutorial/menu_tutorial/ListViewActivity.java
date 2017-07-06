package com.android.tutorial.menu_tutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.tutorial.menu_tutorial.adapter.ListViewAdapter;
import com.android.tutorial.menu_tutorial.entity.Person;

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

        ListView list = (ListView) findViewById(R.id.listView);
        ImageView image = (ImageView) findViewById(R.id.imageView);

        registerForContextMenu(list);
        registerForContextMenu(image);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        int id = v.getId();
        if(id == R.id.listView) {
            inflater.inflate(R.menu.context_menu, menu);
        }
        else if(id == R.id.imageView){
            inflater.inflate(R.menu.image_menu, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.editImage){
            Log.v("Image View", "======================================= welcome to Image View ======================================");
        }
        else if (id == R.id.editInfo){
            Log.v("List View", "======================================= welcome to List View ======================================");
        }

        return super.onContextItemSelected(item);
    }
}







