package com.example.fluidics;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.example.fluidics.adapter.Adaptador;
import com.example.fluidics.adapter.Datos;

import java.util.ArrayList;

public class DescripcionO extends AppCompatActivity {
    ListView ListaDatos;
    ArrayList<Datos> Lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_o);

        ListaDatos = (ListView) findViewById(R.id.lstDatos);

        Lista = new ArrayList<Datos>();

        Lista.add(new Datos(1, "Lunes", "01/04/2019", "25gr", R.drawable.o2));
        Lista.add(new Datos(2, "Martes", "02/04/2019", "15gr", R.drawable.o2));
        Lista.add(new Datos(3, "Miercoles", "03/04/2019", "27gr", R.drawable.o2));
        Lista.add(new Datos(4, "Jueves", "04/04/2019", "6gr", R.drawable.o2));
        Lista.add(new Datos(5, "Viernes", "05/04/2019", "28gr", R.drawable.o2));
        Lista.add(new Datos(6, "Sabado", "06/04/2019", "8gr", R.drawable.o2));
        Lista.add(new Datos(7, "Domingo", "07/04/2019", "25gr", R.drawable.o2));

        Adaptador miadaptador = new Adaptador(getApplicationContext(), Lista);

        ListaDatos.setAdapter(miadaptador);
        setUpToolbar();
    }

    public void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(v->{
            startActivity(new Intent(this, MetricsActivity.class));
            finish();
        });
    }

}
