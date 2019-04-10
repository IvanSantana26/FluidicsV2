package com.example.fluidics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fluidics.models.entities.Usuario;

import java.util.ArrayList;
import java.util.List;
public class Login extends AppCompatActivity {
    Button registro;
    Button logIn;
    List<Usuario> usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Usuario u1 = new Usuario();
        Usuario u2 = new Usuario();
        Usuario u3 = new Usuario();
        Usuario u4 = new Usuario();
        Usuario u5 = new Usuario();
        Usuario u6 = new Usuario();

        u1.setId(1);
        u1.setNombre("Ivan");
        u1.setApellido_paterno("Santana");
        u1.setApellido_materno("Santana");
        u1.setEmail("ivan@green.com");
        u1.setPassword("123");

        usuarios=new ArrayList<>();
        usuarios.add(u1);
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
            EditText LecUsuario = (EditText) findViewById(R.id.LecUsuario);
            EditText LecPassword = (EditText) findViewById(R.id.LecPassword);
            System.out.println(LecUsuario.getText());
            for (Usuario usuario : usuarios) {
                if(usuario.getEmail().contentEquals(LecUsuario.getText())){
                    if (usuario.getPassword().contentEquals(LecPassword.getText())){
                        Intent i = new Intent(Login.this, MetricsActivity.class);
                        startActivity(i);
                    }else{
                        Toast toast = Toast.makeText(this, "Error en Contraseña", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }else{
                    Toast toast = Toast.makeText(this, "Error en Email", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }

        });

    }
}
