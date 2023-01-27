package com.example.toastymoustachebrotherhood;

public class recetas {
   private String nombre,descripcion,enlace,ingredientes,pasos,tipo;

    public recetas(String nombre, String descripcion, String enlace, String ingredientes, String pasos,String tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.enlace = enlace;
        this.ingredientes = ingredientes;
        this.pasos = pasos;
        this.tipo=tipo;
    }

    public recetas(){

    }

    public recetas(String nombre) {
        this.nombre = nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public recetas(String nombre, String descripcion,String tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo=tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void setPasos(String pasos) {
        this.pasos = pasos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEnlace() {
        return enlace;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public String getPasos() {
        return pasos;
    }
}
