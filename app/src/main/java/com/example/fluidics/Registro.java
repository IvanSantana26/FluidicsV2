package com.example.fluidics;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.fluidics.adapter.RegisterRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/*
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
*/

public class Registro extends AppCompatActivity {
    private EditText name, app, apm, email, password;
    private Button btnregist;
  //  private ProgressBar loading;
    private static String URL_REGIST = "http://192.168.100.45:8080/Registro/carrito.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

      //  loading = findViewById(R.id.loading);
        name =  findViewById(R.id.name);
        app = findViewById(R.id.app);
        apm = findViewById(R.id.apm);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

     btnregist = findViewById(R.id.btnregist);

        btnregist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Regist();
            }
        });


    }

    private void Regist() {
        //loading.setVisibility(View.VISIBLE);
        btnregist.setVisibility(View.GONE);

        final String name = this.name.getText().toString().trim();
        final String app = this.app.getText().toString().trim();
        final String apm = this.apm.getText().toString().trim();
        final String email = this.email.getText().toString().trim();
        final String password = this.password.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REGIST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");

                            if (success.equals("1")) {

                                Toast.makeText(Registro.this, "Registro Hecho", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(Registro.this, "Registro Error! " + e.toString(), Toast.LENGTH_SHORT).show();
                       //     loading.setVisibility(View.GONE);
                            btnregist.setVisibility(View.VISIBLE);

                        }
                    }
                },
                new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Registro.this, "Registro Error! " + error.toString(), Toast.LENGTH_LONG).show();
             //   loading.setVisibility(View.GONE);
                btnregist.setVisibility(View.VISIBLE);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name", name);
                params.put("app", app);
                params.put("apm", apm);
                params.put("email", email);
                params.put("password", password);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }
}




