package com.nostrodev.nostropanel;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nostrodev.nostropanel.adapter.ListItemAdapter;
import com.nostrodev.nostropanel.model.ListItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Dashboadr extends AppCompatActivity {

    RecyclerView dashMenuRecycler;
    ListItemAdapter listItemAdapter;
    String stringSysinfo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboadr);

        new getSysinfo().execute();

        List<ListItem> itemsList = new ArrayList<>();
        itemsList.add(new ListItem(1,"Сведения о системе", stringSysinfo));
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

    public class getSysinfo extends AsyncTask<URL, Void, String> {

        @Override
        protected String doInBackground(URL... urls) {
            URL url = null;
            try {
                url = new URL("https://nstrdv.ml/api/sysinfo.php");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            StringBuilder input = new StringBuilder();
            String inputLine = null;
            while (true) {
                try {
                    if (!((inputLine = bufferedReader.readLine()) != null)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                input.append(inputLine);
            }
            inputLine = input.toString();
            Log.d("[GET UPTIME]", "get sysinfo error. input = " + input);
            return inputLine;
        }

        @Override
        protected void onPostExecute(String inputLine) {
            stringSysinfo = inputLine;
        }
    }

}