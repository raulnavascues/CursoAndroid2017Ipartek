package com.example.arrow.apppersistencia05peliculas;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Pelicula> peliculasArrayList;
    private ArrayAdapter<Pelicula> peliculaArrayAdapter;
    private ListView peliculasListView;

    private  int REQUEST_CODE_PELICULA_ACTIVITY = 1;
    AlmacenPeliculas almacenPeliculas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        almacenPeliculas  = new SQLiteAlmacenPeliculas(this);

        peliculasArrayList = almacenPeliculas.getPeliculas();
        peliculaArrayAdapter = new ArrayAdapter<Pelicula>(this, R.layout.peliculas_list_view_item,
                R.id.titulo_pelicula_list_item, peliculasArrayList);

        peliculasListView = (ListView) findViewById(R.id.peliculas_list_view);
        peliculasListView.setAdapter(peliculaArrayAdapter);

        peliculasListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pelicula pelicula = (Pelicula)parent.getItemAtPosition(position);
                Intent intent = new Intent(view.getContext(),PeliculasActivity.class);
                intent.putExtra(PeliculasActivity.EXTRA_ID_PELICULA,pelicula.getId());
                startActivityForResult(intent,REQUEST_CODE_PELICULA_ACTIVITY);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PELICULA_ACTIVITY){
            if(resultCode == RESULT_OK){
                peliculasArrayList = almacenPeliculas.getPeliculas();
                peliculaArrayAdapter = new ArrayAdapter<Pelicula>(this, R.layout.peliculas_list_view_item,
                        R.id.titulo_pelicula_list_item, peliculasArrayList);
                peliculasListView.setAdapter(peliculaArrayAdapter);
                //peliculaArrayAdapter.notifyDataSetChanged();
            }
        }
        //super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_peliculas, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_pelicula_menu:
                // Abrir la actividad 2
                Intent intentPeliculaActivity = new Intent(this, PeliculasActivity.class);
                startActivityForResult(intentPeliculaActivity,REQUEST_CODE_PELICULA_ACTIVITY);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
