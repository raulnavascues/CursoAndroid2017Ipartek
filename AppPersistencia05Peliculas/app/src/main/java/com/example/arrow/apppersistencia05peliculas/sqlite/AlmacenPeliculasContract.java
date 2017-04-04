package com.example.arrow.apppersistencia05peliculas.sqlite;

import android.provider.BaseColumns;

/**
 * Created by ARROW on 03/04/2017.
 */

public class AlmacenPeliculasContract {

    private AlmacenPeliculasContract(){

    }

    public static class AlmacenPeliculasEntry implements BaseColumns {
        public static  final String TABLA ="Peliculas";
        public static final String TITULO ="Titulo";
    }
}
