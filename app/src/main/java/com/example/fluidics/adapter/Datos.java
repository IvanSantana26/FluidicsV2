package com.example.fluidics.adapter;

public class Datos {


    private int id;
    private String dia;
    private String fecha;
    private int imagen;

    public Datos(int id, String dia, String fecha, int imagen) {
        this.id = id;
        this.dia = dia;
        this.fecha = fecha;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
