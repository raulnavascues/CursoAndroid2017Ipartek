package com.example.arrow.app01peliculas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetalleActivity extends AppCompatActivity {
    public static final String EXTRA_ID ="EXTRA_ID";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        Intent intent = getIntent();

        long id = intent.getLongExtra(EXTRA_ID,-1);

        Toast.makeText(this,Long.toString(id),Toast.LENGTH_LONG).show();
        if (id> -1 ) {
            for (int i =0; i< DatosPeliculas.peliculas.size();i++){
                Pelicula pelicula = DatosPeliculas.peliculas.get(i);

                if(pelicula.getId() == id){
                    // Muestro los datoa
                    ((TextView) findViewById(R.id.text_view_titulo_lista)).setText(pelicula.getTitulo());
                    ((TextView) findViewById(R.id.text_view_anyo_lista)).setText(pelicula.getAnio());
                    ((TextView) findViewById(R.id.text_view_duraccion)).setText(String.valueOf(pelicula.getDuraccion()));
                    ((ImageView) findViewById(R.id.image_cartel)).setImageResource(pelicula.getCaratula());
                    ((TextView) findViewById(R.id.text_view_pais_lista)).setText(pelicula.getPais());
                    ((TextView) findViewById(R.id.text_view_director)).setText(pelicula.getDirector());
                    ((TextView) findViewById(R.id.text_view_guion)).setText(pelicula.getGuinista());
                    ((TextView) findViewById(R.id.text_view_sipnosis)).setText(pelicula.getSipnosis());
                    break;
                }
            }
        }
    }
}
