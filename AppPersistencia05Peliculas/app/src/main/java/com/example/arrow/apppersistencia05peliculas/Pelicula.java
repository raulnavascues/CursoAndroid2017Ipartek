package com.example.arrow.apppersistencia05peliculas;

public class Pelicula {
    private int id;
    private String titulo;

    protected Pelicula(int id,String titulo) {
        this.id=id;
        this.titulo = titulo;
    }

    public Pelicula(String titulo) {
        this.id=-1;
        this.titulo = titulo;
    }

    public Pelicula() {
        this.id=-1;
        this.titulo = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return this.titulo;
    }
}
