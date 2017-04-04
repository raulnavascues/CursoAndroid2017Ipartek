package com.example.arrow.apppersistencia05peliculas;

import java.util.ArrayList;

/**
 * Created by ARROW on 30/03/2017.
 */

public class RemotoAlmacenPeliculas implements AlmacenPeliculas {
    @Override
    public boolean savePelicula(Pelicula p) {
        return true;
    }

    @Override
    public boolean deletePelicula(Pelicula p) {
        return false;
    }

    @Override
    public Pelicula getPelicula(int id) {
        return null;
    }

    @Override
    public ArrayList<Pelicula> getPeliculas() {
        return null;
    }

    @Override
    public ArrayList<Pelicula> getPeliculas(int offset, int count) {
        return null;
    }
}
