package com.example.fluidics.element;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.fluidics.R;
import com.example.fluidics.adapter.Adaptador;
import com.example.fluidics.adapter.Datos;

import java.util.ArrayList;

public class listMetric extends AppCompatActivity {
    ListView ListaDatos;
    ArrayList<Datos> Lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListaDatos = (ListView)findViewById(R.id.lstDatos);

        Lista = new ArrayList<Datos>();

        Lista.add(new Datos(1,"Lunes","01/04/2019",R.drawable.rayo));
        Lista.add(new Datos(2,"Martes","02/04/2019",R.drawable.rayodos));
        Lista.add(new Datos(3,"Miercoles","03/04/2019",R.drawable.rayo));
        Lista.add(new Datos(4,"Jueves","04/04/2019",R.drawable.rayodos));
        Lista.add(new Datos(5,"Viernes","05/04/2019",R.drawable.rayo));
        Lista.add(new Datos(6,"Sabado","06/04/2019",R.drawable.rayo));
        Lista.add(new Datos(7,"Domingo","07/04/2019",R.drawable.rayodos));

        Adaptador miadaptador = new Adaptador(getApplicationContext(),Lista);

        ListaDatos.setAdapter(miadaptador);
    }
}
