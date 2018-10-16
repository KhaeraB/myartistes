package com.example.etudiant.myartistes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button addAccount = (Button)findViewById(R.id.signup);
        addAccount.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, SinUpActivity.class);
                startActivity(i);
            }
        });
        Button login = (Button)findViewById(R.id.loginbutton);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RecipeActivity.class);
                startActivity(i);
            }
        });
    }




}
