package com.example.arrow.apppersistencia05peliculas.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ARROW on 03/04/2017.
 */

public class AlmacenPeliculasSQLiteOpenHelper extends SQLiteOpenHelper {
    public static final int VERSION_BASE_DE_DATOS = 1;
    public static final String NOMBRE_BASE_DE_DATOS = "Peliculas.db";

    public AlmacenPeliculasSQLiteOpenHelper(Context context) {
        super(context, NOMBRE_BASE_DE_DATOS, null, VERSION_BASE_DE_DATOS);
    }

    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + AlmacenPeliculasContract.AlmacenPeliculasEntry.TABLA + "(" +
                AlmacenPeliculasContract.AlmacenPeliculasEntry._ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + AlmacenPeliculasContract.AlmacenPeliculasEntry.TITULO + " TEXT NOT NULL)");

        db.execSQL("INSERT INTO " + AlmacenPeliculasContract.AlmacenPeliculasEntry.TABLA +" ("
                + AlmacenPeliculasContract.AlmacenPeliculasEntry.TITULO +") Values (' Pellicula 1')");
        db.execSQL("INSERT INTO " + AlmacenPeliculasContract.AlmacenPeliculasEntry.TABLA +" ("
                + AlmacenPeliculasContract.AlmacenPeliculasEntry.TITULO +") Values (' Pellicula 2')");
        db.execSQL("INSERT INTO " + AlmacenPeliculasContract.AlmacenPeliculasEntry.TABLA +" ("
                + AlmacenPeliculasContract.AlmacenPeliculasEntry.TITULO +") Values (' Pellicula 3')");
    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     * <p>
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
