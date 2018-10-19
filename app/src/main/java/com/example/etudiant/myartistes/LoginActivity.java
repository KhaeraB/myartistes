package com.example.etudiant.myartistes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.etudiant.myartistes.WebService.Webservice;
import com.example.etudiant.myartistes.interfaces.WsListener;
import com.github.kittinunf.fuel.core.Request;
import com.github.kittinunf.fuel.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;


public class LoginActivity extends AppCompatActivity implements WsListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        final Webservice wsService = new Webservice();
        final HashMap<String, String> params = new HashMap<>();

        final EditText edEmail = findViewById(R.id.email);
        final EditText edPassword = findViewById(R.id.password);

        Button addAccount = (Button)findViewById(R.id.signup);
        addAccount.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, SinUpActivity.class);
                startActivity(i);
            }
        });

        Button log = (Button)findViewById(R.id.loginbutton);
        log.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                String emailValue = edEmail.getText().toString();
                String passwordValue = edPassword.getText().toString();

                params.put("login", emailValue);
                params.put("pass", passwordValue);

                wsService.sendRequest(1, "ws/resto/connexion",params, LoginActivity.this);

                Intent i = new Intent(LoginActivity.this, RecipeActivity.class);
                startActivity(i);
            }
        });
    }


    @Override
    public void errorRequest(int idRequest) {

    }

    @Override
    public void successRequest(int idRequest, String data) {
        Toast.makeText(LoginActivity.this, "connecté", Toast.LENGTH_LONG).show();
    }
}
