package com.example.etudiant.myartistes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.etudiant.myartistes.WebService.Webservice;
import com.example.etudiant.myartistes.interfaces.WsListener;

import java.util.HashMap;

public class SinUpActivity extends AppCompatActivity implements WsListener{
    Webservice wsService = new Webservice();
    private HashMap<String, String> params = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sinup);

        final EditText edFirstName = findViewById(R.id.firstName);
        final EditText edLastName = findViewById(R.id.lastName);
        final EditText edEmail = findViewById(R.id.email);
        final EditText edPassword = findViewById(R.id.password);




        Button button = (Button)findViewById(R.id.cancelbutton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(SinUpActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        Button send = (Button)findViewById(R.id.createbutton);
            send.setOnClickListener(new View.OnClickListener(){

                public void onClick(View v){
                    String firstNameValue = edFirstName.getText().toString();
                    String lastNameValue = edLastName.getText().toString();
                    String emailValue = edEmail.getText().toString();
                    String passwordValue = edPassword.getText().toString();

                    params.put("prenom", firstNameValue);
                    params.put("nom", lastNameValue);
                    params.put("login", emailValue);
                    params.put("pass", passwordValue);

                    wsService.sendRequest(1, "ws/resto/addCompte",params, SinUpActivity.this);

                    Intent i = new Intent(SinUpActivity.this, LoginActivity.class);
                    startActivity(i);
                }
            });
    }

    @Override
    public void errorRequest(int idRequest) {

    }

    @Override
    public void successRequest(int idRequest, String data) {

    }
}
