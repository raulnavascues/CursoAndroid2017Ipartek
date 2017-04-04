package com.example.arrow.app01peliculas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_PELICULA = "DETALLE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        PeliculasAdapter peliculaAdapter;

        ListView lista = (ListView) findViewById(R.id.list_view_peliculas);
        peliculaAdapter = new PeliculasAdapter(this, DatosPeliculas.peliculas );

        lista.setAdapter(peliculaAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pelicula pelicula =(Pelicula) parent.getItemAtPosition(position);
                Intent intent = new Intent(view.getContext(), DetalleActivity.class);
                intent.putExtra(DetalleActivity.EXTRA_ID, pelicula.getId());
                startActivity(intent);
                intent = null;
            }
        });
    }
}
