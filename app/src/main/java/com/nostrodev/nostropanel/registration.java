package com.nostrodev.nostropanel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.textclassifier.TextLanguage;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class registration extends AppCompatActivity {

    EditText etLogin, etPassword;
    Button btnReg;

    final String urlReg = "https://nstrdv.ml/api/reg.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etLogin = (EditText) findViewById(R.id.regEditTextTextPersonName);
        etPassword = (EditText) findViewById(R.id.regEditTextTextPassword);
        btnReg = (Button) findViewById(R.id.regButton);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = etLogin.getText().toString();
                String password = etPassword.getText().toString();

                new RegUser().execute(login, password);
            }
        });

    }

    public class RegUser extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {

            String login = strings[0];
            String password = strings[1];

            OkHttpClient okHttpClient = new OkHttpClient();

            RequestBody requestBody = new FormBody.Builder()
                    .add("login", login)
                    .add("password", password)
                    .build();

            Request request = new Request.Builder()
                    .url(urlReg)
                    .post(requestBody)
                    .build();

            Response response = null;

            try {
                response = okHttpClient.newCall(request).execute();
                if (response.isSuccessful()) {
                    String result = response.body().string();
                    if (result.equalsIgnoreCase("login")) {
                        showToast("Вы успешно зарегистрировались!");
                        Intent intent = new Intent(registration.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public void showToast(final String text) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(registration.this, text, Toast.LENGTH_SHORT).show();
            }
        });
    }

}