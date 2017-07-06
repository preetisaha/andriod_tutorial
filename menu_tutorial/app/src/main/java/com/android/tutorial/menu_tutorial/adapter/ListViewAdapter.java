package com.android.tutorial.menu_tutorial.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.tutorial.menu_tutorial.R;
import com.android.tutorial.menu_tutorial.entity.Person;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<Person> {

    List<Person> persons;
    private Context context;

    public ListViewAdapter(Context context, List<Person> persons) {
        super(context, -1, persons);
        this.context = context;
        this.persons = persons;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.activity_list_view_adapter, parent, false);

        Person person = persons.get(position);

        TextView name = row.findViewById(R.id.name);
        name.setText((CharSequence) person.getName());

        TextView lastName = row.findViewById(R.id.lastName);
        lastName.setText((CharSequence) person.getLastName());

        TextView city = row.findViewById(R.id.city);
        city.setText((CharSequence) person.getCity());

        return row;
    }
}
