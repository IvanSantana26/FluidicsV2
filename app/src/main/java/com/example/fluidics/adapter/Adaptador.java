package com.example.fluidics.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fluidics.R;

import java.util.List;

public class Adaptador extends BaseAdapter {

    Context contexto;
    List<Datos> ListaObjetos;

    public Adaptador(Context contexto, List<Datos> listaObjetos) {
        this.contexto = contexto;
        ListaObjetos = listaObjetos;
    }

    @Override
    public int getCount() {
        return ListaObjetos.size(); //Cantidad de elementos de la lista
    }

    @Override
    public Object getItem(int position) {
        return ListaObjetos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return ListaObjetos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       View vista = convertView;

        LayoutInflater inflate = LayoutInflater.from(contexto);
        vista = inflate.inflate(R.layout.itemlistview,null);

        ImageView imagen = (ImageView)vista.findViewById(R.id.imagenlogo);
        TextView titulo = (TextView)vista.findViewById(R.id.textDia);
        TextView fecha = (TextView)vista.findViewById(R.id.textFecha);
        TextView cantidad = (TextView)vista.findViewById(R.id.textCantidad);

      titulo.setText(ListaObjetos.get(position).getDia().toString());
      fecha.setText(ListaObjetos.get(position).getFecha().toString());
      cantidad.setText(ListaObjetos.get(position).getCantidad().toString());
      imagen.setImageResource(ListaObjetos.get(position).getImagen());

      return vista;
    }
}
