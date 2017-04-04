package com.example.arrow.apppersistencia05peliculas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class PeliculasActivity extends AppCompatActivity {
    public static final String EXTRA_ID_PELICULA = "extra_id_pelicula";
    private boolean modoEdicion = false;
    private AlmacenPeliculas almacenPeliculas;
    private Pelicula pelicula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas);

        Intent intent = getIntent();

        int idPelicula = intent.getIntExtra(EXTRA_ID_PELICULA, -1);
        if (idPelicula != -1) modoEdicion = true;

        almacenPeliculas = new SQLiteAlmacenPeliculas(this);

        if (modoEdicion) {
            pelicula = almacenPeliculas.getPelicula(idPelicula);

            ((EditText) findViewById(R.id.titulo_pelicula_edit_text)).setText(pelicula.getTitulo());

        }
        findViewById(R.id.guardar_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (modoEdicion) {
                    pelicula.setTitulo(((EditText) findViewById(R.id.titulo_pelicula_edit_text)).getText().toString());
                    almacenPeliculas.savePelicula(pelicula);

                } else {

                    almacenPeliculas.savePelicula(new Pelicula(((EditText) findViewById(R.id.titulo_pelicula_edit_text)).getText().toString()));
                }
                setResult(RESULT_OK);
                finish();
            }
        });
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if(!modoEdicion){
            menu.removeItem(R.id.borrar_menu_item);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_borrar_pelicula, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.borrar_menu_item:
                almacenPeliculas.deletePelicula(pelicula);
                setResult(RESULT_OK);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
