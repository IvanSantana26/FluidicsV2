package com.example.fluidics;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.fluidics.adapter.RegisterRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class Registro extends AppCompatActivity implements View.OnClickListener {
    EditText etnombre, etapp, etapm, etemail, etpassword;
    Button btnregis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        etnombre = findViewById(R.id.editTextnombre);
        etapp = findViewById(R.id.editTextapp);
        etapm = findViewById(R.id.editTextapm);
        etemail = findViewById(R.id.editTextemail);
        etpassword = findViewById(R.id.editTextpass);

        btnregis = findViewById(R.id.btnregist);

        btnregis.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

        final String name = etnombre.getText().toString();
        final String app = etapp.getText().toString();
        final String apm = etapm.getText().toString();
        final String email = etemail.getText().toString();
        final String password = etpassword.getText().toString();

        Response.Listener<String> respoListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if (success) {
                        Intent intent = new Intent(Registro.this, Login.class);
                        Registro.this.startActivity(intent);
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(Registro.this);
                        builder.setMessage("Error en el Registro")
                                .setNegativeButton("Retry", null)
                                .create().show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        RegisterRequest registerRequest = new RegisterRequest(name, app, apm, email, password, respoListener);
        RequestQueue queue = Volley.newRequestQueue(Registro.this);
        queue.add(registerRequest);

    }
}
