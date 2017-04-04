package com.example.arrow.app01peliculas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
        PeliculasAdapter peliculaAdapter;

        peliculas.add(new Pelicula("1898 Los ultimos de Filipinas","2016","España",180,R.drawable.los_ultimos_de_filipinas_mini));
        peliculas.add(new Pelicula("Moana","2017","USA",170,"","","",R.drawable.moana_mini,R.drawable.moana));
        peliculas.add(new Pelicula("Villaviciosa de al lado","2016","España",120,R.drawable.villaviciosa_de_al_lado_mini));
        ListView lista = (ListView) findViewById(R.id.list_view_peliculas);

        peliculaAdapter = new PeliculasAdapter(this, peliculas );

        lista.setAdapter(peliculaAdapter);
    }
}
