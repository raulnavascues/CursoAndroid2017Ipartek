package com.example.arrow.apppersistencia05peliculas;


import java.util.ArrayList;

public interface AlmacenPeliculas {

    public abstract boolean savePelicula(Pelicula p);
    public abstract boolean deletePelicula(Pelicula p);
    public abstract Pelicula getPelicula(int id);
    public abstract ArrayList<Pelicula> getPeliculas();
    public abstract ArrayList<Pelicula> getPeliculas(int offset, int count);

}
