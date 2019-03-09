package com.eseokami.romainrabouan.eseokamijava;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {

    private Button button;
    private EditText emailEditText;
    private EditText passwordEditText;
    private String monJSON;
    private RequestQueue mQueue;
    SharedPreferences settings;

    final String PREFS_LOGIN = "PREFS_LOGIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        settings = getSharedPreferences(PREFS_LOGIN, 0);

        if (settings.getBoolean("TTT", true)) {
            Log.d("Comments","First Time");


        } else {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            finish();
        }


        emailEditText = (EditText) findViewById(R.id.email_edit_text_signin);
        passwordEditText = (EditText) findViewById(R.id.password_edittext_signin);
        String email = emailEditText.getText().toString().replace("@", "%40");
        String pass = passwordEditText.getText().toString();
        String urlString = String.format("http://api.pandfstudio.ovh/login?email=%s&password=%s", email, pass);


        setTitle("Bienvenue sur l'application Eseo Kami !");

        mQueue = Volley.newRequestQueue(this);
        button = (Button) findViewById(R.id.signin_btn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                emailEditText = (EditText) findViewById(R.id.email_edit_text_signin);
                passwordEditText = (EditText) findViewById(R.id.password_edittext_signin);
                final String email = emailEditText.getText().toString().replace("@", "%40");
                final String pass = passwordEditText.getText().toString();
                final String urlString = String.format("http://api.pandfstudio.ovh/login?email=%s&password=%s", email, pass);
                Log.d("EMAIL", urlString);
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, urlString, null,
                        new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                try {

                                    Log.d("ONRESPONSE", "ONRESPONSE");
                                    Boolean success = response.getBoolean("success");
                                    Log.d("SUCCESSVALUE", success.toString());
                                    Log.d("userID",response.getJSONObject("infos").getString("UID"));
                                    Log.d("USERFULLNAME", response.getJSONObject("infos").getString("fullname"));

                                    Log.d("ObjectJSON", response.toString());
                                    if (success == true) {
                                        // Success !

                                        settings.edit().putString("userEmail", emailEditText.getText().toString()).apply();
                                        settings.edit().putString("userID", response.getJSONObject("infos").getString("UID")).apply();
                                        settings.edit().putString("userFullName", response.getJSONObject("infos").getString("fullname")).apply();
                                        openMainActivity();
                                        Log.d("SuccessJSON", "Success");
                                } else {
                                    Log.d("ERRORJSON", "ERROR");
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            error.printStackTrace();
                        }
                    });

                mQueue.add(request);

            }

        });


    }




    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        settings.edit().putBoolean("TTT", false).commit();
        startActivity(intent);
    }



}
