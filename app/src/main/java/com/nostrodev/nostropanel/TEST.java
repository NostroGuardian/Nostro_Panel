package com.nostrodev.nostropanel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class TEST extends AppCompatActivity {

    Button btnTest;
    TextView testText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        btnTest = (Button) findViewById(R.id.btnTest);
        testText = (TextView) findViewById(R.id.testText);

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new getUptime().execute();
            }
        });
    }

    public class getUptime extends AsyncTask<URL, Void, String> {

        @Override
        protected String doInBackground(URL... urls) {
            URL url = null;
            try {
                url = new URL("https://nstrdv.ml/api/uptime.php");
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
            //bufferedReader.close();
            inputLine = input.toString();
            Log.d("[GET UPTIME]", "get uptime error. input = " + input);
            return inputLine;
        }

        @Override
        protected void onPostExecute(String inputLine) {
            testText.setText(inputLine);
        }
    }

}