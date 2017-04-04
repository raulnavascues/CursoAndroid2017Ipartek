package com.example.arrow.apppersistencia05peliculas;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by ARROW on 30/03/2017.
 */

public class MemoriaAlmacenPeliculas implements AlmacenPeliculas {
    private static  ArrayList<Pelicula> arrayListPeliculas;
private static int siguienteID = 1;




    @Override
    public boolean savePelicula(Pelicula p) {
        if (p.getId() == -1){
            p.setId(siguienteID++);
            arrayListPeliculas.add(p);
        }else{
            for (Pelicula pelicula: arrayListPeliculas){
                if(pelicula.getId() == p.getId()){
                    pelicula.setTitulo(p.getTitulo());
                }
            }
        }
        return true;
    }

    @Override
    public boolean deletePelicula(Pelicula p) {
        return false;
    }

    @Override
    public Pelicula getPelicula(int id) {
        for (Pelicula pelicula: arrayListPeliculas){
            if(pelicula.getId() == id){
                return pelicula;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Pelicula> getPeliculas() {
        if (arrayListPeliculas == null) {
            arrayListPeliculas = new ArrayList<Pelicula>();

            savePelicula(new Pelicula( "Pellicula 1"));
            savePelicula(new Pelicula( "Pellicula 2"));
            savePelicula(new Pelicula( "Pellicula 3"));
            savePelicula(new Pelicula("Pellicula 4"));
            savePelicula(new Pelicula("Pellicula 5"));
            savePelicula(new Pelicula( "Pellicula 6"));
            savePelicula(new Pelicula("Pellicula 7"));
            savePelicula(new Pelicula( "Pellicula 8"));
        }
        return arrayListPeliculas;
    }

    @Override
    public ArrayList<Pelicula> getPeliculas(int offset, int count) {

        return null;
    }
}
