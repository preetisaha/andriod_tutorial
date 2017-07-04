package com.android.tutorial.layout_tutorial.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.tutorial.layout_tutorial.R;
import com.android.tutorial.layout_tutorial.entity.Person;

import java.util.List;

public class GridViewAdapter extends ArrayAdapter<Person> {

    List<Person> persons;
    private Context context;

    public GridViewAdapter(Context context, List<Person> persons) {
        super(context, -1, persons);
        this.context = context;
        this.persons = persons;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View grid = layoutInflater.inflate(R.layout.activity_grid_view_adapter, parent, false);

        Person person = persons.get(position);

        TextView name = grid.findViewById(R.id.name);
        name.setText((CharSequence) person.getName());

        return grid;
    }
}
