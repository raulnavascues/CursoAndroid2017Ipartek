package com.example.arrow.apppersistencia05peliculas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.arrow.apppersistencia05peliculas.sqlite.AlmacenPeliculasContract;
import com.example.arrow.apppersistencia05peliculas.sqlite.AlmacenPeliculasSQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by ARROW on 30/03/2017.
 */

public class SQLiteAlmacenPeliculas implements AlmacenPeliculas {
    private AlmacenPeliculasSQLiteOpenHelper helper;

    public SQLiteAlmacenPeliculas(Context context) {
        this.helper = new AlmacenPeliculasSQLiteOpenHelper(context);
    }

    private Cursor cargarCursor(String condicion, String[] args) {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor;

        String[] projection = {
                AlmacenPeliculasContract.AlmacenPeliculasEntry._ID,
                AlmacenPeliculasContract.AlmacenPeliculasEntry.TITULO,
        };

        String sortOrder = AlmacenPeliculasContract.AlmacenPeliculasEntry._ID + " ASC";

        cursor = db.query(
                AlmacenPeliculasContract.AlmacenPeliculasEntry.TABLA,   // TABLA
                projection,                    // CAMPOS
                condicion,                         //WHERE
                args,                        // Argumentos Where
                null,                       // Group By
                null,                      // Having
                sortOrder                // ORDER
        );
        return cursor;
    }


    @Override
    public boolean savePelicula(Pelicula p) {
        boolean resultado = false;
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(AlmacenPeliculasContract.AlmacenPeliculasEntry.TITULO, p.getTitulo());
        if (p.getId() == -1) {
            // INSERT
            long newRowId = db.insert(AlmacenPeliculasContract.AlmacenPeliculasEntry.TABLA, AlmacenPeliculasContract.AlmacenPeliculasEntry.TITULO, contentValues);

            if (newRowId != -1) {
                p.setId((int) newRowId);
                resultado = true;
            }
        } else {
            //Update
            String selection = AlmacenPeliculasContract.AlmacenPeliculasEntry._ID + " = ?";
            String[] selectionArgs = {Long.toString(p.getId())};
            int count = db.update(AlmacenPeliculasContract.AlmacenPeliculasEntry.TABLA, contentValues, selection, selectionArgs);
            if (count == 1) {
                resultado = true;
            }
        }
        //Cursor cursorPeliculas = cargarCursor(null, null);
        db.close();
        return resultado;
    }

    @Override
    public boolean deletePelicula(Pelicula p) {
        SQLiteDatabase db = helper.getWritableDatabase();
        boolean resultado = false;

        String selection = AlmacenPeliculasContract.AlmacenPeliculasEntry._ID + " = ?";
        String[] selectionArgs = {Long.toString(p.getId())};

        int borrado = db.delete(AlmacenPeliculasContract.AlmacenPeliculasEntry.TABLA, selection, selectionArgs);
        if (borrado == 1) {
            resultado = true;
        }
        db.close();
        return resultado;
    }

    @Override
    public Pelicula getPelicula(int id) {
        Pelicula pelicula = null;

        String condicion = AlmacenPeliculasContract.AlmacenPeliculasEntry._ID + "= ?";

        String[] parametros = {Integer.toString(id)};

        Cursor cursorPeliculas = cargarCursor(condicion, parametros);

        if (cursorPeliculas.moveToFirst()) {
            pelicula = new Pelicula(
                    cursorPeliculas.getInt(cursorPeliculas.getColumnIndex(AlmacenPeliculasContract.AlmacenPeliculasEntry._ID)),
                    cursorPeliculas.getString(cursorPeliculas.getColumnIndex(AlmacenPeliculasContract.AlmacenPeliculasEntry.TITULO))
            );
        }

        return pelicula;
    }

    @Override
    public ArrayList<Pelicula> getPeliculas() {
        Cursor cursorPeliculas = cargarCursor(null, null);
        ArrayList<Pelicula> peliculaArrayList = new ArrayList<Pelicula>();

        if (cursorPeliculas.moveToFirst()) {
            do {
                peliculaArrayList.add(new Pelicula(
                        cursorPeliculas.getInt(cursorPeliculas.getColumnIndex(AlmacenPeliculasContract.AlmacenPeliculasEntry._ID)),
                        cursorPeliculas.getString(cursorPeliculas.getColumnIndex(AlmacenPeliculasContract.AlmacenPeliculasEntry.TITULO))
                ));
            } while (cursorPeliculas.moveToNext());
        }
        cursorPeliculas.close();
        return peliculaArrayList;
    }

    @Override
    public ArrayList<Pelicula> getPeliculas(int offset, int count) {


        return null;
    }
}
