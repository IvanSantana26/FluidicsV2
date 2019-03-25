package com.example.fluidics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {
    Button registro;
    Button logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        registro = (Button) findViewById(R.id.btnRegistro);
        logIn = (Button) findViewById(R.id.btnLoggin);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registro = new Intent(Login.this, Registro.class);
                startActivity(registro);
            }
        });

        logIn.setOnClickListener(view -> {
            Intent i = new Intent(Login.this, MetricsActivity.class);
            startActivity(i);
        });

    }
}
