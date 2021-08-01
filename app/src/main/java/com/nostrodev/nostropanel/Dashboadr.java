package com.nostrodev.nostropanel;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nostrodev.nostropanel.adapter.ListItemAdapter;
import com.nostrodev.nostropanel.model.ListItem;

import java.util.ArrayList;
import java.util.List;

public class Dashboadr extends AppCompatActivity {

    RecyclerView dashMenuRecycler;
    ListItemAdapter listItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboadr);

        List<ListItem> itemsList = new ArrayList<>();
        itemsList.add(new ListItem(1,"Сведения о системе", "Здесь будут сведения о системе"));
        itemsList.add(new ListItem(2, "Время работы", "Здесь будет время работы"));
        itemsList.add(new ListItem(3, "Место на диске", "Здесь будет место на диске"));
        itemsList.add(new ListItem(4, "Developing", "Developing"));
        itemsList.add(new ListItem(5, "Developing", "Developing"));
        itemsList.add(new ListItem(6, "Developing", "Developing"));
        itemsList.add(new ListItem(7, "Developing", "Developing"));
        itemsList.add(new ListItem(8, "Developing", "Developing"));
        itemsList.add(new ListItem(9, "Developing", "Developing"));

        setListItemRecycler(itemsList);
    }

    private void setListItemRecycler(List<ListItem> itemsList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        dashMenuRecycler = findViewById(R.id.dashMenuRecycler);
        listItemAdapter = new ListItemAdapter(this, itemsList);
        dashMenuRecycler.setLayoutManager(layoutManager);
        dashMenuRecycler.setAdapter(listItemAdapter);

    }

}